package spring.boardgame.registerboardgame.service;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boardgame.registerboardgame.repository.UserRepository;
import spring.boardgame.registerboardgame.repository.LoginsRepository;
import spring.boardgame.registerboardgame.model.json.Login;
import spring.boardgame.registerboardgame.model.User;
import spring.boardgame.registerboardgame.model.Logins;
import java.util.List;
import spring.boardgame.registerboardgame.session.Session;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@Service
public class SessionHandler {
    @Resource(name = "returnSession")
    Session mainsession;
    
    @Autowired
    private UserRepository userrepo; 
    
    @Autowired
    private LoginsRepository loginrep;
    
    @Autowired
    private IpFetcher ipfetcher;
    

    public Login checkLogin(){
        Login login = new Login();
        if(this.mainsession.getUser() != null){
            this.mainsession.getUser().findMaxStatus(login); 
            login.setBrukernavn(this.mainsession.getUser().getBrukernavn());
            return login;
        }else{
            login.setStatus(0);
            login.setUserID(0); 
            return login;
        }
    
    }

    //Something need to be done here, this may cause to many queries if under active hacking attack    
    public Login attemptLogin(Login login, HttpServletRequest request){
        
        Long attempts = this.loginrep.countByUsernameOrIp(login.getBrukernavn(), this.ipfetcher.getClientIp(request));
        
        if(attempts > 5){
            return this.loginFail(login, request,false);
        }else if(this.mainsession.getUser() != null){
            login.setErrormessage("Du er allerede logget inn.");
            return login;
        }else if(login.getPassword() == null || login.getPassword().trim().length() < 3){
            login.setErrormessage("Du må fylle ut et passord.");
            return login;
        }else{          
            List<User> users = userrepo.findByBrukernavnAndPassord(login.getBrukernavn(), login.getPassword());
            if(users.size() == 1){
                User loggedin = users.get(0);
                loggedin.findMaxStatus(login);               
                this.mainsession.setUser(loggedin);
                return login;
            }else{
                return this.loginFail(login, request,true);
            }
        }

    }
    
    private Login loginFail(Login login, HttpServletRequest request, boolean store){
        login.setErrormessage("Du ut fylte og feil brukernavn og/eller passord. Vennligst forsøk igjen.");
        if(store)
            this.loginrep.save(new Logins(new Date(), this.ipfetcher.getClientIp(request), login.getBrukernavn()));
        return login;
    
    }

    
}

package spring.boardgame.registerboardgame.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boardgame.registerboardgame.repository.UserRepository;
import spring.boardgame.registerboardgame.model.json.Login;
import spring.boardgame.registerboardgame.model.User;
import spring.boardgame.registerboardgame.model.UserRole;
import spring.boardgame.registerboardgame.model.Role;
import java.util.List;
import spring.boardgame.registerboardgame.session.Session;
import spring.boardgame.registerboardgame.session.SessionConfiguration;
import javax.annotation.Resource;


@Service
public class SessionHandler {
    @Resource(name = "returnSession")
    Session mainsession;
    
    @Autowired
    private UserRepository userrepo;   
    
    
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

    
    public Login attemptLogin(Login login){

        
        if(this.mainsession.getUser() != null){
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
                login.setErrormessage("Du fylte og feil brukernavn og/eller passord. Vennligst forsøk igjen.");
                return login;
            }
        }

    }

    
}

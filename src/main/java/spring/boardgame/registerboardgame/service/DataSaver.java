package spring.boardgame.registerboardgame.service;

import javax.persistence.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.StreamSupport;
import javax.annotation.Resource;
import spring.boardgame.registerboardgame.repository.*;
import spring.boardgame.registerboardgame.model.*;
import spring.boardgame.registerboardgame.session.Session;

/**
 *
 * @author stevi
 */
@Service
public class DataSaver {
    
    @Autowired
    private PlayerRepository playerrepo;
    
    @Autowired
    private UserRepository userrepo;
    
    @Autowired
    private GameRepository gamerepo;
    
    @Autowired
    private SelskapRepository selskaprepo;
    
    @Autowired 
    private GameSessionRepository gamenightrepo;
    
    @Autowired
    DataFetcher fetcher;
    
    @Resource(name = "returnSession")
    Session mainsession;
    
    public User savePlayer(User newPlayer, User oldPlayer){
    
        String newPassword = newPlayer.getPassord();
        if(newPassword != null && !newPassword.equals("")){
            oldPlayer.setPassord(newPassword);
        }
        oldPlayer.setBrukernavn(newPlayer.getBrukernavn());
        oldPlayer.setFornavn(newPlayer.getFornavn());
        oldPlayer.setEtternavn(newPlayer.getEtternavn());
        
        oldPlayer.setEpost(newPlayer.getEpost());
        
        return userrepo.save(oldPlayer);

    }
    
    public Selskap createOrUpdateSelskap(Selskap selskap){
        return selskaprepo.save(selskap);
    }
    
    public Game createGame(Game newGame){
        return this.gamerepo.save(newGame);
    }
    
    public Game saveGame(Game newGame){
        return this.gamerepo.save(newGame);
    }

    public Gamesession SaveGamesession(Gamesession newSession){
    
        newSession.setRegistrar(this.fetcher.fetchPlayer(this.mainsession.getUser().getId()));
        this.gamenightrepo.save(newSession);
        return newSession;
    }
    
    public User createPlayer(User newPlayer){
        String newPassword = newPlayer.getPassord();
        if(newPassword != null && !newPassword.equals("")){
            newPlayer.setPassord(newPassword);
        }
        
        return this.userrepo.save(newPlayer);
       
    }
    
}

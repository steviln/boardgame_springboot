package spring.boardgame.registerboardgame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.boardgame.registerboardgame.model.Player;
import spring.boardgame.registerboardgame.model.User;
import spring.boardgame.registerboardgame.model.dto.CompletePlayerDataDTO;
import spring.boardgame.registerboardgame.service.DataFetcher;
import spring.boardgame.registerboardgame.service.DataSaver;
import spring.boardgame.registerboardgame.service.mapping.MappingGamesessionService;

@RestController
@RequestMapping("rest/player")
public class PlayerController {
    
    private final String crossorg = "http://localhost:4200/";
    
    @Autowired
    DataFetcher fetcher;
    
    @Autowired
    DataSaver saver;  
    
    @Autowired
    MappingGamesessionService gamesessionservice;
    
        
    @GetMapping(value = "playerlist",produces = "application/json")
    @CrossOrigin(origins = crossorg)
    public Iterable getList() {        
        return fetcher.fetchPlayerList();
    }    
        
    @GetMapping(value = "frontpageplayerlist",produces = "application/json")
    @CrossOrigin(origins = crossorg)
    public Iterable getFrontpagePlayers() {        
        return fetcher.fetchFrontpagePlayerList();
    }    
        
    @GetMapping(value = "player")
    @CrossOrigin(origins = crossorg)
    public Player getPlayer(@RequestParam Long id){
        return fetcher.fetchPlayer(id);
    }   
        
    @PreAuthorize("hasPermission(#id, 'Player', 'private')")
    @GetMapping(value = "editplayer")
    @CrossOrigin(origins = crossorg)
    public User getEditPlayerAuthorize(@RequestParam Long id){
        return fetcher.fetchUser(id);
    }
    
    @PreAuthorize("hasPermission(#id, 'Player', 'private')")
    @PostMapping(value = "editplayer")
    @CrossOrigin(origins = crossorg)
    public User postEditPlayerAuthorize(@RequestBody User payload){
        if(payload.getId() == null){
            payload = saver.createPlayer(payload);
        }else{
            User storedPlayer = fetcher.fetchUser(payload.getId());
            payload = saver.savePlayer(payload, storedPlayer);
        }
        return payload;
    }
              
    @GetMapping(value = "limitedplayerlist",produces = "application/json")
    @CrossOrigin(origins = crossorg)
    public Iterable getPlayerList() {        
        return fetcher.fetchPlayerListDisplay();
    }       
    
    @GetMapping(value = "completeplayer")
    @CrossOrigin(origins = crossorg)
    public CompletePlayerDataDTO getCompletePlayer(@RequestParam Long id){
        return fetcher.fetchCompletePlayerData(id);
    }
    
}

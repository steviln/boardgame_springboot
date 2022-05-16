package spring.boardgame.registerboardgame.controllers;

import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.boardgame.registerboardgame.service.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import spring.boardgame.registerboardgame.model.Player;



@RestController
@RequestMapping("rest")
public class MainController {
    
    private final String crossorg = "http://localhost:4200/";
    
    @Autowired
    DataFetcher fetcher;
    
    @GetMapping(value = "frontpageall",produces = "application/json")
    @CrossOrigin(origins = crossorg)
    public HashMap<String,Iterable> getTest() {        
        return fetcher.fetchGameList();
    }
    
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
    
    @GetMapping(value = "gameslist",produces = "application/json")
    @CrossOrigin(origins = crossorg)
    public Iterable getFrontpageGames() {        
        return fetcher.fetchFrontpageGamesList();
    }
    
    @GetMapping(value = "player")
    @CrossOrigin(origins = crossorg)
    public Player getPlayer(@RequestParam Long id){
        return fetcher.fetchPlayer(id);
    }
    
    
    @GetMapping(value = "limitedplayerlist",produces = "application/json")
    @CrossOrigin(origins = crossorg)
    public Iterable getPlayerList() {        
        return fetcher.fetchPlayerListDisplay();
    }


}

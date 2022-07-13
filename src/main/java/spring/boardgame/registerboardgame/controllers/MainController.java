package spring.boardgame.registerboardgame.controllers;

import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.boardgame.registerboardgame.service.DataFetcher;
import spring.boardgame.registerboardgame.service.DataSaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import spring.boardgame.registerboardgame.model.*;
import org.springframework.security.access.prepost.PreAuthorize;
import spring.boardgame.registerboardgame.model.dto.FactionRankingDTO;
import spring.boardgame.registerboardgame.session.Session;
import spring.boardgame.registerboardgame.service.mapping.MappingGamesessionService;
import spring.boardgame.registerboardgame.model.dto.CompleteGameDataDTO;


// Need to check what happens if something goes completely wrong


@RestController
@RequestMapping("rest")
public class MainController {
    
    private final String crossorg = "http://localhost:4200/";
    
    @Autowired
    DataFetcher fetcher;
    
    @Autowired
    DataSaver saver;  
    
    @Autowired
    MappingGamesessionService gamesessionservice;

    
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
    
    @GetMapping(value = "selskaplist",produces = "application/json")
    @CrossOrigin(origins = crossorg)
    public Iterable<Selskap> getSelskapList() {        
        return fetcher.fetchSelskap();
    }
    
    @PreAuthorize("hasPermission(#id, 'Selskap', 'general')")
    @PostMapping(value = "selskaplist",produces = "application/json")
    @CrossOrigin(origins = crossorg)
    public Iterable<Selskap> postSelskap(@RequestBody Selskap payload) { 
        saver.createOrUpdateSelskap(payload);
        return fetcher.fetchSelskap();
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
    
    @GetMapping(value = "games",produces = "application/json")
    @CrossOrigin(origins = crossorg)
    public List<GameList> getGames() {        
        return fetcher.fetchGames();
    }
    
    @GetMapping(value = "game",produces = "application/json")
    @CrossOrigin(origins = crossorg)
    public Game getGame(@RequestParam Long id) {        
        return fetcher.fetchGame(id);
    }
    
    @GetMapping(value = "gamesession",produces = "application/json")
    @CrossOrigin(origins = crossorg)
    public Gamesession getGamesession(@RequestParam Long id){
        return fetcher.fetchSession(id);
    }
    
    @PreAuthorize("hasPermission(#id, 'Gamesession', 'general')")
    @PostMapping(value = "gamesession",produces = "application/json")
    @CrossOrigin(origins = crossorg)
    public Gamesession saveGamesession(@RequestBody Gamesession payload){
        return saver.SaveGamesession(payload);
    }
    
    @GetMapping(value = "gamesessionlist",produces = "application/json")
    @CrossOrigin(origins = crossorg)
    public Iterable<SessionList> getGamesessionList(){
        return fetcher.fetchSessionList();
    }
    
    @GetMapping(value = "player")
    @CrossOrigin(origins = crossorg)
    public Player getPlayer(@RequestParam Long id){
        return fetcher.fetchPlayer(id);
    }
    
    @PreAuthorize("hasPermission(#id, 'Player', 'private')")
    @GetMapping(value = "editplayer")
    @CrossOrigin(origins = crossorg)
    public Player getEditPlayerAuthorize(@RequestParam Long id){
        return fetcher.fetchPlayer(id);
    }
    
    @PreAuthorize("hasPermission(#id, 'Player', 'private')")
    @PostMapping(value = "editplayer")
    @CrossOrigin(origins = crossorg)
    public Player postEditPlayerAuthorize(@RequestBody Player payload){
        if(payload.getId() == null){
            payload = saver.createPlayer(payload);
        }else{
            Player storedPlayer = fetcher.fetchPlayer(payload.getId());
            payload = saver.savePlayer(payload, storedPlayer);
        }
        return payload;
    }
    
    @PreAuthorize("hasPermission(#id, 'Game', 'general')")
    @PostMapping(value = "game")
    @CrossOrigin(origins = crossorg)       
    public Game postEditGameAuthorize(@RequestBody Game payload){
        return saver.saveGame(payload);
    }
    
    
    @GetMapping(value = "limitedplayerlist",produces = "application/json")
    @CrossOrigin(origins = crossorg)
    public Iterable getPlayerList() {        
        return fetcher.fetchPlayerListDisplay();
    }
    
    @GetMapping(value = "userbyid", produces = "application/json")
    @CrossOrigin(origins = crossorg)
    public User getUserById(@RequestParam Long id){
        return fetcher.fetchUser(id);
    }
    
    @GetMapping(value = "factionrankings", produces = "application/json")
    @CrossOrigin(origins = crossorg)
    public CompleteGameDataDTO getFactionRankingsForGame(@RequestParam Long id){
        //return fetcher.fetchFactionRankingsForGame(new Long(19));
        return fetcher.fetchCompleteGameData(id);
    }
    



}

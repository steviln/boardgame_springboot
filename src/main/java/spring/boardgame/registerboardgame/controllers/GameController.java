package spring.boardgame.registerboardgame.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import spring.boardgame.registerboardgame.model.Game;
import spring.boardgame.registerboardgame.model.GameList;
import spring.boardgame.registerboardgame.service.DataFetcher;
import spring.boardgame.registerboardgame.service.DataSaver;
import spring.boardgame.registerboardgame.service.mapping.MappingGamesessionService;

@RestController
@RequestMapping("rest/game")
public class GameController {
    
    private final String crossorg = "http://localhost:4200/";
    
    @Autowired
    DataFetcher fetcher;
    
    @Autowired
    DataSaver saver;  
    
    @Autowired
    MappingGamesessionService gamesessionservice;
    
        
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

    
    @PreAuthorize("hasPermission(#id, 'Game', 'general')")
    @PostMapping(value = "game")
    @CrossOrigin(origins = crossorg)       
    public Game postEditGameAuthorize(@RequestBody Game payload){
        return saver.saveGame(payload);
    }

    
}

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
import spring.boardgame.registerboardgame.model.Gamesession;
import spring.boardgame.registerboardgame.model.SessionList;
import spring.boardgame.registerboardgame.model.dto.CompleteGameDataDTO;
import spring.boardgame.registerboardgame.service.DataFetcher;
import spring.boardgame.registerboardgame.service.DataSaver;
import spring.boardgame.registerboardgame.service.mapping.MappingGamesessionService;


@RestController
@RequestMapping("rest/gamesession")
public class GamesessionController {
    
    
    private final String crossorg = "http://localhost:4200/";
    
    @Autowired
    DataFetcher fetcher;
    
    @Autowired
    DataSaver saver;  
    
    @Autowired
    MappingGamesessionService gamesessionservice;
    
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
    
    @GetMapping(value = "factionrankings", produces = "application/json")
    @CrossOrigin(origins = crossorg)
    public CompleteGameDataDTO getFactionRankingsForGame(@RequestParam Long id){
        return fetcher.fetchCompleteGameData(id);
    }
    
}

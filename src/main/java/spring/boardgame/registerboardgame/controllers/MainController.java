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
import spring.boardgame.registerboardgame.model.dto.CompletePlayerDataDTO;


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

    
    @GetMapping(value = "userbyid", produces = "application/json")
    @CrossOrigin(origins = crossorg)
    public User getUserById(@RequestParam Long id){
        return fetcher.fetchUser(id);
    }    
    

    



}

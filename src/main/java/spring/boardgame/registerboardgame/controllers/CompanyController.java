package spring.boardgame.registerboardgame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boardgame.registerboardgame.model.Selskap;
import spring.boardgame.registerboardgame.service.DataFetcher;
import spring.boardgame.registerboardgame.service.DataSaver;
import spring.boardgame.registerboardgame.service.mapping.MappingGamesessionService;



@RestController
@RequestMapping("rest/company")
public class CompanyController {
    
    private final String crossorg = "http://localhost:4200/";
    
    @Autowired
    DataFetcher fetcher;
    
    @Autowired
    DataSaver saver;  
    
    @Autowired
    MappingGamesessionService gamesessionservice;
    
        
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
    
}

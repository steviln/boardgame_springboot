package spring.boardgame.registerboardgame.controllers;

import java.util.HashMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boardgame.registerboardgame.service.DataFetcher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;



@RestController
@RequestMapping("rest")
public class MainController {
    
    private final String crossorg = "http://localhost:8080";
    
    @Autowired
    DataFetcher fetcher;
    
    @GetMapping(value = "gameslist",produces = "application/json")
    @CrossOrigin(origins = crossorg)
    public HashMap<String,Iterable> getTest() {        
        return fetcher.fetchGameList();
    }
    
    @GetMapping(value = "playerlist",produces = "application/json")
    @CrossOrigin(origins = crossorg)
    public Iterable getList() {        
        return fetcher.fetchPlayerList();
    }


}

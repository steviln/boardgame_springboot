package spring.boardgame.registerboardgame.controllers;


import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import spring.boardgame.registerboardgame.service.SessionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import spring.boardgame.registerboardgame.model.json.Login;
import spring.boardgame.registerboardgame.session.Session;
import spring.boardgame.registerboardgame.session.SessionConfiguration;


@RestController
@RequestMapping("rest/login")
public class SessionController {
    
    private final String crossorg = "http://localhost:4200/";
    
    @Autowired
    SessionHandler handler;      
    
    @GetMapping(value = "init")
    @CrossOrigin(origins = crossorg)
    public Login getInit() {        
        return handler.checkLogin();
    }
    
    @PostMapping(value = "login", produces = "application/json")
    @CrossOrigin(origins = crossorg)
    public Login attemptLogin(@RequestBody Login payload, HttpServletRequest request) {        
        return handler.attemptLogin(payload, request);
    }
    
}

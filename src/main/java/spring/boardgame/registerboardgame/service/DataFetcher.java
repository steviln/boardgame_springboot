package spring.boardgame.registerboardgame.service;

import javax.persistence.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import spring.boardgame.registerboardgame.model.GameList;
import java.util.List;
import java.util.HashMap;
import java.util.stream.StreamSupport;
import spring.boardgame.registerboardgame.repository.GameListRepository;
import spring.boardgame.registerboardgame.repository.PlayerRankingRepository;
import spring.boardgame.registerboardgame.repository.PlayerRepository;
import spring.boardgame.registerboardgame.model.Player;




@Service
public class DataFetcher {    
    
    @Autowired
    private GameListRepository frontgamelist; 

    @Autowired
    private PlayerRankingRepository frontplayerlist;
    
    @Autowired
    private PlayerRepository playerrepo;
    
    public HashMap<String,Iterable> fetchGameList(){
        HashMap<String,Iterable> returverdi = new HashMap<String,Iterable>();
        returverdi.put("games", this.frontgamelist.findAll());
        returverdi.put("players", this.frontplayerlist.findAll());
        return returverdi;
    }
    
    public Iterable<Player> fetchPlayerList(){
        return this.playerrepo.findAll();
    }
    
}

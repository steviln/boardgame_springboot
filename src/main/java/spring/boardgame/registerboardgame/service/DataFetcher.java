package spring.boardgame.registerboardgame.service;

import javax.persistence.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import spring.boardgame.registerboardgame.model.GameList;
import spring.boardgame.registerboardgame.model.PlayerRanking;
import java.util.List;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.StreamSupport;
import spring.boardgame.registerboardgame.repository.GameListRepository;
import spring.boardgame.registerboardgame.repository.PlayerRankingRepository;
import spring.boardgame.registerboardgame.repository.PlayerRepository;
import spring.boardgame.registerboardgame.repository.PlayerListRepository;
import spring.boardgame.registerboardgame.model.Player;
import spring.boardgame.registerboardgame.model.PlayerList;



@Service
public class DataFetcher {    
    
    @Autowired
    private GameListRepository frontgamelist; 

    @Autowired
    private PlayerRankingRepository frontplayerlist;
    
    @Autowired
    private PlayerRepository playerrepo;
    
    @Autowired
    private PlayerListRepository playerlistrepo;
    
    public HashMap<String,Iterable> fetchGameList(){
        HashMap<String,Iterable> returverdi = new HashMap<String,Iterable>();
        returverdi.put("games", this.frontgamelist.findAll());
        returverdi.put("players", this.frontplayerlist.findAll());
        return returverdi;
    }
    
    public Player fetchPlayer(Long id){
        Optional<Player> result = this.playerrepo.findById(id);
        return result.get();
    }
    
    public Iterable<PlayerRanking> fetchFrontpagePlayerList(){       
        return this.frontplayerlist.findAll();
    }
    
    public Iterable<GameList> fetchFrontpageGamesList(){
        return this.frontgamelist.findAll();
    }
    
    public Iterable<Player> fetchPlayerList(){
        return this.playerrepo.findAll();
    }
    
    public Iterable<PlayerList> fetchPlayerListDisplay(){
        return this.playerlistrepo.findAll();
    }
    
}

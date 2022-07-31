package spring.boardgame.registerboardgame.service;

import java.util.Collections;
import java.util.stream.Collectors;
import javax.persistence.*;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.hibernate.type.SerializationException;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;
import java.util.stream.StreamSupport;
import spring.boardgame.registerboardgame.repository.*;
import spring.boardgame.registerboardgame.model.*;
import spring.boardgame.registerboardgame.model.dto.FactionRankingDTO;
import spring.boardgame.registerboardgame.model.dto.CompleteGameDataDTO;
import spring.boardgame.registerboardgame.service.mapping.MappingGamesessionService;
import spring.boardgame.registerboardgame.model.dto.PlayerRankingDTO;
import spring.boardgame.registerboardgame.privacy.PlayerPrivacyFilter;
import spring.boardgame.registerboardgame.model.dto.CompletePlayerDataDTO;




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
    
    @Autowired
    private GameRepository gamerepo;
    
    @Autowired 
    private SelskapRepository selskaprepo;
    
    @Autowired 
    private GameSessionRepository gamenightrepo;
    
    @Autowired
    private SessionListRepository sessionlistrep;
    
    @Autowired
    private UserRepository userrep;
    
    @Autowired
    private MappingGamesessionService mappingService;
    
    @Autowired
    private PlayerPrivacyFilter privacyfilter;
            
    public HashMap<String,Iterable> fetchGameList(){
        HashMap<String,Iterable> returverdi = new HashMap<String,Iterable>();
        returverdi.put("games", this.frontgamelist.findAll());
        returverdi.put("players", this.frontplayerlist.findAll());
        return returverdi;
    }
    
    public List<Object[]> fetchFactionRankingsForGame(Long id){
        return this.gamenightrepo.findFactionRankings(id);
    }
    
    public User fetchUser(Long id){
        Optional<User> user = this.userrep.findById(id);
        return user.get();
    }
    
    public List<GameList> fetchGames(){

        Iterable<GameList> games = this.frontgamelist.findAll();
        List<GameList> returngames = StreamSupport.stream(games.spliterator(), false).collect(Collectors.toList());
        Collections.sort(returngames);
        return returngames;
        
    }
    
    public Game fetchGame(Long id){
        Optional<Game> result = this.gamerepo.findById(id);
        return result.get();
    }
    
    public Gamesession fetchSession(Long id){
        Gamesession returner = null;
        try{
            Optional<Gamesession> temp = this.gamenightrepo.findById(id);
            returner = temp.get();
        }catch(Exception e){
            System.out.println(e);
        }
         
        return returner;
    }
    
    public Iterable<SessionList> fetchSessionList(){
        return this.sessionlistrep.findAll();
    }
    
    public Player fetchPlayer(Long id){
        Optional<Player> result = this.playerrepo.findById(id);
        return result.get();
    }
    
    public Iterable<PlayerRanking> fetchFrontpagePlayerList(){       
        return this.privacyfilter.filterPlayerFrontpageList(this.frontplayerlist.findAll());
    }
    
    public Iterable<GameList> fetchFrontpageGamesList(){
        return this.frontgamelist.findAll();
    }
    
    public Iterable<Selskap> fetchSelskap(){
        return this.selskaprepo.findAll();
    }
    
    public Iterable<Player> fetchPlayerList(){
        return this.privacyfilter.filterPlayerlist(this.playerrepo.findAll());
    }
    
    public Iterable<PlayerList> fetchPlayerListDisplay(){
        return this.privacyfilter.filterPlayerListList(this.playerlistrepo.findAll());
    }
    
    public CompleteGameDataDTO fetchCompleteGameData(Long id){
         
        CompleteGameDataDTO completeDTO = new CompleteGameDataDTO();
        
        Optional<Game> tempGame = gamerepo.findById(id);
        if(!tempGame.isEmpty()){
            completeDTO.setGame(tempGame.get());
            completeDTO.setPlayerDTO(this.mappingService.findPlayerRankingsForGame(id));
            if(completeDTO.getGame().getFraksjoner().size() > 0){
                completeDTO.setFactionPlayerDTO(this.mappingService.findFactionPlayerRankingsForGame(id));
                completeDTO.setFactionDTO(this.mappingService.findFactionRankingsForGame(id));
            }
        }
        
        return completeDTO;
    }
    
    public CompletePlayerDataDTO fetchCompletePlayerData(Long id){
        
        CompletePlayerDataDTO completeDTO = new CompletePlayerDataDTO();
        Optional<Player> tempPlayer = playerrepo.findById(id);
        tempPlayer = this.privacyfilter.filterPlayerObject(tempPlayer);
        if(!tempPlayer.isEmpty()){
            Player usePlayer = tempPlayer.get();
            completeDTO.setPlayer(new PlayerDisplay(usePlayer.getEtternavn(), usePlayer.getFornavn(), id));
            completeDTO.setPlayerRankings(this.mappingService.findPlayerRankingsForPlayer(id));
        }
        
        return completeDTO;
    
    }
    
}

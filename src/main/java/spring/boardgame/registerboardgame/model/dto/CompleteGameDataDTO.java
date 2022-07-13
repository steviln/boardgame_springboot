package spring.boardgame.registerboardgame.model.dto;

import org.springframework.beans.factory.annotation.Autowired;
import spring.boardgame.registerboardgame.service.mapping.MappingGamesessionService;
import spring.boardgame.registerboardgame.model.Game;
import spring.boardgame.registerboardgame.repository.GameRepository;
import java.util.Optional;
import java.util.List;


public class CompleteGameDataDTO {

    private Game game = null;
    private List<PlayerRankingDTO> playerDTO = null;
    private List<FactionRankingDTO> factionDTO = null;
    private List<FactionPlayerRankingDTO> factionPlayerDTO = null;
    
    
    // This code should be moved somewhere else then the structure of the solution is more clear   
    
    public CompleteGameDataDTO(){
        

    
    }

    public void setFactionDTO(List<FactionRankingDTO> newValue){
        this.factionDTO = newValue;
    }
    
    public List<FactionRankingDTO> getFactionDTO(){
        return this.factionDTO;
    }
    
    public void setFactionPlayerDTO(List<FactionPlayerRankingDTO> newValue){
        this.factionPlayerDTO = newValue;
    }
    
    public List<FactionPlayerRankingDTO> getFactionPlayerDTO(){
        return this.factionPlayerDTO;
    }
    
    public void setGame(Game newValue){
        this.game = newValue;
    }
    
    public Game getGame(){
        return this.game;
    }
    
    public void setPlayerDTO(List<PlayerRankingDTO> newValue){
        this.playerDTO = newValue;
    }
    
    public List<PlayerRankingDTO> getPlayerDTO(){
        return this.playerDTO;
    }
    
    
    
}

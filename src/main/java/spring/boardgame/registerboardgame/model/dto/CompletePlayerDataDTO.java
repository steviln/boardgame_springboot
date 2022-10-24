package spring.boardgame.registerboardgame.model.dto;

import org.springframework.beans.factory.annotation.Autowired;
import spring.boardgame.registerboardgame.service.mapping.MappingGamesessionService;
import spring.boardgame.registerboardgame.model.Player;
import spring.boardgame.registerboardgame.repository.GameRepository;
import java.util.Optional;
import java.util.List;


public class CompletePlayerDataDTO {

    private Player player = null;
    private List<PlayerRankingsDTO> playerRankings = null;


    
    public CompletePlayerDataDTO(){        
    
    }

    
    public void setPlayer(Player newValue){
        this.player = newValue;
    }
    
    public Player getPlayer(){
        return this.player;
    }
    
    public void setPlayerRankings(List<PlayerRankingsDTO> newValue){
        this.playerRankings = newValue;
    }
    
    public List<PlayerRankingsDTO> getPlayerRankings(){
        return this.playerRankings;
    }
    
    
    
}
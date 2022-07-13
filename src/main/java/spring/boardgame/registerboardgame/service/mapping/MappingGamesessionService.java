package spring.boardgame.registerboardgame.service.mapping;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import spring.boardgame.registerboardgame.model.dto.FactionRankingDTO;
import spring.boardgame.registerboardgame.model.dto.PlayerRankingDTO;
import spring.boardgame.registerboardgame.model.dto.FactionPlayerRankingDTO;
import spring.boardgame.registerboardgame.repository.GameSessionRepository;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class MappingGamesessionService {
    
    @Autowired
    private GameSessionRepository sourcerepo;
       
    
    public List<FactionRankingDTO> findFactionRankingsForGame(Long id){    
        return ((List<FactionRankingDTO>) this.sourcerepo.findFactionRankings(id).stream().map(obj -> this.convertToFactionRankingDTO(obj)).collect(Collectors.toList()));                             
    }
    
    public List<PlayerRankingDTO> findPlayerRankingsForGame(Long id){    
        return ((List<PlayerRankingDTO>) this.sourcerepo.findPlayerRankings(id).stream().map(obj -> this.convertToPlayerRankingDTO(obj)).collect(Collectors.toList()));                             
    }
    
    public List<FactionPlayerRankingDTO> findFactionPlayerRankingsForGame(Long id){    
        return ((List<FactionPlayerRankingDTO>) this.sourcerepo.findPlayerByFactionrankings(id).stream().map(obj -> this.convertToFactionPlayerRankingDTO(obj)).collect(Collectors.toList()));                             
    }
    
    private PlayerRankingDTO convertToPlayerRankingDTO(Object[] source){    
        return new PlayerRankingDTO(source[1].toString(),source[2].toString(),source[3].toString(),this.convertStringToLong(source[0].toString()));    
    }

    private FactionPlayerRankingDTO convertToFactionPlayerRankingDTO(Object[] source){    
        return new FactionPlayerRankingDTO(source[1].toString(),source[2].toString(),source[3].toString(),source[4].toString(),this.convertStringToLong(source[0].toString()));    
    }
    
    private FactionRankingDTO convertToFactionRankingDTO(Object[] source){        
        return new FactionRankingDTO(source[0].toString(),source[1].toString(),source[2].toString());             
    }
    
    private Long convertStringToLong(String convert){
        Long spillerID = null;
        try{
            spillerID = Long.parseLong(convert);
        }catch(Exception e){
            System.out.println(e.toString());
        }
        
        return spillerID;
    }
    
    
    
}

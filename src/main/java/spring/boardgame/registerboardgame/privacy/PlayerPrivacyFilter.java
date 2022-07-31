package spring.boardgame.registerboardgame.privacy;


import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import spring.boardgame.registerboardgame.model.dto.PlayerRankingDTO;
import spring.boardgame.registerboardgame.session.Session;
import spring.boardgame.registerboardgame.model.dto.FactionPlayerRankingDTO;
import spring.boardgame.registerboardgame.model.Player;
import spring.boardgame.registerboardgame.model.PlayerList;
import spring.boardgame.registerboardgame.model.PlayerRanking;
import java.util.Optional;



@Component
public class PlayerPrivacyFilter {
    
    @Resource(name = "returnSession")
    Session mainsession;
    
    public PlayerPrivacyFilter(){}
    
    
    public List<PlayerRankingDTO> filterPlayerRanking(List<PlayerRankingDTO> listToFilter){
        if(this.mainsession.getUser() == null || this.mainsession.getUser().findMaxStatus() == 0){
            for(PlayerRankingDTO filterMe: listToFilter){
                filterMe.setNavn("Spiller" + filterMe.getSpillerID().toString());
            }
            return listToFilter;
        }else if(this.mainsession.getUser().findMaxStatus() >= 80){
            return listToFilter;
        }else{
            for(PlayerRankingDTO filterMe: listToFilter){
                if(filterMe.getSpillerID() != this.mainsession.getUser().getId()){
                    filterMe.setNavn("Spiller" + filterMe.getSpillerID().toString());
                }
            }
            return listToFilter;
        }
    }
    
    public List<FactionPlayerRankingDTO> filterFactionPlayerRanking(List<FactionPlayerRankingDTO> listToFilter){
        if(this.mainsession.getUser() == null || this.mainsession.getUser().findMaxStatus() == 0){
            for(FactionPlayerRankingDTO filterMe: listToFilter){
                filterMe.setNavn("Spiller" + filterMe.getSpillerID().toString());
            }
            return listToFilter;
        }else if(this.mainsession.getUser().findMaxStatus() >= 80){
            return listToFilter;
        }else{
            for(FactionPlayerRankingDTO filterMe: listToFilter){
                if(filterMe.getSpillerID() != this.mainsession.getUser().getId()){
                    filterMe.setNavn("Spiller" + filterMe.getSpillerID().toString());
                }
            }
            return listToFilter;
        }
    }
    
    public Iterable<Player> filterPlayerlist(Iterable<Player> players){
        if(this.mainsession.getUser() == null || this.mainsession.getUser().findMaxStatus() == 0){
            for(Player filterMe: players){
                filterMe.setFornavn("Spiller" + filterMe.getId().toString());
                filterMe.setEtternavn("");
            }
            return players;
        }else if(this.mainsession.getUser().findMaxStatus() >= 80){
            return players;
        }else{
            for(Player filterMe: players){
                if(filterMe.getId() != this.mainsession.getUser().getId()){
                    filterMe.setFornavn("Spiller" + filterMe.getId().toString());
                    filterMe.setEtternavn("");
                }
            }
            return players;
        }    
    }
    
    public Iterable<PlayerList> filterPlayerListList(Iterable<PlayerList> players){
        if(this.mainsession.getUser() == null || this.mainsession.getUser().findMaxStatus() == 0){
            for(PlayerList filterMe: players){
                filterMe.setFornavn("Spiller" + filterMe.getId());
                filterMe.setEtternavn("");
            }
            return players;
        }else if(this.mainsession.getUser().findMaxStatus() >= 80){
            return players;
        }else{
            for(PlayerList filterMe: players){
                if(filterMe.getId() != this.mainsession.getUser().getId()){
                    filterMe.setFornavn("Spiller" + filterMe.getId());
                    filterMe.setEtternavn("");
                }
            }
            return players;
        }     
    
    }
    
    public Optional<Player> filterPlayerObject(Optional<Player> player){
    
        if(!player.isEmpty()){
            Player filterMe = player.get();
            if(this.mainsession != null && this.mainsession.getUser() != null && this.mainsession.getUser().findMaxStatus() >= 80){

            }else{
                if(this.mainsession.getUser() == null || filterMe.getId() != this.mainsession.getUser().getId()){
                    filterMe.setFornavn("spiller"+ filterMe.getId());
                    filterMe.setEtternavn("");
                }
            }                   
        }        
    
        return player;
    
    }
    
    public Iterable<PlayerRanking> filterPlayerFrontpageList(Iterable<PlayerRanking> listToFilter){
        if(this.mainsession.getUser() == null || this.mainsession.getUser().findMaxStatus() == 0){
            for(PlayerRanking filterMe: listToFilter){
                filterMe.setNavn("Spiller" + filterMe.getId());
            }
            return listToFilter;
        }else if(this.mainsession.getUser().findMaxStatus() >= 80){
            return listToFilter;
        }else{
            for(PlayerRanking filterMe: listToFilter){
                if(filterMe.getId() != this.mainsession.getUser().getId()){
                    filterMe.setNavn("Spiller" + filterMe.getId());
                }
            }
            return listToFilter;
        }      
    }
    
    
}

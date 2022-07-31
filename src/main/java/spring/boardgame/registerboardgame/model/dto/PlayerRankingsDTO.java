
package spring.boardgame.registerboardgame.model.dto;

public class PlayerRankingsDTO {
    
    private String navn;
    private String spillinger;
    private String score;

    
    public PlayerRankingsDTO(String fnavn, String spp, String tscore){
        this.navn = fnavn;
        this.spillinger = spp;
        this.score = tscore;
    }
    
    public void setNavn(String tnavn){
        this.navn = tnavn;
    }
    public String getNavn(){
        return this.navn;
    }   
    public void setSpillinger(String newValue){
        this.spillinger = newValue;
    }
    public String getSpillinger(){
        return this.spillinger;
    }
    public void setScore(String newValue){
        this.score = newValue;
    }
    public String getScore(){
        return this.score;
    }
 
}

package spring.boardgame.registerboardgame.model.dto;


public class FactionRankingDTO {
    
    private String fraksjonsnavn;
    private String spillinger;
    private String score;
    
    public FactionRankingDTO(String fnavn, String spp, String tscore){
        this.fraksjonsnavn = fnavn;
        this.spillinger = spp;
        this.score = tscore;
    }
    
    public void setFraksjonsnavn(String tnavn){
        this.fraksjonsnavn = tnavn;
    }
    public String getFraksjonsnavn(){
        return this.fraksjonsnavn;
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

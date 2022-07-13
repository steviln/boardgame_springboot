
package spring.boardgame.registerboardgame.model.dto;

public class PlayerRankingDTO {
    
    private String navn;
    private String spillinger;
    private String score;
    private Long spillerID;
    
    public PlayerRankingDTO(String fnavn, String spp, String tscore, Long spilerid){
        this.navn = fnavn;
        this.spillinger = spp;
        this.score = tscore;
        this.spillerID = spilerid;
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
    public void setSpillerID(Long newValue){
        this.spillerID = newValue;
    }
    public Long getSpillerID(){
        return this.spillerID;
    }    
}

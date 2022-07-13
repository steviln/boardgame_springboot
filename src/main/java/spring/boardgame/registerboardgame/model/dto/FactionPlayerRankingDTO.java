package spring.boardgame.registerboardgame.model.dto;


public class FactionPlayerRankingDTO {
    
    private String navn;
    private String spillinger;
    private String score;
    private Long spillerID;
    private String fraksjonsnavn;
    
    public FactionPlayerRankingDTO(String fnavn, String snavn, String spp, String tscore, Long spilerid){
        this.fraksjonsnavn = fnavn;
        this.spillinger = spp;
        this.score = tscore;
        this.spillerID = spilerid;
        this.navn = snavn;
    }
    
    public void setFraksjonsnavn(String tnavn){
        this.fraksjonsnavn = tnavn;
    }
    public String getFraksjonsnavn(){
        return this.fraksjonsnavn;
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

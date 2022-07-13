package spring.boardgame.registerboardgame.model.json;


public class Login {
    
    private Integer userID;
    private String password;
    private String brukernavn;
    private String errormessage;
    private Integer status;
    
    public Login(){
    
    }
    
    public void setUserID(Integer newValue){
        this.userID = newValue;
    }
    
    public Integer getUserID(){
        return this.userID;
    }
    
    public void setStatus(Integer newValue){
        this.status = newValue;
    }
    
    public Integer getStatus(){
        return this.status;
    }
    
    public void setBrukernavn(String newValue){
        this.brukernavn = newValue;
    }
    
    public String getBrukernavn(){
        return this.brukernavn;
    }    
    public void setPassword(String newValue){
        this.password = newValue;
    }
    
    public String getPassword(){
        return this.password;
    }  
    
    public void setErrormessage(String newValue){
        this.errormessage = newValue;
    }
    
    public String getErrormessage(){
        return this.errormessage;
    }  

    

    
}

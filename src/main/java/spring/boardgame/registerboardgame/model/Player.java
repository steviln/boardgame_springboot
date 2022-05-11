package spring.boardgame.registerboardgame.model;

import javax.persistence.*;


@Entity
@Table(name = "player")
public class Player {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    
    @Column
    private String fornavn;

    @Column
    private String etternavn;
    
    @Column
    private String facebookID;
    
    @Column
    private String epost;
    
    @Column   
    private String brukernavn;
    
    @Column
    private String passord;
    
    @Column
    private Integer rettighet;
    
    @Column
    private Integer overlook;
	
    public  Player() {
    }

    public Player(String tenavn, String tfnavn, int orgId, Integer trett, Integer overl, String faceb, String tepost, String tbruk, String tpass) {
       this.fornavn = tfnavn;
       this.etternavn = tenavn;
       this.id = orgId;
       this.rettighet = trett;
       this.overlook = overl;
       this.facebookID = faceb;
       this.epost = tepost;
       this.brukernavn = tbruk;
       this.passord = tpass;
    }
    
    public int getId() {
        return this.id;
    }   
    public void setId(int id) {
        this.id = id;
    }
    public String getFornavn(){
        return this.fornavn;
    }
    public void setFornavn(String nyVerdi){
        this.fornavn = nyVerdi;
    }
    public String getEtternavn(){
        return this.etternavn;
    }
    public void setEtternavn(String nyVerdi){
        this.etternavn = nyVerdi;
    } 
    public String getBrukernavn(){
        return this.brukernavn;
    }
    public void setBrukernavn(String nyVerdi){
        this.brukernavn = nyVerdi;
    }
    public String getFacebookID(){
        return this.facebookID;
    }
    public void setFacebookID(String nyVerdi){
        this.facebookID = nyVerdi;
    }
    public String getPassord(){
        return this.passord;
    }
    public void setPassord(String nyVerdi){
        this.passord = nyVerdi;
    }
    public String getEpost(){
        return this.epost;
    }
    public void setEpost(String nyVerdi){
        this.epost = nyVerdi;
    }
    public void setRettighet(Integer nyVerdi){
        this.rettighet = nyVerdi;
    }
    public Integer getRettighet(){
        return this.rettighet; 
    }
    public void setOverlook(Integer nyVerdi){
        this.overlook = nyVerdi;
    }
    public Integer getOverlook(){
        return this.overlook; 
    }
}

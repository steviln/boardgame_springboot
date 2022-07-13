package spring.boardgame.registerboardgame.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import spring.boardgame.registerboardgame.model.json.Login;


@Entity
@Table(name = "player")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    
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
    
    @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private Set<UserRole> roller = new HashSet<UserRole>(0);
	
    public  User() {
    }

    public User(String tenavn, String tfnavn, Long orgId, Integer trett, Integer overl, String faceb, String tepost, String tbruk, String tpass) {
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
    
    public Long getId() {
        return this.id;
    }   
    public void setId(Long id) {
        this.id = id;
    }
    public void setRoller(Set<UserRole> rollene){
        this.roller = rollene;
    }
    public Set<UserRole> getRoller(){
        return this.roller;
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
    public void findMaxStatus(Login login){
    
        login.setUserID(this.getId().intValue());
        login.setStatus(0);
        for(UserRole rolle: this.getRoller()){
            if(rolle.getRole().getId() > login.getStatus()){
                login.setStatus(rolle.getRole().getId());
            }
        }    
    }
    
    public Integer findMaxStatus(){
        Integer returnStatus = 0;
        for(UserRole rolle: this.getRoller()){
            if(rolle.getRole().getId() > returnStatus){
                returnStatus = rolle.getRole().getId();
            }
        } 
        return returnStatus;
    }
    
    public boolean haveAllPermission(){
        for (UserRole rolle : this.roller) {
            if(rolle.getRole() != null && rolle.getRole().getAlle() == 1){
                return true;
            }
        }    
        return true;
    }
}
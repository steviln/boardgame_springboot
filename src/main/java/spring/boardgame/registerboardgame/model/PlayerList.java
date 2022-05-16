package spring.boardgame.registerboardgame.model;

import javax.persistence.*;


@Entity
@Table(name = "player")
public class PlayerList {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;
    
    @Column
    private String fornavn;

    @Column
    private String etternavn;
    
    @Column
    private Integer overlook;
	
    public  PlayerList() {
    }

    public PlayerList(Integer orgId, String tenavn, String tfnavn, Integer overl) {
       this.fornavn = tfnavn;
       this.etternavn = tenavn;
       this.id = orgId;
       this.overlook = overl;
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

    public void setOverlook(Integer nyVerdi){
        this.overlook = nyVerdi;
    }
    public Integer getOverlook(){
        return this.overlook; 
    }
}

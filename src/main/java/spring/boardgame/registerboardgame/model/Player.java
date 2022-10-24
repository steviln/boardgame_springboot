package spring.boardgame.registerboardgame.model;

import javax.persistence.*;


@Entity
@Table(name = "player")
public class Player {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    
    @Column
    private String fornavn;

    @Column
    private String etternavn;    

	
    public  Player() {
    }

    public Player(String tenavn, String tfnavn, Long orgId) {
       this.fornavn = tfnavn;
       this.etternavn = tenavn;
       this.id = orgId;

    }

    
    public Long getId() {
        return this.id;
    }   
    public void setId(Long id) {
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

}

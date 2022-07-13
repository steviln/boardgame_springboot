package spring.boardgame.registerboardgame.model;

import javax.persistence.*;
// Generated 19-May-2016 11:52:48 by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "game")
public class Game implements java.io.Serializable {


     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "id", updatable = false, nullable = false)
     private Long id;
     
     @Column
     private String navn;
     
     @Column
     private String boardgamegeekId;
     
     @Column
     private Integer antall;
     
     @Column
     private Long selskap;

     
     @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
     @JoinColumn(name="spillID")
     private Set<Faction> fraksjoner;

     @OneToMany(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
     @JoinColumn(name="spillID")
     private Set<Scenario> scenarios;

    public Game() {
    }

    public Game(String navn, String boardgamegeekId, Integer antall, Long tse) {
       this.navn = navn;
       this.boardgamegeekId = boardgamegeekId;
       this.antall = antall;
       this.selskap = tse;
    }
    
    public Set<Faction> getFraksjoner(){
        return this.fraksjoner;
    }
    
    public void setFraksjoner(Set<Faction> frak){
        this.fraksjoner = frak;
    }
    
        public Set<Scenario> getScenarios(){
        return this.scenarios;
    }
    
    public void setScenarios(Set<Scenario> frak){
        this.scenarios = frak;
    }
    
    public void setSelskap(Long newValue){
        this.selskap = newValue;
    }
    
    public Long getSelskap(){
        return this.selskap;
    }
   
    public Long getId() {
        return this.id;
    }   
    public void setId(Long id) {
        this.id = id;
    }  

    
    public String getNavn() {
        return this.navn;
    }
    
    public void setNavn(String navn) {
        this.navn = navn;
    }
    public String getBoardgamegeekId() {
        return this.boardgamegeekId;
    }
    
    public void setBoardgamegeekId(String boardgamegeekId) {
        this.boardgamegeekId = boardgamegeekId;
    }
    public Integer getAntall() {
        return this.antall;
    }
    
    public void setAntall(Integer antall) {
        this.antall = antall;
    }





}



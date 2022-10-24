package spring.boardgame.registerboardgame.model.display;
// Generated 19-May-2016 11:52:48 by Hibernate Tools 4.3.1

import java.util.HashSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import spring.boardgame.registerboardgame.model.Faction;
import spring.boardgame.registerboardgame.model.Player;
import java.util.Set;
import javax.persistence.FetchType;


@Entity
@Table(name = "participation")
public class DisplayParticipation  implements java.io.Serializable {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "id", updatable = false, nullable = false)
     private Long id;

     
     @Column(name = "poeng")
     private Float poeng;
     
     @Column(name = "posisjon")
     private Integer posisjon;
     
     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "spillerID")
     private Player spiller;
     
     @Column(name = "fraksjonID")
     private Integer fraksjonID;
     

     private Faction fraksjon = null;

    public DisplayParticipation() {
    }

    public DisplayParticipation(Player spillerId, Float poeng, Integer posisjon, Long pod, Faction tfac) {
       this.spiller = spillerId;

       //this.spillsesjon = sesjonId;
       this.poeng = poeng;
       this.posisjon = posisjon;
       this.id = pod;
       //this.spillsesjon = sesjonId;
      this.fraksjon = tfac;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public Player getSpiller() {
        return this.spiller;
    }
    
    public void setSpiller(Player spillerId) {
        this.spiller = spillerId;
    }
    public Faction getFraksjon() {
        return this.fraksjon;
    }
    
    public void setFraksjon(Faction fraksjonId) {
        this.fraksjon = fraksjonId;
    }

    public Float getPoeng() {
        return this.poeng;
    }
    
    public void setPoeng(Float poeng) {
        this.poeng = poeng;
    }
    public Integer getPosisjon() {
        return this.posisjon;
    }
    
    public void setPosisjon(Integer posisjon) {
        this.posisjon = posisjon;
    }
    
    public Integer getFraksjonID() {
        return this.fraksjonID;
    }
    
    public void setFraksjonID(Integer fraksjonId) {
        this.fraksjonID = fraksjonId;
    }




}



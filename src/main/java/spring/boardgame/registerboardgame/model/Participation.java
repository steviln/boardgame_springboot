package spring.boardgame.registerboardgame.model;
// Generated 19-May-2016 11:52:48 by Hibernate Tools 4.3.1

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;




@Entity
@Table(name = "participation")
public class Participation  implements java.io.Serializable {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "id", updatable = false, nullable = false)
     private Long id;
     

     @Column(name = "spillerID")
     private Integer spiller;
     
     @Column(name = "poeng")
     private Float poeng;
     
     @Column(name = "posisjon")
     private Integer posisjon;
     
     //@Column(name = "sesjonID")
     //private Gamesession spillsesjon;
     
     @Column(name = "fraksjonID")
     private Integer fraksjonId;

    public Participation() {
    }

    public Participation(Integer spillerId, Float poeng, Integer posisjon, Long pod, Faction tfac) {
       this.spiller = spillerId;

       //this.spillsesjon = sesjonId;
       this.poeng = poeng;
       this.posisjon = posisjon;
       this.id = pod;
       //this.spillsesjon = sesjonId;
       //this.fraksjonId = tfac;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public Integer getSpiller() {
        return this.spiller;
    }
    
    public void setSpiller(Integer spillerId) {
        this.spiller = spillerId;
    }
    public Integer getFraksjonId() {
        return this.fraksjonId;
    }
    
    public void setFraksjonId(Integer fraksjonId) {
        this.fraksjonId = fraksjonId;
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




}



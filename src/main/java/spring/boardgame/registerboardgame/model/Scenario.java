package spring.boardgame.registerboardgame.model;
// Generated 19-May-2016 11:52:48 by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "scenario")
public class Scenario  implements java.io.Serializable {


     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "id", updatable = false, nullable = false)
     private Long id;
     
     @Column
     private String navn;  
     
     @Column
     private Long spillid;

     
    public Scenario() {
    }

    public Scenario(String navn, Long spillId) {
       this.navn = navn;
       this.spillid = spillId;
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
    public Long getSpillid() {
        return this.spillid;
    }
    
    public void setSpillid(Long spillId) {
        this.spillid = spillId;
    }


}



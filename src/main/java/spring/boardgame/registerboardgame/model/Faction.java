package spring.boardgame.registerboardgame.model;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;




@Entity
@Table(name = "faction")
public class Faction  implements java.io.Serializable {


     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "id", updatable = false, nullable = false)
     private Long id;
     
     @Column
     private String navn;     
     
     @Column
     private Integer spillID;


    public Faction() {
    }

    public Faction(String navn, Integer spillIDe) {
       this.navn = navn;
       this.spillID = spillIDe;
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
        
    public Integer getSpillID() {
        return this.spillID;
    }   
    public void setSpillID(Integer id) {
        this.spillID = id;
    } 



}



package spring.boardgame.registerboardgame.model;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
@Table(name = "selskap")
public class Selskap  implements java.io.Serializable {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "id", updatable = false, nullable = false)
     private Integer id;
     
     @Column
     private String navn;

    public Selskap() {
    }

    public Selskap(String navn) {
       this.navn = navn;
    }
    

   
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNavn() {
        return this.navn;
    }
    
    public void setNavn(String navn) {
        this.navn = navn;
    }


}



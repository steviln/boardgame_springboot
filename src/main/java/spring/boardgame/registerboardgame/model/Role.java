package spring.boardgame.registerboardgame.model;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
@Table(name = "roles")
public class Role implements java.io.Serializable {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "id", updatable = false, nullable = false)
     private Integer id;
     
     @Column
     private String navn;
     
     @Column
     private Integer register; 
     
     @Column
     private Integer lese; 
     
     @Column
     private Integer opprette; 
     
     @Column
     private Integer alle; 

    public Role() {
    }

    public Role(String navn) {
       this.navn = navn;
    }
    
    public Integer getAlle() {
        return this.alle;
    }
    
    public void setAlle(Integer id) {
        this.alle = id;
    }
    
    public Integer getOpprette() {
        return this.opprette;
    }
    
    public void setLese(Integer id) {
        this.lese = id;
    }
    
    public Integer getRegister() {
        return this.register;
    }
    
    public void setRegister(Integer id) {
        this.register = id;
    }

    
    public void setOpprette(Integer id) {
        this.opprette = id;
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


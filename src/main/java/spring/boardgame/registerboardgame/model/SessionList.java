package spring.boardgame.registerboardgame.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;


@Entity
@Immutable
@Table(name = "sessionlist")
public class SessionList {    
    
    @Column(name = "dato")
    private String dato;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    
    @Column(name = "navn")
    private String navn;
    
    public SessionList(){}
    
    public Long getId(){
        return this.id;
    }
    
    public void setId(Long newValue){
        this.id = newValue;
    }
    
    public String getNavn(){
        return this.navn;
    }
    
    public void setNavn(String newValue){
        this.navn = newValue;
    }
    
    public String getDato(){
        return this.dato;
    }
    
    public void setDato(String newValue){
        this.dato = newValue;
    }
    
    
}

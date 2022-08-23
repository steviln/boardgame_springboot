package spring.boardgame.registerboardgame.model;

import java.util.Date;
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
@Table(name = "logins")
public class Logins {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;
    
    @Column(name = "dato")
    private Date dato;
    
    @Column(name = "ip")
    private String ip;
    
    @Column(name = "username")
    private String username;
    
    public Logins(){}
    
    public Logins(Date dato, String ip, String username){
        this.dato = dato;
        this.ip = ip;
        this.username = username;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
    public void setDato(Date dato){
        this.dato = dato;
    }
    
    public void setIp(String ip){
        this.ip = ip;
    }
    
    public void setUnsername(String username){
        this.username = username;
    }
    
    public Long getId(){
        return this.id;
    }
    
    public Date getDato(){
        return this.dato;
    }
    
    public String getIp(){
        return this.ip;
    }
    
    public String getUsername(){
        return this.ip;
    }
    
}

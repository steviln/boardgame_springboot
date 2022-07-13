package spring.boardgame.registerboardgame.model;

import java.util.Optional;
import javax.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity
@Immutable
@Table(name = "gamelist")
public class GameList implements Comparable<GameList>{
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    private Integer id;
	
	@Column
	private String navn;
	
	@Column
	private int spillinger;
	
	public GameList() {
		
	}
	
	public GameList(int nyid, String navne, int spillings) {
		this.navn = navne;
		this.id = nyid;
		this.spillinger = spillings;
	}
	
    public Integer getId() {
        return this.id;
    }   
    public void setId(Integer id) {
        this.id = id;
    }
    
    public float getSpillinger() {
    	return this.spillinger;
    }    
    public void setSpillinger(int nyf) {
    	this.spillinger = nyf;
    }
    
    public void setNavn(String nynavn) {
    	this.navn = nynavn;
    }
    
    public String getNavn() {
    	return this.navn;
    }
    
  
    
    @Override
    public int compareTo(GameList compto){
        return this.navn.compareTo(compto.getNavn());
    }
	

}

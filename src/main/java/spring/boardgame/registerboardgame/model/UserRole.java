package spring.boardgame.registerboardgame.model;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
@Table(name = "user_role")
public class UserRole  implements java.io.Serializable {

     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "id", updatable = false, nullable = false)
     private Integer id;
     
     @Column(name = "user_id")
     private Integer userID;
     
     @OneToOne(cascade = CascadeType.ALL)
     @JoinColumn(name = "role_id")
     private Role rolle;

    public UserRole() {
    }   
   
    public Integer getId() {
        return this.id;
    }    
    public void setId(Integer id) {
        this.id = id;
    }
    public Role getRole() {
        return this.rolle;
    }    
    public void setRole(Role rollen) {
        this.rolle = rollen;
    }
    public Integer getUserID() {
        return this.userID;
    }    
    public void setUserID(Integer tid) {
        this.userID = tid;
    }


}


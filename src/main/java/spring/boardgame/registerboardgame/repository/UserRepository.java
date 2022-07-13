package spring.boardgame.registerboardgame.repository;


import spring.boardgame.registerboardgame.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
    List<User> findByBrukernavnAndPassord(String brukernavn, String password);
     
}
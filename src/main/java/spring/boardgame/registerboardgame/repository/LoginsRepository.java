package spring.boardgame.registerboardgame.repository;


import spring.boardgame.registerboardgame.model.Logins;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;



@Repository
public interface LoginsRepository extends CrudRepository<Logins, Long> {
    
    Long countByUsernameOrIp(String username, String ip);
    
    @Transactional
    @Modifying
    @Query(value = "DELETE FROM logins WHERE dato > (NOW() - INTERVAL 5 HOUR);", nativeQuery = true)
    void deleteOldLogins();
     
}

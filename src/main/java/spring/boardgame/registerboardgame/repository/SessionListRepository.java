package spring.boardgame.registerboardgame.repository;

import org.springframework.data.repository.CrudRepository;
import spring.boardgame.registerboardgame.model.SessionList;



public interface SessionListRepository extends CrudRepository<SessionList, Long>{
    
}

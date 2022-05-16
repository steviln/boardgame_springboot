package spring.boardgame.registerboardgame.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.boardgame.registerboardgame.model.PlayerList;

public interface PlayerListRepository extends CrudRepository<PlayerList, Long>{
    
}


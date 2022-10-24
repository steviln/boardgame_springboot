package spring.boardgame.registerboardgame.repository;


import spring.boardgame.registerboardgame.model.display.SingleGamesession;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SingleGamesessionRepository extends CrudRepository<SingleGamesession, Long> {
     
}


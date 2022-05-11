package spring.boardgame.registerboardgame.repository;


import spring.boardgame.registerboardgame.model.GameList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameListRepository extends CrudRepository<GameList, Long> {
     
}
    
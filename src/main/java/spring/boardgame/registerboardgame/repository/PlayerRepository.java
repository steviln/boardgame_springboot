package spring.boardgame.registerboardgame.repository;


import spring.boardgame.registerboardgame.model.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
     
}
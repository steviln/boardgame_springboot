package spring.boardgame.registerboardgame.repository;

import spring.boardgame.registerboardgame.model.PlayerRanking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRankingRepository extends CrudRepository<PlayerRanking, Long>{
    
}

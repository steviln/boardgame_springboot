package spring.boardgame.registerboardgame.repository;


import spring.boardgame.registerboardgame.model.Faction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactionRepository extends CrudRepository<Faction, Long> {
     
}
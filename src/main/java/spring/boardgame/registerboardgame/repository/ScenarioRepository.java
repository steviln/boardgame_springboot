package spring.boardgame.registerboardgame.repository;


import spring.boardgame.registerboardgame.model.Scenario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScenarioRepository extends CrudRepository<Scenario, Long> {
     
}
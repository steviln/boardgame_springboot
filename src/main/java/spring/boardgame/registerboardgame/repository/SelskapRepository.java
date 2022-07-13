package spring.boardgame.registerboardgame.repository;


import spring.boardgame.registerboardgame.model.Selskap;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SelskapRepository extends CrudRepository<Selskap, Long> {
     
}
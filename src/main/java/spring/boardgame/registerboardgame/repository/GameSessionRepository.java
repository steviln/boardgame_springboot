package spring.boardgame.registerboardgame.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import spring.boardgame.registerboardgame.model.Gamesession;
import spring.boardgame.registerboardgame.model.SessionList;
import org.springframework.data.jpa.repository.Query;
import spring.boardgame.registerboardgame.model.dto.FactionRankingDTO;
import java.util.List;

/**
 *
 * @author stevi
 */
@Repository
public interface GameSessionRepository extends CrudRepository<Gamesession, Long>  {
    
    @Query(value = "SELECT * FROM sessionlist", nativeQuery = true)
    List<SessionList> findSessionList();
    
    @Query(value = "SELECT fac.navn AS fraksjonsnavn, COUNT(ses.id) AS spillinger, ROUND(AVG((1 - ((posisjon - 1) / (ses.competitors - 1))) * 100)) AS score FROM (gamesession AS ses, faction AS fac, participation AS par) WHERE fac.spillID = ses.spillID AND ses.spillID = :id AND par.sesjonID = ses.id AND par.fraksjonID = fac.id GROUP BY fac.id;",nativeQuery = true)
    List<Object[]> findFactionRankings(Long id);
    
    @Query(value = "SELECT pla.id AS spillerid,fac.navn AS fraksjonsnavn, CONCAT(pla.fornavn,' ',pla.etternavn) AS navn, COUNT(ses.id) AS spillinger, ROUND(AVG((1 - ((posisjon - 1) / (ses.competitors - 1))) * 100)) AS score FROM (player AS pla,gamesession AS ses, faction AS fac, participation AS par) WHERE fac.spillID = ses.spillID AND ses.spillID = :id AND par.sesjonID = ses.id AND par.fraksjonID = fac.id AND pla.id = par.spillerID GROUP BY pla.id, fac.id ORDER BY pla.id;", nativeQuery = true)
    List<Object[]> findPlayerByFactionrankings(Long id);
    
    @Query(value = "SELECT pla.id AS spillerid,CONCAT(pla.fornavn,' ',pla.etternavn) AS navn, COUNT(ses.id) AS spillinger, ROUND(AVG((1 - ((posisjon - 1) / (ses.competitors - 1))) * 100)) AS score FROM (player AS pla,gamesession AS ses, participation AS par) WHERE ses.spillID = :id AND par.sesjonID = ses.id AND pla.id = par.spillerID GROUP BY pla.id ORDER BY pla.id;",nativeQuery = true)
    List<Object[]> findPlayerRankings(Long id);
    
    @Query(value = "SELECT gm.navn, COUNT(ses.id) AS spillinger, ROUND(AVG((1 - ((par.posisjon - 1) / (ses.competitors - 1))) * 100)) AS score FROM gamesession AS ses, player AS pl, participation AS par, game AS gm WHERE par.spillerID = pl.id AND gm.id = ses.spillID AND par.sesjonID = ses.id AND pl.id = :id GROUP BY gm.id;",nativeQuery = true)
    List<Object[]> findPlayerRankOverview(Long id);
    
    List<Gamesession> findBySpillet(Long gameID);
    
}



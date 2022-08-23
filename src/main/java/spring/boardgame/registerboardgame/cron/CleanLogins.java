package spring.boardgame.registerboardgame.cron;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import spring.boardgame.registerboardgame.repository.LoginsRepository;

@Component
public class CleanLogins {
    
        @Autowired
        private LoginsRepository loginrep;
    
    	@Scheduled(fixedRate = 5000)
	public void routineClean() {
            this.loginrep.deleteOldLogins();
	}
    
}

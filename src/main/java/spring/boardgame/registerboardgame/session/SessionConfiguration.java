package spring.boardgame.registerboardgame.session;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
public class SessionConfiguration {
    @Bean
    public Session returnSession() {
        return new Session();
    }
}

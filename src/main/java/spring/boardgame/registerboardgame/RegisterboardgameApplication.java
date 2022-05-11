package spring.boardgame.registerboardgame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.Banner.*;

@SpringBootApplication
public class RegisterboardgameApplication {

	public static void main(String[] args) {
            SpringApplication application = new SpringApplication(RegisterboardgameApplication.class);
            //application.setBannerMode(Banner.Mode.OFF);
            application.run(args);
	}

}

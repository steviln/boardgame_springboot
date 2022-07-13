package spring.boardgame.registerboardgame.session;

import javax.annotation.Resource;
import org.springframework.context.annotation.Configuration;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.JoinPoint;
import org.springframework.http.HttpStatus;
import spring.boardgame.registerboardgame.session.Session;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;


@Aspect
@Configuration
public class SessionAspects {
    @Resource(name = "returnSession")
    Session mainsession;
    //http://localhost:4200/editspiller/1
    
    
    //@Before("execution(* spring.boardgame.registerboardgame.controllers.*.*Authorize(..))")
    public void before(JoinPoint joinPoint) {
        if(this.mainsession.getUser() == null){
            System.out.println("You are not logged in");
            this.whenAccessDenied();
        }else{
            System.out.println("You are logged in");
        }
        
    }
    
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public void whenAccessDenied() {
        System.out.println("an access error occured");
    }
    
}

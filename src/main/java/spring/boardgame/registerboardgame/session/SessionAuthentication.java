package spring.boardgame.registerboardgame.session;

import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.access.expression.DenyAllPermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import java.io.Serializable;
import java.util.Map;
import javax.annotation.Resource;


public class SessionAuthentication implements PermissionEvaluator{
    
    private Session session;
    
    public SessionAuthentication(Session session){
        this.session = session;
    }
    
    @Override
    public boolean hasPermission(Authentication authentication, Object targetDomainObject, Object permission) {
        if(this.session == null || this.session.getUser() == null){
            return false;
        }else{
            return this.hasPermission(authentication,null,null,permission);
        }
    }
    
    @Override
    public boolean hasPermission(Authentication authentication, Serializable targetId, String targetType, Object permission) {
       // System.out.println("evaluating even lower " + targetType + " " + targetId.toString());
        if(this.session == null || this.session.getUser() == null){
            return false;
        }else{
            if(targetType != null && targetType.equals("Player") && !this.session.getUser().haveAllPermission() && targetId != null && Long.valueOf(targetId.toString()) != this.session.getUser().getId()){
                return false;
            }else if(targetType != null && targetType.equals("Game") && this.session.getUser().findMaxStatus() < 80){
                return false;
            }else{
                return true;
            }
        }
    }
    
}

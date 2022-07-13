package spring.boardgame.registerboardgame.session;


import spring.boardgame.registerboardgame.model.User;



public class Session {
    
    private User user;
    
    public Session(){
        //this.user = null;
    }
    
    public void setUser(User newUser){
        this.user = newUser;
    }
    
    public User getUser(){
        return this.user;
    }
}

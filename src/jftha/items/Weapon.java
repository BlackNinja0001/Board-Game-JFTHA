package jftha.items;

import jftha.main.Player;

public abstract class Weapon extends Equippable{
    private String message;
    
    public Weapon(){
        
    }
        
    //Getter Methods
    public String getMessage() {
        return message;
    }

    //Setter Methods
    public void setMessage(String message) {
        this.message = message;
    }
    
    public abstract void equipWeap(Player player);
    public abstract void dropWeap(Player player);
    public abstract void weapEffect(Player player);
    public abstract void weapEffect(Player attacker, Player attacked);
}

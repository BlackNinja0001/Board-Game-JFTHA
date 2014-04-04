package jftha.cards;

import jftha.effects.*;
import jftha.heroes.*;
import jftha.main.Player;

public abstract class Card {
    
    private String message;

    //Setter oethods
    public void setMessage(String message) {
        this.message = message;
    }

    //Getter methods
    public String getMessage() {
        return message;
    }
    
    /**
     * Triggers the effect of this card. 
     * Unless there are no parameters, the number of parameters determine the number of players affected. 
     * No parameters affects all or no players. 
     */
    public abstract void triggerEffect();
    
    public abstract void triggerEffect(Player affected);
    
    public abstract void triggerEffect(Player affected1, Player affected2);
    
    public abstract void triggerEffect(Player affected1, Player affected2, Player affected3);
}

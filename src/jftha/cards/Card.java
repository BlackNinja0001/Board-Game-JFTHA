package jftha.cards;

import jftha.heroes.*;
import jftha.spaces.Space;
import jftha.main.Player;

public abstract class Card extends Space {
    
    private String message;
    private RarityEnum rarity;

    //Setter oethods
    public void setMessage(String message) {
        this.message = message;
    }

    public void setRarity(RarityEnum rarity){
        this.rarity = rarity;
    }
            
    //Getter methods
    public String getMessage() {
        return message;
    }
    
    public RarityEnum getRarity(){
        return rarity;
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

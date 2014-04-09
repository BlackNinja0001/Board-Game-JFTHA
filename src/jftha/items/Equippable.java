package jftha.items;

import jftha.heroes.*;

public class Equippable extends Item{
    //a Hero can equip only one weapon and one armor <-- should this be in the Hero class?
    //An equippable item affects only the stats of the Hero who has the items equipped
    private Hero equippedOn;
    private String message;

    //Getter Methods
    public String getMessage() {
        return message;
    }

    //Setter Methods
    public void setMessage(String message) {
        this.message = message;
    }
    
    public boolean isEquippedOn(Hero potentialOwner){
        return (equippedOn == potentialOwner);
    }
}

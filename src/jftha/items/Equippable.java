package jftha.items;

import jftha.heroes.*;

public class Equippable extends Item{
    //a Hero can equip only one weapon and one armor <-- should this be in the Hero class?
    //An equippable item affects only the stats of the Hero who has the items equipped
    private Hero equippedOn;
    
    public boolean isEquippedOn(Hero potentialOwner){
        return (equippedOn == potentialOwner);
    }
}

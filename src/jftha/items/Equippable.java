package jftha.items;

import jftha.heroes.*;
import jftha.main.Player;

public class Equippable extends Item{
    //a Hero can equip only one weapon and one armor <-- should this be in the Hero class?
    //An equippable item affects only the stats of the Hero who has the items equipped
    private Hero equippedOn;
    
    public boolean isEquippedOn(Hero potentialOwner){
        return (equippedOn == potentialOwner);
    }

    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void triggerEffect(Player affected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void triggerEffect(Player affected1, Player affected2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void triggerEffect(Player affected1, Player affected2, Player affected3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

package jftha.cards;

import java.util.*;
import jftha.heroes.*;
import jftha.main.Player;

public class StealGold extends Card{
    
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
        Hero thief = affected1.getCharacter();
        Hero victim = affected2.getCharacter();
        
        Random rand = new Random(System.currentTimeMillis());
        //Will change when we balance out gameplay
        int stolengold = rand.nextInt(50);
        
        victim.setGold(victim.getGold() - stolengold);
        
        //This condition statement will ensure victim's gold is not negative
                //Victim gold will be zero if it is negative
        //It will only let the thief steal what the victim have left and not more than what victim has
        if(victim.getGold() < 0){
            //goldDifference should be negative
            int goldDifference = victim.getGold();
            stolengold = stolengold + goldDifference;
            victim.setGold(0);
            thief.setGold(thief.getGold() + stolengold);
        }else{
            thief.setGold(thief.getGold() + stolengold);
        }
    }

    @Override
    public void triggerEffect(Player affected1, Player affected2, Player affected3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

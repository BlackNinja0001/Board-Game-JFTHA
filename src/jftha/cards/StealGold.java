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
    public void triggerEffect(Player thief, Player victim) {
        Hero thiefHero = thief.getCharacter();
        Hero victimHero = victim.getCharacter();
        
        Random rand = new Random(System.currentTimeMillis());
        //Will change when we balance out gameplay
        int stolengold = rand.nextInt(50);
        this.setMessage(victim.getCustomName() + " has just invested in " + thief.getCustomName() + "'s ponzi scheme. "
                + "As a result, " + thief.getCustomName() + " steals " + stolengold + " from " + victim.getCustomName());
        victimHero.setGold(victimHero.getGold() - stolengold);
        
        //This condition statement will ensure victim's gold is not negative
                //Victim gold will be zero if it is negative
        //It will only let the thief steal what the victim have left and not more than what victim has
        if(victimHero.getGold() < 0){
            //goldDifference should be negative
            int goldDifference = victimHero.getGold();
            stolengold = stolengold + goldDifference;
            victimHero.setGold(0);
            thiefHero.setGold(thiefHero.getGold() + stolengold);
        }else{
            thiefHero.setGold(thiefHero.getGold() + stolengold);
        }
    }

    @Override
    public void triggerEffect(Player affected1, Player affected2, Player affected3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

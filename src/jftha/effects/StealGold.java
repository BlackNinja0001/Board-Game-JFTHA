package jftha.effects;

import java.util.*;
import jftha.heroes.*;

public class StealGold extends Effect{
    
    StealGold(Hero thief, Hero victim){
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
}

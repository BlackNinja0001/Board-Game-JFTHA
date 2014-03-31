package jftha.effects;

import java.util.*;
import jftha.heroes.*;

public class MPDrain extends Effect{
    //This effect can have multiple Constructors
    //MPDrain can have one player steal MP from another player
    //MPDrain can drain the current player's MP
    
    //This Effect Drains the current player's MP
    public MPDrain(Hero hero){
        Random rand = new Random(System.currentTimeMillis());
        //Needs to adjust for gameplay balancing
        int mpdrain = rand.nextInt(50);
        hero.setCurrentMP(hero.getCurrentMP() - mpdrain);
        if((hero.isGhost() == true) && (hero.getCurrentMP() <= 0)){
            hero.setEliminated(true);
        }
    }
    
    //This effect lets current player drain another player's MP
    public MPDrain(Hero drainer, Hero victim){
        Random rand = new Random(System.currentTimeMillis());
        //Needs to adjust for gameplay balancing
        int mpdrain = rand.nextInt(50);
        
        victim.setCurrentMP(victim.getCurrentMP() - mpdrain);
        if((victim.isGhost() == true) && (victim.getCurrentMP() <= 0)){
            victim.setEliminated(true);
        }
        
        drainer.setCurrentMP(drainer.getCurrentMP() + mpdrain);
        if(drainer.getCurrentMP() > drainer.getMaxMP()){
            drainer.setCurrentMP(drainer.getMaxMP());
        }
    }
}

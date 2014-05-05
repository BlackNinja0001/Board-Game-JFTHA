package jftha.cards;

import java.util.*;
import jftha.heroes.*;
import jftha.items.Item;
import jftha.main.Player;

public class MPDrain extends Card{
    
    /** This Effect Drains the current player's MP.
     * 
     * @param affected The character that is getting MP drained.
     */
    @Override
    public void triggerEffect(Player affected){
        Hero hero = affected.getCharacter();
        Random rand = new Random(System.currentTimeMillis());
        //Needs to adjust for gameplay balancing
        int mpdrain = rand.nextInt(10) + 1;
        this.setMessage("You were ambushed by an angry mob who thought you were a witch. They have sapped " + mpdrain + " MP from you.");
        hero.setCurrentMP(hero.getCurrentMP() - mpdrain);
        if((hero.isGhost() == true) && (hero.getCurrentMP() <= 0)){
            hero.setEliminated(true);
        }
    }

    /**This effect lets current player drain another player's MP
     * 
     * @param affected1 This character that taking the MP
     * @param affected2 The character being drained
     */
    @Override
    public void triggerEffect(Player affected1, Player affected2) {
        Hero drainer = affected1.getCharacter();
        Hero victim = affected2.getCharacter();
        Random rand = new Random(System.currentTimeMillis());
        //Needs to adjust for gameplay balancing
        int mpdrain = rand.nextInt(10) + 1; // max for most is 30
        this.setMessage(affected1.getCustomName() + " became a magic vampire for 10 seconds and drained " + mpdrain + " MP from you.");
        victim.setCurrentMP(victim.getCurrentMP() - mpdrain);
        if((victim.isGhost() == true) && (victim.getCurrentMP() <= 0)){
            victim.setEliminated(true);
            for(Item it : victim.getLostItems()) {
                drainer.addItem(it);
            }
        }
        
        drainer.setCurrentMP(drainer.getCurrentMP() + mpdrain);        
    }
}

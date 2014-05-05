package jftha.cards;

import jftha.items.*;
import jftha.main.*;
import java.util.*;
import jftha.heroes.*;

public class FreeGold extends Card{
    
    /**
     * Gives 1-50 + 50% luck gold to "hero".
     * @param affected
     */
    @Override
    public void triggerEffect(Player affected){
        Random rand = new Random(System.currentTimeMillis());
        
        Hero playerHero = affected.getCharacter();
        int luck = playerHero.getLuck();
        //can be more or less gold. still need to figure out gold cost of items to balance out this effect
        //Player gets more gold base on 50% of luck.
        double initialFreeGold = rand.nextInt(50) + 1 + (luck * .5);
        int finalFG = (int) Math.round(initialFreeGold);
        //int freegold = rand.nextInt(50) + 1 + (luck * .5);
        this.setMessage("You have won the Ye Olde Lottery and have gained " + finalFG + " gold.");
        playerHero.setGold(playerHero.getGold() + finalFG);
    }
    
    /**NO EFFECT.
     * 
     */
    @Override
    public void triggerEffect(Player affected1, Player affected2){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

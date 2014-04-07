package jftha.cards;

import jftha.items.*;
import jftha.main.*;
import java.util.*;
import jftha.heroes.*;

public class FreeGold extends Card{
    
    @Override
    public void triggerEffect(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Gives 1-50 gold to "hero".
     * @param affected
     */
    @Override
    public void triggerEffect(Player affected){
        Random rand = new Random(System.currentTimeMillis());
        
        Hero playerHero = affected.getCharacter();
        //can be more or less gold. still need to figure out gold cost of items to balance out this effect
        int freegold = rand.nextInt(50) + 1;
        this.setMessage("You have won the Ye Olde Lottery and have gained " + freegold + " gold.");
        playerHero.setGold(playerHero.getGold() + freegold);
    }
    
    @Override
    public void triggerEffect(Player affected1, Player affected2){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void triggerEffect(Player affected1, Player affected2, Player affected3){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

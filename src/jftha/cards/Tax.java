package jftha.cards;

import java.util.*;
import jftha.main.*;
import jftha.spaces.*;

public class Tax extends Card{
    
    /**NO EFFECT.
     * 
     */
    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //May need to modify this
    public void triggerEffect(Player affected, Bank bank) {
         Random rand = new Random(System.currentTimeMillis());
         int tax = rand.nextInt(50) + 1;
         bank.collect(affected.getCharacter(), tax);
         this.setMessage("Today is a good day for medieval capitalism. Pay " + tax + " gold to the nobles.");
    }

    /**NO EFFECT.
     * 
     */
    @Override
    public void triggerEffect(Player affected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**NO EFFECT.
     * 
     */
    @Override
    public void triggerEffect(Player affected1, Player affected2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**NO EFFECT.
     * 
     */
    @Override
    public void triggerEffect(Player affected1, Player affected2, Player affected3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    
}

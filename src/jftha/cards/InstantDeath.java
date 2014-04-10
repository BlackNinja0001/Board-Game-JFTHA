package jftha.cards;

import jftha.items.*;
import jftha.main.*;
import jftha.spells.*;
import java.util.*;
import jftha.heroes.*;

public class InstantDeath extends Card{
    
    /**NO EFFECT.
     * 
     */
    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void triggerEffect(Player affected) {
        Hero playerHero = affected.getCharacter();
        if(playerHero.isGhost() == false){
            this.setMessage("It just occurred to you that your life really sucks. You then kill yourself.");
            playerHero.makeGhost();
        }else if(playerHero.isGhost() == true){
            this.setMessage("The Almighty One is really pissed off at you for no reason. You are now eliminated.");
            playerHero.setEliminated(true);
        }
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

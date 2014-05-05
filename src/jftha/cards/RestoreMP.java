package jftha.cards;

import jftha.heroes.*;
import jftha.main.*;

public class RestoreMP extends Card{
    
    /**
     * Takes in Player class as a parameter.
     * Fully restore current player's MP.
     * @param affected 
     */
    @Override
    public void triggerEffect(Player affected) {
        Hero hero = affected.getCharacter();
        hero.setCurrentMP(hero.getMaxMP());
        this.setMessage("You got drunk on magic potions. Restore MP to max.");
    }

    /**NO EFFECT.
     * 
     */
    @Override
    public void triggerEffect(Player affected1, Player affected2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

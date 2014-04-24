package jftha.cards;

import jftha.heroes.Hero;
import jftha.main.Player;

public class Insanity extends Card{

    /**NO EFFECT.
     * 
     */
    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * No Effect
     * @param affected 
     */
    @Override
    public void triggerEffect(Player affected) {
        
        this.setMessage("You thought that you could fly and jumped out a 2-story window. Lose 2 turns for physical and mental therapy.");
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

package jftha.cards;

import jftha.heroes.*;
import jftha.main.*;

public class RestoreAll extends Card{

    /**
     * Takes in Player class as a parameter.
     * Fully restore current player's HP and MP(only MP if Ghost).
     * @param affected 
     */
    @Override
    public void triggerEffect(Player affected) {
        Hero hero = affected.getCharacter();
        if(hero.isGhost() == false){
            hero.setCurrentHP(hero.getMaxHP());
            hero.setCurrentMP(hero.getMaxMP());
            this.setMessage("The Almighty One loves you. Restore HP and MP to max.");
        }else if(hero.isGhost() == true){
            hero.setCurrentMP(hero.getMaxMP());
            this.setMessage("The Almighty One loves you. Restore MP to max.");
        }
    }

    /**NO EFFECT.
     * 
     */
    @Override
    public void triggerEffect(Player affected1, Player affected2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

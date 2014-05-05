package jftha.cards;

import java.util.*;
import jftha.heroes.*;
import jftha.main.*;

public class RestoreHP extends Card{

    /**
     * Takes in Player class as a parameter.
     * Fully restore current player's HP(MP if Ghost).
     * @param affected 
     */
    @Override
    public void triggerEffect(Player affected) {
        Hero hero = affected.getCharacter();
        if(hero.isGhost() == false){
            hero.setCurrentHP(hero.getMaxHP());
        }else if(hero.isGhost() == true){
            hero.setCurrentMP(hero.getMaxMP());
        }
        this.setMessage("You were kissed by a magic fairy. Restore HP to max.");
    }

    /**NO EFFECT.
     * 
     */
    @Override
    public void triggerEffect(Player affected1, Player affected2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

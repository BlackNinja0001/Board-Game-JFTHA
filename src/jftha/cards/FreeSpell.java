package jftha.cards;

import jftha.heroes.Hero;
import jftha.items.ItemFactory;
import jftha.main.Player;
import jftha.spells.*;
import jftha.spells.SpellFactory;

public class FreeSpell extends Card{

    /**NO EFFECT.
     * 
     */
    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Takes in Player Class as a parameter.
     * Give current player a free spell.
     * @param affected 
     */
    @Override
    public void triggerEffect(Player affected) {
        Hero hero = affected.getCharacter();
        SpellFactory sf = new SpellFactory();
        Spell spell = sf.buildSpell();
        this.setMessage("Free giveaway from the store! You got a " + spell.toString() + "!");
        hero.addSpell(spell);
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

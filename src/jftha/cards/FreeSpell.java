package jftha.cards;

import jftha.heroes.Hero;
import jftha.items.ItemFactory;
import jftha.main.Player;
import jftha.spells.*;
import jftha.spells.SpellFactory;

public class FreeSpell extends Card{

    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void triggerEffect(Player affected) {
        Hero hero = affected.getCharacter();
        SpellFactory sf = new SpellFactory();
        Spell spell = sf.buildSpell(jftha.spells.SpellEnum.common);
        hero.addSpell(spell);
        this.setMessage("Free giveaway from the store! You got a " + spell.toString() + "!");
    }

    @Override
    public void triggerEffect(Player affected1, Player affected2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void triggerEffect(Player affected1, Player affected2, Player affected3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

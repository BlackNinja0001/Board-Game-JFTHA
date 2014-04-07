package jftha.cards;

import jftha.heroes.Hero;
import jftha.items.ItemFactory;
import jftha.main.Player;
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
        //hero.addItem(i.buildItem(jftha.items.RarityEnum.common));
        hero.addSpell(sf.buildSpell(jftha.spells.SpellEnum.common));
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

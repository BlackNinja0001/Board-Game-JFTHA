package jftha.cards;

import jftha.heroes.*;
import jftha.items.*;
import jftha.main.*;

public class FreeRareItem extends Card{

    /**NO EFFECT.
     * 
     */
    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Takes Player Class as a parameter.
     * Utilizes the ItemFactory Class to give current player a free rare item.
     * @param affected 
     */
    @Override
    public void triggerEffect(Player affected) {
        Hero hero = affected.getCharacter();
        ItemFactory i = new ItemFactory();
        Item item = i.buildItem(jftha.items.RarityEnum.rare);
        hero.addItem(item);
        this.setMessage("Free giveaway from the store! You got a " + item.toString() + "!");  
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

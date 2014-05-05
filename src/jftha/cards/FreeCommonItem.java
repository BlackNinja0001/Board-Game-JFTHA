package jftha.cards;

import java.util.*;
import jftha.heroes.*;
import jftha.items.*;
import jftha.main.*;

public class FreeCommonItem extends Card{

    /**
     * Takes in Player class as a parameter.
     * Utilizes the ItemFactory Class to randomly give current player a free common item.
     * @param affected 
     */
    @Override
    public void triggerEffect(Player affected) {
        Hero hero = affected.getCharacter();
        ItemFactory i = new ItemFactory();
        Item item;
        do {
            item = i.buildItem(jftha.items.RarityEnum.common);
            this.setMessage("Free giveaway from the store! You got a " + item.toString() + "!");
        } while(!hero.addItem(item));
    }

    /**NO EFFECT.
     * 
     */
    @Override
    public void triggerEffect(Player affected1, Player affected2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

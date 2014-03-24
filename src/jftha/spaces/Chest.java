package jftha.spaces;

import jftha.heroes.Hero;
import jftha.items.*;

public class Chest extends Space {
    public Chest() {
        setActivationType('l');
    }
    // Receive an item. The higher the Luck stat, the more likely a rare item will be in the chest.
    public void giveItem() {
        Hero h = getActivator();
        ItemFactory i = new ItemFactory();
        if(h.getLuck() > 10) {
            h.addItem(i.buildItem(RarityEnum.rare));
        } else if(h.getLuck() > 8) {
            h.addItem(i.buildItem(RarityEnum.uncommon));
        } else {
            h.addItem(i.buildItem(RarityEnum.common));
        }
    }
}

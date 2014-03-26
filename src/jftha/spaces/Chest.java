package jftha.spaces;

import java.util.*;
import jftha.heroes.*;
import jftha.items.*;

public class Chest extends Space {
    public Chest() {
        this.setActivationType('1');
    }
    // Receive an item. The higher the Luck stat, the more likely a rare item will be in the chest.
    public void giveItem() {
        Random rand = new Random(System.currentTimeMillis());
        Hero h = getActivator();
        int luck = rand.nextInt(100) + 1 + h.getLuck();
        ItemFactory i = new ItemFactory();
        if(luck > 90) {
            h.addItem(i.buildItem(RarityEnum.rare));
        } else if(luck > 75) {
            h.addItem(i.buildItem(RarityEnum.uncommon));
        } else {
            h.addItem(i.buildItem(RarityEnum.common));
        }
    }
}

package jftha.spaces;

import java.util.*;
import jftha.heroes.*;
import jftha.items.*;

public class Chest extends Space {
    public Chest() {
        this.setActivationType('L');
        this.setSpaceType(SpaceEnum.Chest);
    }
    
    // giveItem returns int for testing purposes.  Need to figure out how to get
    // rid of that
    @Override
    public void triggerEffect() {
        giveItem();
    }


    // Receive an item. The higher the Luck stat, the more likely a rare item will be in the chest.
    public int giveItem() {
        Random rand = new Random(System.currentTimeMillis());
        Hero h = getActivator();
        int luck = -1;
        // If was resurrected give back lostItems
        if(h.getWasGhost()) {
            List<Item> lost = h.getLostItems();
            Iterator<Item> iter = lost.iterator();
                while(iter.hasNext()) {
                    Item item = iter.next();
                    if(!item.getSpiritual())
                        h.addItem(item);
                }
                    h.setWasGhost(false);
                    return luck;
        } else {
            luck = rand.nextInt(100) + 1 + h.getLuck();
            ItemFactory i = new ItemFactory();
            Item item = null;
            if(luck > 90) {
                item = i.buildItem(RarityEnum.rare);
            } else if(luck > 75) {
                item = i.buildItem(RarityEnum.uncommon);
            } else if (luck > 0) {
                item = i.buildItem(RarityEnum.common);
            } else {
                throw new IllegalActivationTypeException();
            }
            h.addItem(item);
        }
        return luck;
    }

    @Override
    public void triggerEffect(Hero affected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

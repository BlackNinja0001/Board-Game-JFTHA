package jftha.spaces;

import java.util.*;
import jftha.heroes.*;
import jftha.items.*;
import jftha.main.Player;

public class Chest extends Space {

    /**
     * Constructor
     */
    public Chest() {
        this.setActivationType('L');
        this.setSpaceType(SpaceEnum.Chest);
    }

    @Override
    public void triggerEffect() {
        Random rand = new Random(System.currentTimeMillis());

        Player p = getActivator();
        Hero h = p.getCharacter();
        int luck = -1;
        // If was resurrected give back lostItems
        if (h.getWasGhost()) {
            List<Item> lost = h.getLostItems();
            Iterator<Item> iter = lost.iterator();
            while (iter.hasNext()) {
                Item item = iter.next();
                if (!item.getSpiritual()) {
                    h.addItem(item);
                    System.out.println(p.getCustomName() + " has pulled a " + item.toString() + " out of the Chest.\n");
                }
            }
            h.setWasGhost(false);
        } else {
            luck = rand.nextInt(100) + 1 + h.getLuck();
            ItemFactory i = new ItemFactory();
            Item item = null;
            if (luck > 90) {
                item = i.buildItem(RarityEnum.rare);
            } else if (luck > 75) {
                item = i.buildItem(RarityEnum.uncommon);
            } else if (luck > 0) {
                item = i.buildItem(RarityEnum.common);
            } else {
                throw new IllegalActivationTypeException();
            }
            h.addItem(item);
            System.out.println(p.getCustomName() + " has pulled a " + item.toString() + " out of the Chest.\n");
        }
    }
    
    /**
     * Receive an item. The higher the Luck stat, the more likely a rare item
     * will be in the chest.
     *
     * @return sb the message(s) to be printed out of the GUI
     */
    public StringBuilder triggerEffectGUI() {
        Random rand = new Random(System.currentTimeMillis());
        StringBuilder sb = new StringBuilder();

        Player p = getActivator();
        Hero h = p.getCharacter();
        int luck = -1;
        // If was resurrected give back lostItems
        if (h.getWasGhost()) {
            List<Item> lost = h.getLostItems();
            Iterator<Item> iter = lost.iterator();
            while (iter.hasNext()) {
                Item item = iter.next();
                if (!item.getSpiritual()) {
                    h.addItem(item);
                    sb.append(p.getCustomName() + " has pulled a " + item.toString() + " out of the Chest.\n");
                }
            }
            h.setWasGhost(false);
        } else {
            luck = rand.nextInt(100) + 1 + h.getLuck();
            ItemFactory i = new ItemFactory();
            Item item = null;
            if (luck > 90) {
                item = i.buildItem(RarityEnum.rare);
            } else if (luck > 75) {
                item = i.buildItem(RarityEnum.uncommon);
            } else if (luck > 0) {
                item = i.buildItem(RarityEnum.common);
            } else {
                throw new IllegalActivationTypeException();
            }
            h.addItem(item);
            sb.append(p.getCustomName() + " has pulled a " + item.toString() + " out of the Chest.\n");
        }
        return sb;
    }

    /**
     * No Effect
     *
     * @param affected
     */
    @Override
    public void triggerEffect(Player affected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

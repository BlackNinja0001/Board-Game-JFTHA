package jftha.items;

import java.util.Random;

public class ItemFactory {
    public Item buildItem(RarityEnum rarity) {
        Item item = null;
        ItemLists il = new ItemLists();
        Random rand = new Random(System.currentTimeMillis());
        int i, num;
        Class clazz;
        switch(rarity) {
            case common:
                i = il.getCommonSize();
                num = rand.nextInt(i);
                clazz = il.getCommonClass(num);
                try {
                    item = (Item)clazz.newInstance();
                } catch(IllegalAccessException | InstantiationException ex) {
                    
                }
                break;
            case uncommon:
                i = il.getUncommonSize();
                num = rand.nextInt(i);
                clazz = il.getUncommonClass(num);
                try {
                    item = (Item)clazz.newInstance();
                } catch(IllegalAccessException | InstantiationException ex) {
                    
                }
                break;
            case rare:
                i = il.getRareSize();
                num = rand.nextInt(i);
                clazz = il.getRareClass(num);
                try {
                    item = (Item)clazz.newInstance();
                } catch(IllegalAccessException | InstantiationException ex) {
                    
                }
                break;
            default:
                // throw error
                break;
        }
       
        return item;
    }
}

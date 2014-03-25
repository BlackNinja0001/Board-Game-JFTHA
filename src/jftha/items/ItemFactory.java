package jftha.items;

import java.util.Random;

public class ItemFactory {
    public Item buildItem(RarityEnum rarity) {
        Item item = null;
        Class itemClass;
        Random rand = new Random();
        switch(rarity) {
            case common:
                CommonItems ci = new CommonItems();
                int size = ci.commonClasses.size();
                int n = rand.nextInt(size);
                itemClass = ci.commonClasses.get(n);
                try {
                    item = (Item)itemClass.newInstance();
                }catch(InstantiationException ie) {
                    
                } catch(IllegalAccessException iae) {
                    
                }
                break;
            case uncommon:
                break;
            case rare:
                break;
            default:
                // throw error
                break;
        }
       
        return item;
    }
}

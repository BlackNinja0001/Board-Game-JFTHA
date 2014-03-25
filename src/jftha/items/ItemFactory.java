package jftha.items;

public class ItemFactory {
    public Item buildItem(RarityEnum rarity) {
        Item item = null;
        switch(rarity) {
            case common:
                
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

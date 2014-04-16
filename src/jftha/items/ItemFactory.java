package jftha.items;

import java.util.Random;

public class ItemFactory {
    public Item buildItem(RarityEnum rarity) {
        Item item = null;
        ItemLists itemList = new ItemLists();
        Random rand = new Random(System.currentTimeMillis());
        int i, num;
        Class clazz;
        switch(rarity) {
            case common:
                i = itemList.getCommonSize();
                num = rand.nextInt(i);
                clazz = itemList.getCommonClass(num);
                try {
                    item = (Item)clazz.newInstance();
                } catch(IllegalAccessException | InstantiationException ex) {
                    
                }
                break;
            case uncommon:
                i = itemList.getUncommonSize();
                num = rand.nextInt(i);
                clazz = itemList.getUncommonClass(num);
                try {
                    item = (Item)clazz.newInstance();
                } catch(IllegalAccessException | InstantiationException ex) {
                    
                }
                break;
            case rare:
                i = itemList.getRareSize();
                
                while (item == null) {
                    num = rand.nextInt(i);
                    clazz = itemList.getRareClass(num);
                
                    if(clazz.getSuperclass().equals(ArtifactPiece.class)){
                       try {
                            ArtifactPiece piece = (ArtifactPiece)clazz.newInstance();
                            if(piece.getOwner() == null) {
                                item = piece;
                            }
                        } catch(IllegalAccessException | InstantiationException ex) {
                        }
                       
                    } else {
                        try {
                            item = (Item)clazz.newInstance();
                        } catch(IllegalAccessException | InstantiationException ex) {
                        }
                    } // end else
                } //end while
                    
                break;
            default:
                throw new IllegalArgumentException("Oops. There is no such type of item.");
        }
       
        return item;
    }
}

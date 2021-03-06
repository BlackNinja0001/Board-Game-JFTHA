package jftha.cards;

import java.util.Random;

public class CardFactory {
    public Card buildCard(RarityEnum rarity) {
        Card item = null;
        CardLists cardList = new CardLists();
        Random rand = new Random(System.currentTimeMillis());
        int i, num;
        Class clazz;
        switch(rarity) {
            case common:
                i = cardList.getCommonSize();
                num = rand.nextInt(i);
                clazz = cardList.getCommonClass(num);
                try {
                    item = (Card)clazz.newInstance();
                } catch(IllegalAccessException | InstantiationException ex) {
                    
                }
                break;
            case uncommon:
                i = cardList.getUncommonSize();
                num = rand.nextInt(i);
                clazz = cardList.getUncommonClass(num);
                try {
                    item = (Card)clazz.newInstance();
                } catch(IllegalAccessException | InstantiationException ex) {
                    
                }
                break;
            case rare:
                i = cardList.getRareSize();
                num = rand.nextInt(i);
                clazz = cardList.getRareClass(num);
                try {
                    item = (Card)clazz.newInstance();
                } catch(IllegalAccessException | InstantiationException ex) {
                    
                }
                break;
            case veryRare:
                i = cardList.getVeryRareSize();
                num = rand.nextInt(i);
                clazz = cardList.getVeryRareClass(num);
                try {
                    item = (Card)clazz.newInstance();
                } catch(IllegalAccessException | InstantiationException ex) {
                    
                }
                break;
            case almostImpossible:
                i = cardList.getAlmostImpossibleSize();
                num = rand.nextInt(i);
                clazz = cardList.getAlmostImpossibleClass(num);
                try {
                    item = (Card)clazz.newInstance();
                } catch(IllegalAccessException | InstantiationException ex) {
                    
                }
                break;
            default:
                throw new IllegalArgumentException("Oops. There is no such type of card.");
        }
       
        return item;
    }
}

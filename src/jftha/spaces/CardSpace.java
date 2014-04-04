package jftha.spaces;

import java.util.Random;
import jftha.cards.*;

public class CardSpace extends Space {

    private Card drawn;

    public void drawNewCard() {
        CardFactory cf = new CardFactory();
        Random rand = new Random(System.currentTimeMillis());
        int luck = rand.nextInt(100) + 1;
        if (luck > 99) {
            drawn = cf.buildCard(RarityEnum.almostImpossible);
        } else if (luck > 90) {
            drawn = cf.buildCard(RarityEnum.veryRare);
        } else if (luck > 75) {
            drawn = cf.buildCard(RarityEnum.rare);
        } else if (luck > 50) {
            drawn = cf.buildCard(RarityEnum.uncommon);
        } else {
            drawn = cf.buildCard(RarityEnum.common);
        }
    }

    public void drawNewCard(RarityEnum rarity) {
        CardFactory cf = new CardFactory();
        drawn = cf.buildCard(rarity);
    }
    
    public void activateCard(){
        System.out.println(drawn.getMessage());
    }
}

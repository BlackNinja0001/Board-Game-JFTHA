package jftha.spaces;

import java.util.Random;
import jftha.heroes.Hero;
import jftha.cards.*;

public class CardSpace extends Space {
    
    public CardSpace() {
        this.setActivationType('L');
        this.setSpaceType(SpaceEnum.Card);
    }

    private Card drawn;

    @Override
    public void triggerEffect() {
        Hero hero = this.getActivator();
        CardFactory cf = new CardFactory();
        Random rand = new Random(System.currentTimeMillis());
        int luck = rand.nextInt(100) + hero.getLuck() + 1;
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

    @Override
    public void triggerEffect(Hero affected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

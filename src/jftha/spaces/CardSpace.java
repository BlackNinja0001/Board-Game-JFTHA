package jftha.spaces;

import java.util.Random;
import jftha.heroes.Hero;
import jftha.cards.*;
import jftha.main.Player;

public class CardSpace extends Space {
    
    /**
     * Constructor
     */
    public CardSpace() {
        this.setActivationType('L');
        this.setSpaceType(SpaceEnum.Card);
    }

    private Card drawn;

    /**
     * Uses the CardFactory Class to randomly generate a card.
     * Uses the effect of the specific Card.
     */
    @Override
    public void triggerEffect() {
        Player p = getActivator();
        Hero hero = p.getCharacter();
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
        if(drawn instanceof MPDrain){
            
        }else{
            drawn.triggerEffect(p);
        }
        System.out.println(drawn.getMessage());
    }

    /**
     * No Effect
     * @param rarity 
     */
    public void drawNewCard(RarityEnum rarity) {
        CardFactory cf = new CardFactory();
        drawn = cf.buildCard(rarity);
    }

    /**
     * No Effect
     * @param affected 
     */
    @Override
    public void triggerEffect(Player affected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

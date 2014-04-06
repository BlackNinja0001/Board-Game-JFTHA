package jftha.spaces;

import java.util.Random;
import jftha.heroes.Hero;

public class Gold extends Space {
    
    private int amount;
    
    public Gold() {
        this.setActivationType('p');
        this.setSpaceType(SpaceEnum.Gold);
        Random rand = new Random();
        amount = rand.nextInt(5) + 1; //1-5
    }

    /**
     * randomizes amount and amount2
     */
    public void randomize() {
        Random rand = new Random();
        amount = rand.nextInt(5) + 1; //1-5
    }

    /**
     * Heals a Hero's health OR magic
     *
     * @param recipient the Hero whose stat changes
     */
    public void giveGold(Hero recipient) {
        randomize();
        recipient.setGold(recipient.getGold() + amount);
        
    }
}

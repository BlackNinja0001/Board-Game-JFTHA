package jftha.spaces;

import java.util.Random;
import jftha.heroes.Hero;

public class Gold extends Space {
    
    private int amount;
    
    public Gold() {
        this.setActivationType('p');
        this.setSpaceType(SpaceEnum.Gold);
    }

    /**
     * randomizes amount
     */
    public void randomize() {
        Random rand = new Random();
        amount = rand.nextInt(5) + 1; //1-5
    }

    /**
     * Gives the hero an amount of gold between 1 and 5.
     *
     */
    @Override
    public void triggerEffect() {
        randomize();
        Hero recipient = this.getActivator();
        recipient.setGold(recipient.getGold() + amount);
        
    }
}

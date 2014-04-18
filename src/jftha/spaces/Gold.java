package jftha.spaces;

import java.util.Random;
import jftha.heroes.Hero;
import jftha.main.Player;

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
        Player p = getActivator();
        Hero recipient = p.getCharacter();
        recipient.setGold(recipient.getGold() + amount);
        
    }

    @Override
    public void triggerEffect(Player affected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

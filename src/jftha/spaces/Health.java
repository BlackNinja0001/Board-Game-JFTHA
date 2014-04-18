package jftha.spaces;

import java.util.Random;
import jftha.heroes.Hero;
import jftha.main.Player;

public class Health extends Space{

    private int statChange;
    private int statChange2; //Sometimes health and magic will be regenerated at the same time

    public Health() {
        this.setActivationType('p');
        this.setSpaceType(SpaceEnum.Health);
        Random rand = new Random();
        statChange = rand.nextInt(16) + 5; //5-20
        statChange2 = rand.nextInt(16) + 5; //5-20
    }

    /**
     * randomizes statChange and statChange2
     */
    public void randomize() {
        Random rand = new Random(System.currentTimeMillis());
        statChange = rand.nextInt(16) + 5; //5-20
        statChange2 = rand.nextInt(16) + 5; //5-20
    }
    
    /** Heals a Hero's health OR magic OR both. If player is lucky enough they 
     * get boost to both stats.  Otherwise one or the other.
     */
    @Override
    public void triggerEffect() {
        Player p = getActivator();
        Hero beingHealed = p.getCharacter();
        randomize();
        Random rand = new Random(System.currentTimeMillis());
        int luck = rand.nextInt(100) + 1 + beingHealed.getLuck();
        if(luck > 75) {
            beingHealed.setCurrentHP(beingHealed.getCurrentHP() + statChange);
            beingHealed.setCurrentMP(beingHealed.getCurrentMP() + statChange2);
        } else if (rand.nextBoolean()) {
            beingHealed.setCurrentHP(beingHealed.getCurrentHP() + statChange);
        } else {
            beingHealed.setCurrentMP(beingHealed.getCurrentMP() + statChange);
        }
    }

    @Override
    public void triggerEffect(Player affected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

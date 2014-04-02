package jftha.spaces;

import java.util.Random;
import jftha.heroes.Hero;

public class Health extends Space{

    private int statChange;
    private int statChange2; //Sometimes health and magic will be regenerated at the same time

    public Health() {
        this.setActivationType('p');
        Random rand = new Random();
        statChange = rand.nextInt(16) + 5; //5-20
        statChange2 = rand.nextInt(16) + 5; //5-20
    }

    /**
     * randomizes statChange and statChange2
     */
    public void randomize() {
        Random rand = new Random();
        statChange = rand.nextInt(16) + 5; //5-20
        statChange2 = rand.nextInt(16) + 5; //5-20
    }

    /**
     * Heals a Hero's health OR magic
     *
     * @param beingHealed the Hero whose stat changes
     * @param stat the stat to be changed; 'h' for health, 'm' for magic
     */
    public void heal(Hero beingHealed, char stat) {
        randomize();
        Character c = new Character(stat);
        if (c.equals(Character.toString('h'))) {
            beingHealed.setCurrentHP(beingHealed.getCurrentHP() + statChange);
        } else if (c.equals(Character.toString('m'))) {
            beingHealed.setCurrentMP(beingHealed.getCurrentMP() + statChange);
        }
    }

    /**
     * Heals a Hero's health OR magic
     *
     * @param beingHealed the Hero whose stat changes
     * @param stat the stat to be changed; 'hm' for health and magic; can only
     * be "hm"
     */
    public void heal(Hero beingHealed, String stat) {
        randomize();
        if (!stat.equalsIgnoreCase("hm")) {
            return; //invalid stat String
        } else {
            beingHealed.setCurrentHP(beingHealed.getCurrentHP() + statChange);
            beingHealed.setCurrentMP(beingHealed.getCurrentMP() + statChange2);
        }
    }
}

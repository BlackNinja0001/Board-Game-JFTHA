package jftha.statchanges;

import jftha.heroes.Hero;

public class Luck_TSC extends tempStatChange{

    /**
     * Constructor
     * @param duration
     * @param change 
     */
    public Luck_TSC(int duration, int change) {
        super(duration, change);
    }
    
    /**
     * Takes in Hero Class as a parameter.
     * Temporarily change current player's Luck for certain duration.
     * @param hero 
     */
    @Override
    public void triggerEffect(Hero hero) {
        int duration = this.getDuration();
        if (duration > 0) {
            if (!this.isInEffect()) {
                hero.setLuck(hero.getLuck() + this.getChange());
                this.setInEffect(true);
            }
            this.setDuration(--duration);
        } else {
            hero.setLuck(hero.getLuck() - this.getChange());
            this.setInEffect(false);
        }
    }
}

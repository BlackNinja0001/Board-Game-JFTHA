package jftha.statchanges;

import jftha.heroes.Hero;

public class MaxMP_TSC extends tempStatChange{

    /**
     * Constructor
     * @param duration
     * @param change 
     */
    public MaxMP_TSC(int duration, int change) {
        super(duration, change);
    }
    
    /**
     * Takes in Hero Class as a parameter.
     * Temporarily change current player's Max MP for certain duration.
     * @param hero 
     */
    @Override
    public void triggerEffect(Hero hero) {
        int duration = this.getDuration();
        if (duration > 0) {
            if (!this.isInEffect()) {
                hero.setMaxMP(hero.getMaxMP() + this.getChange());
                this.setInEffect(true);
            }
            this.setDuration(--duration);
        } else {
            hero.setMaxMP(hero.getMaxMP() - this.getChange());
            this.setInEffect(false);
        }
    }
}

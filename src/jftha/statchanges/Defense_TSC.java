package jftha.statchanges;

import jftha.heroes.Hero;

public class Defense_TSC extends tempStatChange{

    /**
     * Constructor
     * @param duration
     * @param change 
     */
    public Defense_TSC(int duration, int change) {
        super(duration, change);
    }
    
    /**
     * Takes in Hero Class as a parameter.
     * Temporarily change current player's Defense for certain duration.
     * @param hero 
     */
    @Override
    public void triggerEffect(Hero hero) {
        int duration = this.getDuration();
        if (duration > 0) {
            if (!this.isInEffect()) {
                hero.setDefense(hero.getDefense() + this.getChange());
                this.setInEffect(true);
            }
            this.setDuration(--duration);
        } else {
            hero.setDefense(hero.getDefense() - this.getChange());
            this.setInEffect(false);
        }
    }
}

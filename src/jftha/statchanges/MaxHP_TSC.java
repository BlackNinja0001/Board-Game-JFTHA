package jftha.statchanges;

import jftha.heroes.Hero;

public class MaxHP_TSC extends tempStatChange{

    /**
     * Constructor
     * @param duration
     * @param change 
     */
    public MaxHP_TSC(int duration, int change) {
        super(duration, change);
    }
    
    /**
     * Takes in Hero Class as a parameter.
     * Temporarily change current player's Max HP for certain duration.
     * @param hero 
     */
    @Override
    public void triggerEffect(Hero hero) {
        int duration = this.getDuration();
        if (duration > 0) {
            if (!this.isInEffect()) {
                hero.setMaxHP(hero.getMaxHP() + this.getChange());
                this.setInEffect(true);
            }
            this.setDuration(--duration);
        } else {
            hero.setMaxHP(hero.getMaxHP() - this.getChange());
            this.setInEffect(false);
        }
    }
}

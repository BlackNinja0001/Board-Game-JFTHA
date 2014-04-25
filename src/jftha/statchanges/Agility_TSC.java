package jftha.statchanges;

import jftha.heroes.Hero;

public class Agility_TSC extends tempStatChange{

    /**
     * Constructor.
     * @param duration
     * @param change 
     */
    public Agility_TSC(int duration, int change) {
        super(duration, change);
    }
    
    /**
     * Takes in Hero Class as a parameter.
     * Temporarily change Agility stat for a certain duration.
     * @param hero 
     */
    @Override
    public void triggerEffect(Hero hero) {
        int duration = this.getDuration();
        if (duration > 0) {
            if (!this.isInEffect()) {
                hero.setAgility(hero.getAgility() + this.getChange());
                this.setInEffect(true);
            }
            this.setDuration(--duration);
        } else {
            hero.setAgility(hero.getAgility() - this.getChange());
            this.setInEffect(false);
        }
    }
}

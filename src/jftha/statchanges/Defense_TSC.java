package jftha.statchanges;

import jftha.heroes.Hero;

public class Defense_TSC extends tempStatChange{

    public Defense_TSC(int duration, int change) {
        super(duration, change);
    }
    
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
            this.setInEffect(false);
        }
    }
}

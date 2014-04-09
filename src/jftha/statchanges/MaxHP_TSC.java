package jftha.statchanges;

import jftha.heroes.Hero;

public class MaxHP_TSC extends tempStatChange{

    public MaxHP_TSC(int duration, int change) {
        super(duration, change);
    }
    
    @Override
    public void triggerEffect(Hero hero) {
        int duration = this.getDuration();
        if (duration > 0) {
            if (!this.isInEffect()) {
                hero.setMaxHP(hero.getMaxHP() + this.getChange());
            }
            this.setDuration(--duration);
        }
    }
}

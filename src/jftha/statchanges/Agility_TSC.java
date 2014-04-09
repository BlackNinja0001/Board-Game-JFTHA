package jftha.statchanges;

import jftha.heroes.Hero;

public class Agility_TSC extends tempStatChange{

    public Agility_TSC(int duration, int change) {
        super(duration, change);
    }
    
    @Override
    public void triggerEffect(Hero hero) {
        int duration = this.getDuration();
        if (duration > 0) {
            if (!this.isInEffect()) {
                hero.setAgility(hero.getAgility() + this.getChange());
            }
            this.setDuration(--duration);
        }
    }
}

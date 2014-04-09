package jftha.statchanges;

import jftha.heroes.Hero;

public class Agility_TSC extends tempStatChange{
    
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

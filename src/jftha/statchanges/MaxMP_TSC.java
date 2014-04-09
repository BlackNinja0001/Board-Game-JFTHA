package jftha.statchanges;

import jftha.heroes.Hero;

public class MaxMP_TSC extends tempStatChange{
    @Override
    public void triggerEffect(Hero hero) {
        int duration = this.getDuration();
        if (duration > 0) {
            if (!this.isInEffect()) {
                hero.setMaxMP(hero.getMaxMP() + this.getChange());
            }
            this.setDuration(--duration);
        }
    }
}

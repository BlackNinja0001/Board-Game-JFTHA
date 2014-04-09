package jftha.statchanges;

import jftha.heroes.Hero;

public class Strength_TSC extends tempStatChange {

    public Strength_TSC(int duration, int change) {
        super(duration, change);
    }

    @Override
    public void triggerEffect(Hero hero) {
        int duration = this.getDuration();
        if (duration > 0) {
            if (!this.isInEffect()) {
                hero.setStrength(hero.getStrength() + this.getChange());
            }
            this.setDuration(--duration);
        }
    }
}
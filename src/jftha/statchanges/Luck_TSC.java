package jftha.statchanges;

import jftha.heroes.Hero;

public class Luck_TSC extends tempStatChange{

    public Luck_TSC(int duration, int change) {
        super(duration, change);
    }
    
    @Override
    public void triggerEffect(Hero hero) {
        int duration = this.getDuration();
        if (duration > 0) {
            if (!this.isInEffect()) {
                hero.setLuck(hero.getLuck() + this.getChange());
            }
            this.setDuration(--duration);
        }
    }
}

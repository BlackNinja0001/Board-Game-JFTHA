package jftha.statchanges;

import jftha.heroes.Hero;

public class Magic_TSC extends tempStatChange{
    @Override
    public void triggerEffect(Hero hero) {
        int duration = this.getDuration();
        if (duration > 0) {
            if (!this.isInEffect()) {
                hero.setMagic(hero.getMagic() + this.getChange());
            }
            this.setDuration(--duration);
        }
    }
}

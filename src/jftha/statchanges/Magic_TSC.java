package jftha.statchanges;

import jftha.heroes.Hero;

public class Magic_TSC extends tempStatChange{

    public Magic_TSC(int duration, int change) {
        super(duration, change);
    }
    
    @Override
    public void triggerEffect(Hero hero) {
        int duration = this.getDuration();
        if (duration > 0) {
            if (!this.isInEffect()) {
                hero.setMagic(hero.getMagic() + this.getChange());
                this.setInEffect(true);
            }
            this.setDuration(--duration);
        } else {
            hero.setMagic(hero.getMagic() - this.getChange());
            this.setInEffect(false);
        }
    }
}

package jftha.statchanges;

import jftha.heroes.Hero;

public class Gold_SCPT extends statChangePerTurn {

    public Gold_SCPT(int duration, int change) {
        super(duration, change);
    }

    @Override
    public void triggerEffect(Hero hero) {
        int curGold = hero.getGold();
        int duration = this.getDuration();
        if (duration > 0) {
            hero.setGold(curGold + this.getChange());
            this.setDuration(--duration);
        }
    }
}

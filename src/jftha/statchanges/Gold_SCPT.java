package jftha.statchanges;

import jftha.heroes.Hero;

public class Gold_SCPT extends statChangePerTurn {

    /**
     * Constructor
     * @param duration
     * @param change 
     */
    public Gold_SCPT(int duration, int change) {
        super(duration, change);
    }

    /**
     * Takes in Hero Class as a parameter.
     * Change current player's gold for certain duration.
     * @param hero 
     */
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

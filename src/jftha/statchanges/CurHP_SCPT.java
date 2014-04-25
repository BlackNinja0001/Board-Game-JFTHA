package jftha.statchanges;

import jftha.heroes.Hero;

public class CurHP_SCPT extends statChangePerTurn {

    /**
     * Constructor
     * @param duration
     * @param change 
     */
    public CurHP_SCPT(int duration, int change) {
        super(duration, change);
    }

    /**
     * Takes in Hero Class as a parameter.
     * Change current player's current HP
     * @param hero 
     */
    @Override
    public void triggerEffect(Hero hero) {
        int duration = this.getDuration();
        if (duration > 0) {
            int curHP = hero.getCurrentHP();
            hero.setCurrentHP(curHP + this.getChange());
            if (curHP <= 0) {
                hero.makeGhost();
            }
            this.setDuration(--duration);
        }
    }
}

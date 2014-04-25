package jftha.statchanges;

import jftha.heroes.Hero;

public class CurMP_SCPT extends statChangePerTurn {

    /**
     * Constructor
     * @param duration
     * @param change 
     */
    public CurMP_SCPT(int duration, int change) {
        super(duration, change);
    }

    /**
     * Takes in Hero Class as a parameter.
     * Change current player's current MP.
     * @param hero 
     */
    @Override
    public void triggerEffect(Hero hero) {
        int curMP = hero.getCurrentMP();
        int duration = this.getDuration();
        if (duration > 0) {
                hero.setCurrentMP(curMP + this.getChange());
            if (curMP <= 0 && hero.isGhost()) {
                hero.makeGhost();
            }
            this.setDuration(--duration);
        }
    }
}

package jftha.statchanges;

import jftha.heroes.Hero;

public abstract class tempStatChange {
    private int duration;
    private int change;
    private boolean inEffect;

    public tempStatChange() {
        duration = 0;
        change = 0;
    }
    
    public tempStatChange(int duration, int change) {
        this.duration = duration;
        this.change = change;
    }

    public int getDuration() {
        return duration;
    }
    
    public int getChange() {
        return change;
    }
    
    public boolean isInEffect() {
        return inEffect;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    public void setChange(int change) {
        this.change = change;
    }
    
    public void setInEffect(boolean inEffect) {
        this.inEffect = inEffect;
    }
    
    public abstract void triggerEffect(Hero hero);
    
}

package jftha.spaces;

import jftha.heroes.*;

public abstract class Space {
    private int spaceID;
    private char activationType; //p for pass-by, l for land-on
    private Hero activator;
    private SpaceEnum type;
    public Space next;
    public Space prev;

   //Getter Methods
    public SpaceEnum getSpaceType() {
        return type;
    }

    public char getActivationType() {
        return activationType;
    }

    public int getSpaceID() {
        return spaceID;
    }
    public Hero getActivator() {
        return activator;
    }

    // Setter method
    protected void setActivationType(char c) {
        activationType = c;
    }

    public void setActivator(Hero hero) {
        this.activator = hero;
    }
    
    protected void setSpaceType(SpaceEnum type) {
        this.type = type;
    }
    
    public void setSpaceID(int spaceID) {
        this.spaceID = spaceID;
    }
    
    //to be implemented in sublcasses
    public abstract void triggerEffect();
}

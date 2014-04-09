package jftha.statchanges;

import jftha.heroes.Hero;

//This class was made to distinguish HP/MP/Gold changes 
//from Strength/Agility/etc. changes, which do not change per turn.
public abstract class statChangePerTurn extends tempStatChange{

    public statChangePerTurn() {
        super();
    }
    
    public statChangePerTurn(int duration, int change) {
        super(duration, change);
    }
    
}

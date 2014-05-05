package jftha.spaces;

import jftha.main.Player;

public class BlankSpace extends Space {
    
    /**
     * Constructor
     */
    public BlankSpace() {
        this.setActivationType('L');
        this.setSpaceType(SpaceEnum.Blank);
    }
}

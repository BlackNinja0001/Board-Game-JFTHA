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
    
    /**
     * No Effect
     */
    @Override
    public void triggerEffect() {
        // Do Nothing: Blank space
    }
    
    /**
     * No Effect
     * @param affected 
     */
    @Override
    public void triggerEffect(Player affected) {
        // Do nothing: Blank space
    }
}

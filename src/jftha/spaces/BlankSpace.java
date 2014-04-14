package jftha.spaces;

import jftha.heroes.Hero;

public class BlankSpace extends Space {
    public BlankSpace() {
        this.setActivationType('L');
        this.setSpaceType(SpaceEnum.Blank);
    }
    @Override
    public void triggerEffect() {
        // Do Nothing: Blank space
    }
    
    @Override
    public void triggerEffect(Hero affected) {
        // Do nothing: Blank space
    }
}

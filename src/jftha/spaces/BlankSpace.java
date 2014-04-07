package jftha.spaces;

public class BlankSpace extends Space {
    public BlankSpace() {
        this.setActivationType('l');
        this.setSpaceType(SpaceEnum.Blank);
    }
    @Override
    public void triggerEffect() {
        // Do Nothing: Blank space
    }
}

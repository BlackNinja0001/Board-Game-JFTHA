package jftha.spaces;

import jftha.main.Player;

public abstract class AttackSpace extends Space {
    // to be implemented in subclasses
    public abstract void triggerEffect(Player affected);
}

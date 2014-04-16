package jftha.items;

import jftha.heroes.Hero;

public abstract class ArtifactPiece extends Item {
    private Hero owner = null;
    
    public void setOwner(Hero owner) {
        this.owner = owner;
    }
    public Hero getOwner() {
        return owner;
    }
}

package jftha.items;

import jftha.heroes.Hero;

public class ArtifactPiece2 extends ArtifactPiece {
    private static final ArtifactPiece2 INSTANCE = new ArtifactPiece2();
    
    private ArtifactPiece2() {
        this.setRarity(RarityEnum.rare);
        this.setGoldCost(500);
    }
    
    public static ArtifactPiece2 getInstance() {
        return INSTANCE;
    }

    @Override
    public void triggerEffect() {}

    @Override
    public void triggerEffect(Hero affected) {}

    @Override
    public void triggerEffect(Hero affected1, Hero affected2) {}
}

package jftha.items;

import jftha.heroes.Hero;

public class ArtifactPiece3 extends ArtifactPiece {
    private static final ArtifactPiece3 INSTANCE = new ArtifactPiece3();
    
    private ArtifactPiece3() {
        this.setRarity(RarityEnum.rare);
        this.setGoldCost(500);
    }
    
    public static ArtifactPiece3 getInstance() {
        return INSTANCE;
    }

    @Override
    public void triggerEffect() {}

    @Override
    public void triggerEffect(Hero affected) {}

    @Override
    public void triggerEffect(Hero affected1, Hero affected2) {}
}

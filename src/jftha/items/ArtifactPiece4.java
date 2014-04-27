package jftha.items;

import jftha.heroes.Hero;

public class ArtifactPiece4 extends ArtifactPiece {
    private static final ArtifactPiece4 INSTANCE = new ArtifactPiece4();
    
    private ArtifactPiece4() {
        this.setRarity(RarityEnum.rare);
        this.setGoldCost(500);
    }
    
    public static ArtifactPiece4 getInstance() {
        return INSTANCE;
    }

    @Override
    public void triggerEffect() {}

    @Override
    public void triggerEffect(Hero affected) {}

    @Override
    public void triggerEffect(Hero affected1, Hero affected2) {}
}

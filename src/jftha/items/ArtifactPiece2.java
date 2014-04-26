package jftha.items;

import jftha.main.Player;

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
    public void triggerEffect(Player affected) {}

    @Override
    public void triggerEffect(Player affected1, Player affected2) {}
}

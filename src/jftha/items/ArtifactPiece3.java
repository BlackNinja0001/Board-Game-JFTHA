package jftha.items;

import jftha.main.Player;

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
    public void triggerEffect(Player affected) {}

    @Override
    public void triggerEffect(Player affected1, Player affected2) {}
}

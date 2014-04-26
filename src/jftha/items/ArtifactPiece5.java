package jftha.items;

import jftha.main.Player;

public class ArtifactPiece5 extends ArtifactPiece {
    private static final ArtifactPiece5 INSTANCE = new ArtifactPiece5();
    
    private ArtifactPiece5() {
        this.setRarity(RarityEnum.rare);
        this.setGoldCost(500);
    }
    
    public static ArtifactPiece5 getInstance() {
        return INSTANCE;
    }

    @Override
    public void triggerEffect() {}

    @Override
    public void triggerEffect(Player affected) {}

    @Override
    public void triggerEffect(Player affected1, Player affected2) {}
}

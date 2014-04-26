package jftha.items;

import jftha.main.Player;

public class ArtifactPiece1 extends ArtifactPiece {
    private static final ArtifactPiece1 INSTANCE = new ArtifactPiece1();

    private ArtifactPiece1() {
        this.setRarity(RarityEnum.rare);  
        this.setGoldCost(500);
    }
    
    public static ArtifactPiece1 getInstance() {
        return INSTANCE;
    }
    
    @Override
    public void triggerEffect() {}

    @Override
    public void triggerEffect(Player affected) {}

    @Override
    public void triggerEffect(Player affected1, Player affected2) {}
}

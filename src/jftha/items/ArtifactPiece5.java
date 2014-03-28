package jftha.items;

public class ArtifactPiece5 extends ArtifactPiece {
    private static final ArtifactPiece5 INSTANCE = new ArtifactPiece5();
    
    protected ArtifactPiece5() {
        this.setRarity(RarityEnum.rare);
        this.setGoldCost(500);
    }
    
    public static ArtifactPiece5 getInstance() {
        return INSTANCE;
    }
}

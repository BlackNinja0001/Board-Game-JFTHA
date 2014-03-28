package jftha.items;

public class ArtifactPiece3 extends ArtifactPiece {
    private static final ArtifactPiece3 INSTANCE = new ArtifactPiece3();
    
    protected ArtifactPiece3() {
        this.setRarity(RarityEnum.rare);
        this.setGoldCost(500);
    }
    
    public static ArtifactPiece3 getInstance() {
        return INSTANCE;
    }
}

package jftha.items;

public class ArtifactPiece2 extends ArtifactPiece {
    private static final ArtifactPiece2 INSTANCE = new ArtifactPiece2();
    
    protected ArtifactPiece2() {
        this.setRarity(RarityEnum.rare);
        this.setGoldCost(500);
    }
    
    public static ArtifactPiece2 getInstance() {
        return INSTANCE;
    }
}

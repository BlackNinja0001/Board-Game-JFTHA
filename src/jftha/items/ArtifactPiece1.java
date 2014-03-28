package jftha.items;

public class ArtifactPiece1 extends ArtifactPiece {
    private static final ArtifactPiece1 INSTANCE = new ArtifactPiece1();
    
    protected ArtifactPiece1() {
        this.setRarity(RarityEnum.rare);
        this.setGoldCost(500);
    }
    
    public static ArtifactPiece1 getInstance() {
        return INSTANCE;
    }
}

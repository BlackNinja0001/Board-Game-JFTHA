package jftha.items;

public class ArtifactPiece4 extends ArtifactPiece {
    private static final ArtifactPiece4 INSTANCE = new ArtifactPiece4();
    
    protected ArtifactPiece4() {
        this.setRarity(RarityEnum.rare);
        this.setGoldCost(500);
    }
    
    public static ArtifactPiece4 getInstance() {
        return INSTANCE;
    }
}

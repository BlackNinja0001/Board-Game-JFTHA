package jftha.items;

public class ArtifactPiece2 extends ArtifactPiece {
    private static ArtifactPiece2 instance = null;
    
    protected ArtifactPiece2() {
        this.setRarity(RarityEnum.rare);
        this.setGoldCost(500);
    }
    
    public static ArtifactPiece2 getInstance() {
        if(instance == null) {
            instance = new ArtifactPiece2();
        }
        return instance;
    }
}

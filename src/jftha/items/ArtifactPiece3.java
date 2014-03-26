package jftha.items;

public class ArtifactPiece3 extends ArtifactPiece {
    private static ArtifactPiece3 instance = null;
    
    protected ArtifactPiece3() {
        this.setRarity(RarityEnum.rare);
        this.setGoldCost(500);
    }
    
    public static ArtifactPiece3 getInstance() {
        if(instance == null) {
            instance = new ArtifactPiece3();
        }
        return instance;
    }
}

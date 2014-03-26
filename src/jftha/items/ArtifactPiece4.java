package jftha.items;

public class ArtifactPiece4 extends ArtifactPiece {
    private static ArtifactPiece4 instance = null;
    
    protected ArtifactPiece4() {
        this.setRarity(RarityEnum.rare);
        this.setGoldCost(500);
    }
    
    public static ArtifactPiece4 getInstance() {
        if(instance == null) {
            instance = new ArtifactPiece4();
        }
        return instance;
    }
}

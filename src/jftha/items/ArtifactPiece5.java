package jftha.items;

public class ArtifactPiece5 extends ArtifactPiece {
    private static ArtifactPiece5 instance = null;
    
    protected ArtifactPiece5() {
        this.setRarity(RarityEnum.rare);
        this.setGoldCost(500);
    }
    
    public static ArtifactPiece5 getInstance() {
        if(instance == null) {
            instance = new ArtifactPiece5();
        }
        return instance;
    }
}

package jftha.items;

public class ArtifactPiece1 extends ArtifactPiece {
    private static ArtifactPiece1 instance = null;
    
    protected ArtifactPiece1() {
        this.setRarity(RarityEnum.rare);
        this.setGoldCost(500);
    }
    
    public static ArtifactPiece1 getInstance() {
        if(instance == null) {
            instance = new ArtifactPiece1();
        }
        return instance;
    }
}

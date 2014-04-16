package jftha.items;

import jftha.main.Player;

public class ArtifactPiece1 extends ArtifactPiece {
    private static final ArtifactPiece1 INSTANCE = new ArtifactPiece1();

    protected ArtifactPiece1() {
        this.setRarity(RarityEnum.rare);  
        this.setGoldCost(500);
    }
    
    public static ArtifactPiece1 getInstance() {
        return INSTANCE;
    }
    
    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void triggerEffect(Player affected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void triggerEffect(Player affected1, Player affected2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void triggerEffect(Player affected1, Player affected2, Player affected3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

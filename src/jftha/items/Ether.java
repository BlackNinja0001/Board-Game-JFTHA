package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class Ether extends Item{
    private final int recoverMP = 10;
    
    /**
     * Constructor
     */
    public Ether(){
        this.setRarity(RarityEnum.common);
        this.setMessage("Ether: Recover 10MP");
        this.setGoldCost(50);
    }

    /**
     * No Effect
     */
    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Takes in Player class as a parameter.
     * Current player restores 10MP.
     * @param affected 
     */
    @Override
    public void triggerEffect(Player affected) {
        Hero hero = affected.getCharacter();
        hero.setCurrentMP(hero.getCurrentMP() + recoverMP);
    }

    /**
     * No Effect
     * @param affected1
     * @param affected2 
     */
    @Override
    public void triggerEffect(Player affected1, Player affected2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * No Effect
     * @param affected1
     * @param affected2
     * @param affected3 
     */
    @Override
    public void triggerEffect(Player affected1, Player affected2, Player affected3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

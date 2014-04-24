package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class HiEther extends Item{
    private final int recoverMP = 25;
    
    /**
     * Constructor
     */
    public HiEther(){
        this.setRarity(RarityEnum.uncommon);
        this.setMessage("Hi-Ether: Recover 25MP");
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
     * Current player restores 25MP.
     * @param affected 
     */
    @Override
    public void triggerEffect(Player affected) {
        Hero hero = affected.getCharacter();
        hero.setCurrentMP(hero.getCurrentMP() + recoverMP);
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

package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class Elixir extends Item{
    
    /**
     * Constructor
     */
    public Elixir(){
        this.setRarity(RarityEnum.rare);
        this.setMessage("Elixir: fully Recover HP/MP");
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
     * Fully restore current player's HP and MP.
     * @param affected 
     */
    @Override
    public void triggerEffect(Player affected) {
        Hero hero = affected.getCharacter();
        hero.setCurrentHP(hero.getMaxHP());
        hero.setCurrentMP(hero.getMaxMP());
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

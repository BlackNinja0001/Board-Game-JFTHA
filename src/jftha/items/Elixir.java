package jftha.items;

import jftha.heroes.Hero;

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
    public void triggerEffect() {}

    /**
     * Takes in Hero class as a parameter.
     * Fully restore current player's HP and MP.
     * @param affected 
     */
    @Override
    public void triggerEffect(Hero hero) {
        hero.setCurrentHP(hero.getMaxHP());
        hero.setCurrentMP(hero.getMaxMP());
    }

    /**
     * No Effect
     * @param affected1
     * @param affected2 
     */
    @Override
    public void triggerEffect(Hero affected1, Hero affected2) {}
}

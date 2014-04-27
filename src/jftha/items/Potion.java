package jftha.items;

import jftha.heroes.Hero;

public class Potion extends Item{
    private final int heal = 20;
    
    /**
     * Constructor
     */
    public Potion(){
        this.setRarity(RarityEnum.common);
        this.setMessage("Potion: Recover 20HP");
        this.setGoldCost(50);
    }

    /**
     * No Effect
     */
    @Override
    public void triggerEffect() {}

    /**
     * Takes in Hero Class as a parameter.
     * Current player restores 20HP.
     * @param affected 
     */
    @Override
    public void triggerEffect(Hero hero) {
        hero.setCurrentHP(hero.getCurrentHP() + heal);
    }

    @Override
    public void triggerEffect(Hero affected1, Hero affected2) {}
}

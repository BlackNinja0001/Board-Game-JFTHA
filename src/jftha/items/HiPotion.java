package jftha.items;

import jftha.heroes.Hero;

public class HiPotion extends Item{
    private final int heal = 50;
    
    /**
     * Constructor
     */
    public HiPotion(){
        this.setRarity(RarityEnum.uncommon);
        this.setMessage("Hi-Potion: Recover 50HP");
        this.setGoldCost(50);
    }

    /**
     * No Effect
     */
    @Override
    public void triggerEffect() {}

    /**
     * Takes in Hero class as a parameter.
     * Current player restores 50HP.
     * @param affected 
     */
    @Override
    public void triggerEffect(Hero hero) {
        hero.setCurrentHP(hero.getCurrentHP() + heal);
    }

    @Override
    public void triggerEffect(Hero affected1, Hero affected2) {}
}

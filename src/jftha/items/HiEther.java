package jftha.items;

import jftha.heroes.Hero;

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
    public void triggerEffect() {}

    /**
     * Takes in Hero class as a parameter.
     * Current player restores 25MP.
     * @param hero
     */
    @Override
    public void triggerEffect(Hero hero) {
        hero.setCurrentMP(hero.getCurrentMP() + recoverMP);
    }

    @Override
    public void triggerEffect(Hero affected1, Hero affected2) {}
}

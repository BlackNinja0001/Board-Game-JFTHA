package jftha.items;

import jftha.heroes.Hero;

public class Tuxedo extends Item {
    
    /**
     * Constructor
     */
    public Tuxedo() {
        this.setRarity(RarityEnum.common);
        this.setMessage("Tuxedo");
        this.setGoldCost(50);
    }

    /**
     * No Effect
     */
    @Override
    public void triggerEffect() {}

    /**
     * No Effect
     * @param affected 
     */
    @Override
    public void triggerEffect(Hero affected) {}

    /**
     * No Effect
     * @param affected1
     * @param affected2 
     */
    @Override
    public void triggerEffect(Hero affected1, Hero affected2) {}
}

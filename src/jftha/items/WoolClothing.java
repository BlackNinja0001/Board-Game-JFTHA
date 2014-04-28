package jftha.items;

import jftha.heroes.Hero;

public class WoolClothing extends Item {
    
    /**
     * Constructor
     */
    public WoolClothing() {
        this.setRarity(RarityEnum.common);
        this.setMessage("Wool Clothing");
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

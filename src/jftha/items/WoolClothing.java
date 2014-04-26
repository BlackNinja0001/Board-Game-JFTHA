package jftha.items;

import jftha.main.Player;

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
    public void triggerEffect(Player affected) {}

    /**
     * No Effect
     * @param affected1
     * @param affected2 
     */
    @Override
    public void triggerEffect(Player affected1, Player affected2) {}
}

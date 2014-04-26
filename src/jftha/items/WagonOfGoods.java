package jftha.items;

import jftha.main.Player;

public class WagonOfGoods extends Item {
    
    /**
     * Constructor
     */
    public WagonOfGoods() {
        this.setRarity(RarityEnum.common);
        this.setMessage("Wagon of Goods");
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

package jftha.items;

import jftha.heroes.Hero;


public class ShiningArmor extends Armor {
    private final int hp = 20;
    private final int def = 5;
    
    /**
     * Constructor
     */
    public ShiningArmor() {
        this.setRarity(RarityEnum.uncommon);
        this.setMessage("Shining Armor: +" + hp + " HP, " + "+" + def + " Defense");
        this.setGoldCost(50);
    }

    /**
     * Lets current hero equip this armor.
     * @param hero The hero that is equipping the armor.
     */
    @Override
    public void equipArmor(Hero hero) {
        hero.setArmor(this);
        hero.setHasArmor(true);
        hero.setMaxHP(hero.getMaxHP() + hp);
        hero.setDefense(hero.getDefense() + def);
    }

    /**
     * 
     * Lets current hero un-equip this armor.
     * @param hero The character that is un-equipping the armor.
     */
    @Override
    public void dropArmor(Hero hero) {
        hero.setArmor(null);
        hero.setHasArmor(false);
        hero.setMaxHP(hero.getMaxHP() - hp);
        hero.setDefense(hero.getDefense() - def);
    }
    
    /**
     * No Effect.
     * @param hero 
     */
    @Override
    public void armorEffect(Hero hero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

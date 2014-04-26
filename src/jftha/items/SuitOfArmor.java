package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class SuitOfArmor extends Armor{
    private final int def = 2;
    
    /**
     * Constructor
     */
    public SuitOfArmor(){
        this.setRarity(RarityEnum.common);
        this.setMessage("Suit of Armor: +" + def + " Defense");
        this.setGoldCost(50);
    }

    /**
     * Lets current hero equip this armor.
     * @param hero The hero that is equipping the armor.
     */
    @Override
    public void equipArmor(Hero hero) {
        hero.setArmor(this);
        hero.setArmorEquipped(true);
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
        hero.setArmorEquipped(false);
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

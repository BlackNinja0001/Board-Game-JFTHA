package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class Cloak extends Armor {
    private final int agility = 2;
    
    /**
     * Constructor
     */
    public Cloak() {
        this.setRarity(RarityEnum.common);
        this.setMessage("Cloak: +" + agility + " Agility");
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
        hero.setAgility(hero.getAgility() + agility);
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
        hero.setAgility(hero.getAgility() - agility);
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

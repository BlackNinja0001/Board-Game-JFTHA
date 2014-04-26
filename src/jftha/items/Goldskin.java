package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class Goldskin extends Armor {
    private final int strength = 10;
    private final int hp = 25;
    private final int def = 6;
    
    /**
     * Constructor
     */
    public Goldskin() {
        this.setRarity(RarityEnum.rare);
        this.setMessage("Goldskin: +" + hp + " HP, +" + strength + " Strength, +" + def + " Defense");
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
        hero.setMaxHP(hero.getMaxHP() + hp);
        hero.setDefense(hero.getDefense() + def);
        hero.setStrength(hero.getStrength() + strength);
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
        hero.setMaxHP(hero.getMaxHP() - hp);
        hero.setDefense(hero.getDefense() - def);
        hero.setStrength(hero.getStrength() - strength);
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

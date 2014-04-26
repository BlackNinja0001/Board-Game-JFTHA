package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class DivineBlade extends Weapon {
    private final int strength = 4;
    
    /**
     * Constructor
     */
    public DivineBlade() {
        this.setRarity(RarityEnum.common);
        this.setMessage("Divine Blade: +" + strength + " Strength");
        this.setGoldCost(50);
    }

    /**
     * Lets current hero equip this weapon.
     * @param hero The hero that is equipping the weapon.
     */
    @Override
    public void equipWeap(Hero hero) {
        hero.setWeapon(this);
        hero.setWeaponEquipped(true);
        hero.setStrength(hero.getStrength() + strength);
    }

    /**
     * Lets current player un-equip this weapon.
     * @param hero The hero that is un-equipping the weapon.
     */
    @Override
    public void dropWeap(Hero hero) {
        hero.setWeapon(null);
        hero.setWeaponEquipped(false);
        hero.setStrength(hero.getStrength() - strength);
    }

    /**
     * No Effect
     * @param hero 
     */
    @Override
    public void weapEffect(Hero hero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

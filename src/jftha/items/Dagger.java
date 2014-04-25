package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class Dagger extends Weapon {
    private final int strength = 2;
    private final int agility = 1;
    
    /**
     * Constructor
     */
    public Dagger() {
        this.setRarity(RarityEnum.common);
        this.setMessage("Dagger: +" + strength + " Strength, " + "+" + agility + " Agility");
        this.setGoldCost(50);
    }
    
    /**
     * Lets current hero equip this weapon.
     * @param hero The hero that is equipping the weapon.
     */
    @Override
    public void equipWeap(Hero hero) {
        hero.setWeapon(this);
        hero.setHasWeapon(true);
        hero.setStrength(hero.getStrength() + strength);
        hero.setAgility(hero.getAgility() + agility);
    }

    /**
     * Lets current player un-equip this weapon.
     * @param hero The hero that is un-equipping the weapon.
     */
    @Override
    public void dropWeap(Hero hero) {
        hero.setWeapon(null);
        hero.setHasWeapon(false);
        hero.setStrength(hero.getStrength() - strength);
        hero.setAgility(hero.getAgility() - agility);
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

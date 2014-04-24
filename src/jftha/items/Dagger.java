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
     * Takes in Player class as a parameter.
     * Lets current player equip this weapon.
     * @param player 
     */
    @Override
    public void equipWeap(Player player) {
        Hero hero = player.getCharacter();
        player.setWeapon(this);
        player.setHasWeapon(true);
        hero.setStrength(hero.getStrength() + strength);
        hero.setAgility(hero.getAgility() + agility);
    }

    /**
     * Takes in Player class as a parameter.
     * Lets current player un-equip this weapon.
     * @param player 
     */
    @Override
    public void dropWeap(Player player) {
        Hero hero = player.getCharacter();
        player.setWeapon(null);
        player.setHasWeapon(false);
        hero.setStrength(hero.getStrength() - strength);
        hero.setAgility(hero.getAgility() - agility);
    }

    /**
     * No Effect
     * @param player 
     */
    @Override
    public void weapEffect(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

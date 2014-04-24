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
     * Takes in Player class as a parameter.
     * Lets current player equip this armor.
     * @param player 
     */
    @Override
    public void equipArmor(Player player) {
        Hero hero = player.getCharacter();
        player.setArmor(this);
        player.setHasArmor(true);
        hero.setAgility(hero.getAgility() + agility);
    }

    /**
     * Takes in Player class as a parameter.
     * Lets current player un-equip this armor.
     * @param player 
     */
    @Override
    public void dropArmor(Player player) {
        Hero hero = player.getCharacter();
        player.setArmor(null);
        player.setHasArmor(false);
        hero.setAgility(hero.getAgility() - agility);
    }

    /**
     * No Effect
     * @param player 
     */
    @Override
    public void armorEffect(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

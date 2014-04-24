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
     * Takes in Player class as a parameter.
     * Lets current player equip this armor.
     * @param player 
     */
    @Override
    public void equipArmor(Player player) {
        Hero hero = player.getCharacter();
        player.setArmor(this);
        player.setHasArmor(true);
        hero.setMaxHP(hero.getMaxHP() + hp);
        hero.setDefense(hero.getDefense() + def);
        hero.setStrength(hero.getStrength() + strength);
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
        hero.setMaxHP(hero.getMaxHP() - hp);
        hero.setDefense(hero.getDefense() - def);
        hero.setStrength(hero.getStrength() - strength);
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

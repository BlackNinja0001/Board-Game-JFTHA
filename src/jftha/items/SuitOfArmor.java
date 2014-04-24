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
     * Takes in Player class as a parameter.
     * Lets current player equip this armor.
     * @param player 
     */
    @Override
    public void equipArmor(Player player) {
        Hero hero = player.getCharacter();
        player.setArmor(this);
        player.setHasArmor(true);
        hero.setDefense(hero.getDefense() + def);
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
        hero.setDefense(hero.getDefense() - def);
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

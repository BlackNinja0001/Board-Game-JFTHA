package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class SuitOfArmor extends Armor{
    private final int def = 2;
    
    public SuitOfArmor(){
        this.setRarity(RarityEnum.common);
        this.setMessage("Suit of Armor: +" + def + " Defense");
        this.setGoldCost(50);
    }

    @Override
    public void equipArmor(Player player) {
        Hero hero = player.getCharacter();
        hero.setDefense(hero.getDefense() + def);
    }

    @Override
    public void dropArmor(Player player) {
        Hero hero = player.getCharacter();
        hero.setDefense(hero.getDefense() - def);
    }

    @Override
    public void armorEffect(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

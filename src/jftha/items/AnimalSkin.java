package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class AnimalSkin extends Armor {
    private final int def = 2;
    
    public AnimalSkin() {
        this.setRarity(RarityEnum.common);
        this.setMessage("Animal Skin: +" + def + " Defense");
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

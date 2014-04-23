package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class Cloak extends Armor {
    private final int agility = 2;
    
    public Cloak() {
        this.setRarity(RarityEnum.common);
        this.setMessage("Cloak: +" + agility + " Agility");
        this.setGoldCost(50);
    }

    @Override
    public void equipArmor(Player player) {
        Hero hero = player.getCharacter();
        hero.setAgility(hero.getAgility() + agility);
    }

    @Override
    public void dropArmor(Player player) {
        Hero hero = player.getCharacter();
        hero.setAgility(hero.getAgility() - agility);
    }

    @Override
    public void armorEffect(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class Goldskin extends Armor {
    private final int strength = 10;
    private final int hp = 25;
    private final int def = 6;
    
    public Goldskin() {
        this.setRarity(RarityEnum.rare);
        this.setMessage("Goldskin: +" + hp + " HP, +" + strength + " Strength, +" + def + " Defense");
        this.setGoldCost(50);
    }

    @Override
    public void equipArmor(Player player) {
        Hero hero = player.getCharacter();
        hero.setMaxHP(hero.getMaxHP() + hp);
        hero.setDefense(hero.getDefense() + def);
        hero.setStrength(hero.getStrength() + strength);
    }

    @Override
    public void dropArmor(Player player) {
        Hero hero = player.getCharacter();
        hero.setMaxHP(hero.getMaxHP() - hp);
        hero.setDefense(hero.getDefense() - def);
        hero.setStrength(hero.getStrength() - strength);
    }

    @Override
    public void armorEffect(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void armorEffect(Player attacker, Player attacked) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

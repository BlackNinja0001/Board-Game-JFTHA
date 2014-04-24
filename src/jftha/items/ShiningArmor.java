package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class ShiningArmor extends Armor {
    private final int hp = 20;
    private final int def = 5;
    
    public ShiningArmor() {
        this.setRarity(RarityEnum.uncommon);
        this.setMessage("Shining Armor: +" + hp + " HP, " + "+" + def + " Defense");
        this.setGoldCost(50);
    }

    @Override
    public void equipArmor(Player player) {
        Hero hero = player.getCharacter();
        player.setArmor(this);
        player.setHasArmor(true);
        hero.setMaxHP(hero.getMaxHP() + hp);
        hero.setDefense(hero.getDefense() + def);
    }

    @Override
    public void dropArmor(Player player) {
        Hero hero = player.getCharacter();
        player.setArmor(null);
        player.setHasArmor(false);
        hero.setMaxHP(hero.getMaxHP() - hp);
        hero.setDefense(hero.getDefense() - def);
    }

    @Override
    public void armorEffect(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

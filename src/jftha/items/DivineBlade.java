package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class DivineBlade extends Weapon {
    private final int strength = 4;
    
    public DivineBlade() {
        this.setRarity(RarityEnum.common);
        this.setMessage("Divine Blade: +" + strength + " Strength");
        this.setGoldCost(50);
    }

    @Override
    public void equipWeap(Player player) {
        Hero hero = player.getCharacter();
        hero.setStrength(hero.getStrength() + strength);
    }

    @Override
    public void dropWeap(Player player) {
        Hero hero = player.getCharacter();
        hero.setStrength(hero.getStrength() - strength);
    }

    @Override
    public void weapEffect(Player player) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void weapEffect(Player attacker, Player attacked) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class Dagger extends Weapon {
    private final int strength = 2;
    private final int agility = 1;
    
    public Dagger() {
        this.setRarity(RarityEnum.common);
        this.setMessage("Dagger: +" + strength + " Strength, " + "+" + agility + " Agility");
        this.setGoldCost(50);
    }

    @Override
    public void equipWeap(Player player) {
        Hero hero = player.getCharacter();
        hero.setStrength(hero.getStrength() + strength);
        hero.setAgility(hero.getAgility() + agility);
    }

    @Override
    public void dropWeap(Player player) {
        Hero hero = player.getCharacter();
        hero.setStrength(hero.getStrength() - strength);
        hero.setAgility(hero.getAgility() - agility);
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

package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class Elixir extends Item{
    public Elixir(){
        this.setRarity(RarityEnum.rare);
        this.setMessage("Elixir: fully Recover HP/MP");
        this.setGoldCost(50);
    }

    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void triggerEffect(Player affected) {
        Hero hero = affected.getCharacter();
        hero.setCurrentHP(hero.getMaxHP());
        hero.setCurrentMP(hero.getMaxMP());
    }

    @Override
    public void triggerEffect(Player affected1, Player affected2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void triggerEffect(Player affected1, Player affected2, Player affected3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

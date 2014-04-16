package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class HiPotion extends Item{
    private final int heal = 50;
    
    public HiPotion(){
        this.setRarity(RarityEnum.uncommon);
        this.setMessage("Hi-Potion: Recover 50HP");
        this.setGoldCost(50);
    }

    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void triggerEffect(Player affected) {
        Hero hero = affected.getCharacter();
        hero.setCurrentHP(hero.getCurrentHP() + heal);
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

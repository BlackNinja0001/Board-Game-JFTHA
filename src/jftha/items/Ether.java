package jftha.items;

import jftha.heroes.Hero;
import jftha.main.Player;

public class Ether extends Item{
    private final int recoverMP = 10;
    
    public Ether(){
        this.setRarity(RarityEnum.common);
        this.setMessage("Ether: Recover 10MP");
    }

    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void triggerEffect(Player affected) {
        Hero hero = affected.getCharacter();
        hero.setCurrentMP(hero.getCurrentMP() + recoverMP);
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

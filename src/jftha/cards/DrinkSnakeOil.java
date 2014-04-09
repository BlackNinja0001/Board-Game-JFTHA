package jftha.cards;

import jftha.heroes.Hero;
import jftha.main.Player;
import jftha.statchanges.Strength_TSC;

public class DrinkSnakeOil extends Card{

    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void triggerEffect(Player affected) {
        Hero hero = affected.getCharacter();
        hero.addTSC(new Strength_TSC(3, 2)); //+2 STR for 3 turns
        hero.setGold(hero.getGold() - 500); //lose 500 gold
        this.setMessage("The local snake oil salesman sold you an elixer for 500 gold. +2 Strength for 3 turn. Spend 500 gold.");
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

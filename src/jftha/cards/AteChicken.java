package jftha.cards;

import jftha.heroes.Hero;
import jftha.main.Player;
import jftha.statchanges.CurHP_SCPT;

public class AteChicken extends Card{
    
    /**NO EFFECT.
     * 
     */
    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Takes in Player Class as a parameter.
     * Heals current player 10HP and loses 5 HP each turn for 3 turns.
     * @param affected 
     */
    @Override
    public void triggerEffect(Player affected) {
        Hero hero = affected.getCharacter();
        hero.setCurrentHP(hero.getCurrentHP() + 10);
        hero.addTSC(new CurHP_SCPT(3, -5)); //lose 5 HP per turn for 3 turns
        this.setMessage("You ate a chicken from a dungeon wall. Gain 10 HP. Lose 5 HP per turn for 3 turns from indigestion.");
    }

    /**NO EFFECT.
     * 
     */
    @Override
    public void triggerEffect(Player affected1, Player affected2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**NO EFFECT.
     * 
     */
    @Override
    public void triggerEffect(Player affected1, Player affected2, Player affected3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

package jftha.cards;

import jftha.heroes.Hero;
import jftha.main.Player;
import jftha.statchanges.CurHP_SCPT;

public class FountainOfYouth extends Card{

    /**
     * Takes in Player Class as a parameter.
     * Permanently increase current player's strength by 2. Loses 5HP per turn for 5 turns
     * @param affected 
     */
    @Override
    public void triggerEffect(Player affected) {
        Hero hero = affected.getCharacter();
        hero.setStrength(hero.getStrength() + 2); //permanent incerease to strength
        hero.addTSC(new CurHP_SCPT(5, -5)); //Lose 5 HP per turn for 5 turns
        this.setMessage("Good news: you've found the fountain of youth and have become much stronger. Bad news: You're stronger because the water contained steroids. "
                + "+2 Strength. -5 HP per turn for 5 turns from pain down under.");
    }

    /**NO EFFECT.
     * 
     */
    @Override
    public void triggerEffect(Player affected1, Player affected2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

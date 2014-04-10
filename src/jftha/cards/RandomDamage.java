package jftha.cards;

import java.util.*;

import jftha.heroes.*;
import jftha.main.Player;

public class RandomDamage extends Card{

    /**NO EFFECT.
     * 
     */
    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void triggerEffect(Player affected) {
        Hero hero = affected.getCharacter();
        Random rand = new Random(System.currentTimeMillis());
        //Will change this when we figure out the balance of characters and game play
        //Damage will be calculated as TRUE damage. Defense/Resistance should not matter
        int rd = rand.nextInt(50);
        //Checks if current play isGhost()
        //Damage will reduce current HP if isGhost() is false
            //Becomes a ghost if currentHP <= 0
        //Damage will reduce current MP if isGhost() is true
            //Gets eliminated from game if currentMP <= 0
        if(hero.isGhost() == false){
            this.setMessage("The local drunkard thought you were a pink elephant and clocked you in the head with his mug 20 times. Lose " + rd + " HP.");
            hero.setCurrentHP(hero.getCurrentHP() - rd);
            if(hero.getCurrentHP() <= 0){
                hero.makeGhost();
            }
        }else if(hero.isGhost() == true){
            this.setMessage(". Lose " + rd + " MP.");
            hero.setCurrentMP(hero.getCurrentMP() - rd);
            if(hero.getCurrentMP() <=0){
                hero.setEliminated(true);
            }
        }
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

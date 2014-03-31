package jftha.effects;

import java.util.*;

import jftha.heroes.*;

public class RandomDamage extends Effect{
    
    RandomDamage(Hero hero){
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
            hero.setCurrentHP(hero.getCurrentHP() - rd);
            if(hero.getCurrentHP() <= 0){
                hero.makeGhost();
            }
        }else if(hero.isGhost() == true){
            hero.setCurrentMP(hero.getCurrentMP() - rd);
            if(hero.getCurrentMP() <=0){
                hero.setEliminated(true);
            }
        }
    }
}

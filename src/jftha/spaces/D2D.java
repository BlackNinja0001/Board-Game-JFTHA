package jftha.spaces;

import java.util.*;
import jftha.heroes.*;
import jftha.items.*;

public class D2D extends Space{
    
    public D2D(){
        this.setActivationType('1');
    }
    
    public void duel2death(Hero attacker, Hero beingAttacked){
        while(attacker.getCurrentHP() <= 0 || beingAttacked.getCurrentHP() <= 0){
            attacker.attackEnemy(beingAttacked);
            beingAttacked.attackEnemy(attacker);
            if(attacker.getCurrentHP() <= 0){
                attacker.makeGhost();
            }else if(beingAttacked.getCurrentHP() <= 0){
                beingAttacked.makeGhost();
            }
        }
    }
}

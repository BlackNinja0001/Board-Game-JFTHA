package jftha.spaces;

import java.util.*;
import jftha.heroes.*;
import jftha.items.*;

public class D2D extends Space{
    
    public D2D(){
        this.setActivationType('1');
        this.setSpaceType(SpaceEnum.D2D);
    }
    
    @Override
    public void triggerEffect() {
        Hero attacker = this.getActivator();
        // Select opponent
        System.out.println("Select your victim: ");
        Scanner scan = new Scanner(System.in);
        String opponent = scan.next();
        
        
        Hero beingAttacked = null;
        
        duel2death(attacker, beingAttacked);
    }
    
    private void duel2death(Hero attacker, Hero beingAttacked){
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

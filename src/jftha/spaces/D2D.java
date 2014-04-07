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
    public void triggerEffect(Hero beingAttacked) {
        Hero attacker = this.getActivator();
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

    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

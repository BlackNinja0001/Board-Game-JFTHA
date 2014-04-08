package jftha.spaces;

import java.io.PrintStream;
import jftha.heroes.*;

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
        int num = 1;
        int heroHP = attacker.getCurrentHP(), enemyHP = beingAttacked.getCurrentHP();
        while(heroHP >= 0 && enemyHP >= 0){
            System.out.println("Run # " + num + ": Hero HP: " + heroHP + ", Enemy HP: " + enemyHP);
            attacker.attackEnemy(beingAttacked);
            beingAttacked.attackEnemy(attacker);
            heroHP = attacker.getCurrentHP();
            enemyHP = beingAttacked.getCurrentHP();
            /*if(attacker.getCurrentHP() <= 0){
                attacker.makeGhost();
            }else if(beingAttacked.getCurrentHP() <= 0){
                beingAttacked.makeGhost();
            }*/
            num++;
        }
    }

    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

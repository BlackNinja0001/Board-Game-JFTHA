package jftha.spaces;

import jftha.heroes.*;
import jftha.spells.*;

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
        int attackerHP = attacker.getCurrentHP(), beingAttackedHP = beingAttacked.getCurrentHP();
        if(beingAttacked instanceof Mage){
            Spell fireball = new Fireball();
            while(attackerHP > 0 && beingAttackedHP > 0){
                attacker.attackEnemy(beingAttacked);
                beingAttacked.castSpell(fireball, attacker);
                attackerHP = attacker.getCurrentHP();
                beingAttackedHP = beingAttacked.getCurrentHP();
            }
        }else{
            while(attackerHP > 0 && beingAttackedHP > 0){
                beingAttacked.attackEnemy(attacker);
                attackerHP = attacker.getCurrentHP();
                beingAttackedHP = beingAttacked.getCurrentHP();
            }
        }
    }

    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

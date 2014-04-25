package jftha.spaces;

import jftha.heroes.*;
import jftha.main.Player;
import jftha.spells.*;

public class D2D extends Space{
    
    /**
     * Constructor
     */
    public D2D(){
        this.setActivationType('L');
        this.setSpaceType(SpaceEnum.D2D);
    }
    
    /**
     * Takes in Player Class as a parameter.
     * Current player chooses another player to enter Duel to the Death.
     * If enemy player is a Mage, he/she uses spells to attack instead.
     * @param beingAttacked 
     */
    @Override
    public void triggerEffect(Player beingAttacked) {
        Player p = getActivator();
        Hero attacker = p.getCharacter();
        duel2death(attacker, beingAttacked.getCharacter());
    }
    
    private void duel2death(Hero attacker, Hero beingAttacked){
        int attackerHP = attacker.getCurrentHP(), beingAttackedHP = beingAttacked.getCurrentHP();
        int num = 1;
        if(beingAttacked instanceof Mage){
            Spell fireball = new Fireball();
            while(attackerHP > 0 && beingAttackedHP > 0){
                System.out.println("Turn #" + num + " Attacker hp: " + attackerHP + ", Enemy HP: " + beingAttackedHP);
            attacker.attackEnemy(beingAttacked);
                beingAttacked.castSpell(fireball, attacker);
                attackerHP = attacker.getCurrentHP();
                beingAttackedHP = beingAttacked.getCurrentHP();
                num++;
            }
        }else{
            while(attackerHP > 0 && beingAttackedHP > 0){
                beingAttacked.attackEnemy(attacker);
                attackerHP = attacker.getCurrentHP();
                beingAttackedHP = beingAttacked.getCurrentHP();
            }
        }
    }

    /**
     * No Effect
     */
    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

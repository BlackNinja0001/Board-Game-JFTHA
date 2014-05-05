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
    
    public StringBuilder triggerEffectGUI(Player beingAttacked) {
        Player p = getActivator();
        Hero attacker = p.getCharacter();
        StringBuilder sb = duel2death(attacker, beingAttacked.getCharacter());
        return sb;
    }
    
    private StringBuilder duel2death(Hero attacker, Hero beingAttacked){
        StringBuilder sb = new StringBuilder();
        int attackerHP = attacker.getCurrentHP(), beingAttackedHP = beingAttacked.getCurrentHP();
        int num = 1;
        if(beingAttacked instanceof Mage){
            AttackSpell fireball = new Fireball();
            while(attackerHP > 0 && beingAttackedHP > 0){
                sb.append("Turn #").append(num).append(" Attacker hp: ")
                        .append(attackerHP).append(", Enemy HP: ")
                        .append(beingAttackedHP).append("\n");
                attacker.attackEnemy(beingAttacked);
                fireball.castSpell(beingAttacked, attacker);
                attackerHP = attacker.getCurrentHP();
                beingAttackedHP = beingAttacked.getCurrentHP();
                num++;
            }
        } else {
            while(attackerHP > 0 && beingAttackedHP > 0){
                sb.append("Turn #").append(num).append(" Attacker hp: ")
                        .append(attackerHP).append(", Enemy HP: ")
                        .append(beingAttackedHP).append("\n");
                beingAttacked.attackEnemy(attacker);
                attackerHP = attacker.getCurrentHP();
                beingAttackedHP = beingAttacked.getCurrentHP();
                num++;
            }
        }
        return sb;
    }

    /**
     * No Effect
     */
    @Override
    public void triggerEffect() {}
}

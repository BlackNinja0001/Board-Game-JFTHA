package jftha.spaces;

import jftha.heroes.Hero;
import jftha.main.Player;

public class Monster extends RegularSpace{
    
    Hero monster;
    
    /**
     * Constructor
     */
    public Monster(){
        this.setActivationType('L');
        this.setSpaceType(SpaceEnum.Monster);
        monster = new jftha.heroes.Monster();
        
    }

    /**
     * Takes in two Hero Class as parameters.
     * Current player enters Duel to Death with a monster.
     * Earn 10 Gold when monster is defeated.
     * @param attacker
     * @param beingAttacked 
     */
    private StringBuilder combat(Hero attacker, Hero beingAttacked){
        StringBuilder sb = new StringBuilder();
        int attackerHP = attacker.getCurrentHP(), beingAttackedHP = beingAttacked.getCurrentHP();
        int num = 1;
        while(attacker.getCurrentHP() > 0 && beingAttacked.getCurrentHP() > 0){
            sb.append("Turn #").append(num).append(" Hero HP: ")
                        .append(attackerHP).append(", Enemy HP: ")
                        .append(beingAttackedHP).append("\n");
            attacker.attackEnemy(beingAttacked);
            beingAttacked.attackEnemy(attacker);
            if(beingAttacked.getCurrentHP() <= 0){
                //Attacker earns 10 gold for defeating monster
                attacker.setGold(attacker.getGold() + 10);
            }
        }
        
        //Monster's HP gets set back to max
        beingAttacked.setCurrentHP(beingAttacked.getMaxHP());
        return sb;
    }
    
    /**
     * Current player enters Duel to Death with a monster.
     */
    @Override
    public void triggerEffect() {
        Player p = getActivator();
        Hero attacker = p.getCharacter();
        combat(attacker, this.monster);
    }
    
    /**
     * Current player enters Duel to Death with a monster.
     */
    public StringBuilder triggerEffectGUI() {
        Player p = getActivator();
        Hero attacker = p.getCharacter();
        StringBuilder sb = combat(attacker, this.monster);
        return sb;
    }
}

package jftha.spaces;

import jftha.heroes.Hero;
import jftha.main.Player;

public class Monster extends Space{
    
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
     * Earn 10Gold when monster is defeated.
     * @param attacker
     * @param beingAttacked 
     */
    private void combat(Hero attacker, Hero beingAttacked){
        while(attacker.getCurrentHP() > 0 && beingAttacked.getCurrentHP() > 0){
            attacker.attackEnemy(beingAttacked);
            beingAttacked.attackEnemy(attacker);
            if(beingAttacked.getCurrentHP() <= 0){
                //Attacker earns 10 gold for defeating monster
                attacker.setGold(attacker.getGold() + 10);
            }
        }
        
        //Monster's HP gets set back to max
        beingAttacked.setCurrentHP(beingAttacked.getMaxHP());
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
     * No Effect
     * @param affected 
     */
    @Override
    public void triggerEffect(Player affected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

package jftha.spaces;

import jftha.heroes.Hero;

public class Monster extends Space{
    
    Hero monster;
    
    public Monster(){
        this.setActivationType('L');
        this.setSpaceType(SpaceEnum.Monster);
        monster = new jftha.heroes.Monster();
        
    }

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
    
    @Override
    public void triggerEffect() {
        Hero attacker = this.getActivator();
        combat(attacker, this.monster);
    }

    @Override
    public void triggerEffect(Hero affected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

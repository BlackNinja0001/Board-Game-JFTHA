package jftha.heroes;

import java.util.Random;
import jftha.items.AnimalSkin;
import jftha.items.Ax;

public class Barbarian extends Hero{
    //Constructor
    public Barbarian(){
        this.setStrength(super.getStrength() + 2);
        this.setMagic(super.getMagic() - 2);
        this.addItem(new AnimalSkin());
        this.addItem(new Ax());
    }
    
    @Override
    public void attackEnemy(Hero enemy) {
        int strength = this.getStrength();
        Random rand = new Random();
        if(getWasAttacked()) {
            if((rand.nextInt(5) + 1) == 1)
                strength *= 2;
        }
        if (enemy.getWasAttacked() == false) { // **?? Can only get attacked once per turn?
            if (enemy.isGhost() == false) { //cannot attack ghost unless under certain circumstances

                int randomDamage = rand.nextInt(3);
                double damage = (strength - enemy.getDefense()) - (0.2 * (this.getLuck() - enemy.getLuck())) + randomDamage;
                if (damage < 0) { //attacker sucks
                    damage = 0;
                }
                int intDamage = (int) Math.round(damage);
                enemy.setCurrentHP(enemy.getCurrentHP()- intDamage);
                if (enemy.getCurrentHP() <= 0){
                    enemy.makeGhost();
                }
            } else { //attacking ghost
                //handle spiritual items
                //if no spiritual items, the Attack phase is skipped
            }
        }
        enemy.setWasAttacked(true);
    }
}
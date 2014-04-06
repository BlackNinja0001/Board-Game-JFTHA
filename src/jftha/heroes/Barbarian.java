package jftha.heroes;

import java.util.Random;
import jftha.items.AnimalSkin;
import jftha.items.Ax;
import jftha.items.Equippable;
import jftha.items.Item;

public class Barbarian extends Hero {

    //Constructor
    public Barbarian() {
        this.setStrength(super.getStrength() + 2);
        this.setMagic(super.getMagic() - 2);
        this.addItem(new AnimalSkin());
        this.addItem(new Ax());
        this.setClassName("Barbarian");
    }

    @Override
    public void attackEnemy(Hero enemy) {
        int strength = this.getStrength();
        Random rand = new Random();
        if (getWasAttacked()) { //Barbarian's special
            if ((rand.nextInt(5) + 1) == 1) {
                strength *= 2;
            }
        }
        int randomDamage = rand.nextInt(3);
        double damage = (strength - enemy.getDefense()) - (0.2 * (this.getLuck() - enemy.getLuck())) + randomDamage;
        if (damage < 0) { //attacker sucks
            damage = 0;
        }
        int intDamage = (int) Math.round(damage);
        if (enemy.getWasAttacked() == false) { // **?? Can only get attacked once per turn?
            if (enemy.isGhost() == false) { //cannot attack ghost unless under certain circumstances
                enemy.setCurrentHP(enemy.getCurrentHP() - intDamage);
                if (enemy.getCurrentHP() <= 0) {
                    enemy.makeGhost();
                }
            } else { //attacking ghost
                //handle spiritual items
                if (this.getItems().isEmpty()) {
                    for (Item i : this.getItems()) {
                        if (i instanceof Equippable) {
                            Equippable eq = (Equippable) i; //cannot use isEquippedOn() right away, must downcast to child class
                            if (eq.isEquippedOn(this) && (eq.getSpiritual())) {
                                enemy.setCurrentMP(enemy.getCurrentMP() - intDamage);
                                if (enemy.getCurrentMP() <= 0) {
                                    enemy.setEliminated(true);
                                }
                            }
                        }
                    }
                }
                //if no spiritual items, the Attack phase is skipped
            }
        }
        enemy.setWasAttacked(true);
    }
}

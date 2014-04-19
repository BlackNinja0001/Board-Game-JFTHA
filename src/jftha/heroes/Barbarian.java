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
            int tempStrength = this.getStrength();
            if ((rand.nextInt(5) + 1) == 1) {
                tempStrength *= 2;
                this.setStrength(tempStrength);
            }
        }
        super.attackEnemy(enemy);
        this.setStrength(strength);
        
    }
}

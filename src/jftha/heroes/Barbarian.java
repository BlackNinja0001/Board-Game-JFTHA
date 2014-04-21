package jftha.heroes;

import java.util.Random;
import jftha.items.AnimalSkin;
import jftha.items.Ax;
import jftha.items.Equippable;
import jftha.items.Item;
import jftha.statchanges.Strength_TSC;

public class Barbarian extends Hero {

    //Constructor
    /**
     * 
     */
    public Barbarian() {
        this.setStrength(super.getStrength() + 2);
        this.setMagic(super.getMagic() - 2);
        this.addItem(new AnimalSkin());
        this.addItem(new Ax());
        this.setClassName("Barbarian");
    }
    
    /**
     * 
     * @param enemy 
     */
    @Override
    public void attackEnemy(Hero enemy) {
        Random rand = new Random();
        if(getWasAttacked()) { // Barbarian's Special
            if((rand.nextInt(5) + 1) == 1) {
                this.addTSC(new Strength_TSC(1, this.getStrength()));
            }
        }
    }
}

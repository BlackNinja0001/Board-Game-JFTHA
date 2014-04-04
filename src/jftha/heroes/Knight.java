package jftha.heroes;

import jftha.items.SuitOfArmor;
import jftha.items.IronSword;

public abstract class Knight extends Hero{
    
    //Constructor
    public Knight(){
        this.setDefense(super.getDefense() + 2);
        this.setAgility(super.getAgility() - 2);
        this.addItem(new SuitOfArmor());
        this.addItem(new IronSword());
        this.setClassName("Knight");
    }
}

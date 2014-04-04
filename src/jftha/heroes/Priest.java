package jftha.heroes;

import jftha.items.Chasuble;
import jftha.items.Bible;
import jftha.spells.Heal;

public abstract class Priest extends Hero{
    
    //Constructor
    public Priest(){
        this.setMaxMP(super.getMaxMP() + 10);
        this.setMaxHP(super.getMaxHP() - 10);
        this.addItem(new Chasuble());
        this.addItem(new Bible());
        this.addSpell(new Heal());
        this.setClassName("Priest");
    }
    
}

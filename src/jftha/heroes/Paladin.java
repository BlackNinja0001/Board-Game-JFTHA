package jftha.heroes;

import jftha.items.ShiningArmor;
import jftha.items.DivineBlade;
import jftha.spells.Heal;

public abstract class Paladin extends Hero{
   
    //Constructor
    public Paladin(){
        this.setStrength(super.getStrength() + 5);
        this.setMagic(super.getMagic() + 5);
        this.setDefense(super.getDefense() + 5);
        this.setLuck(super.getLuck() +5);
        this.setMaxHP(super.getMaxHP() + 20);
        this.setMaxMP(super.getMaxMP() + 10);
        this.setSpellSlots(super.getSpellSlots() + 1);
        this.addItem(new ShiningArmor());
        this.addItem(new DivineBlade());
        this.addSpell(new Heal());
        this.setClassName("Paladin");
    }
    
}
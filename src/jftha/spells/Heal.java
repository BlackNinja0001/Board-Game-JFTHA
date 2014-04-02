package jftha.spells;

public class Heal extends Spell{
    
    // Constructor
    public Heal() {
        this.setmpCost(super.getmpCost()); //**Placeholder until real value is set**
        
        //This is heal
        this.setMinDamage(5);
        this.setMaxDamage(10);
    }
}

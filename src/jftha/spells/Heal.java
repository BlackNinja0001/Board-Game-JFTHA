package jftha.spells;

public class Heal extends Spell{
    
    /**
     * Constructor
     */
    public Heal() {
        this.setGoldCost(10);
        this.setmpCost(super.getmpCost()); //**Placeholder until real value is set**
        
        //This is heal
        this.setMinDamage(5);
        this.setMaxDamage(10);
        
        this.setMessage("Heal. Heals current player between 5-10 HP. Cost " + this.getmpCost() + "MP");
    }
}

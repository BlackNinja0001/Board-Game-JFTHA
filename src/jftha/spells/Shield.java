package jftha.spells;

public class Shield extends Spell {
    
    /**
     * Constructor
     */
    public Shield(){
        this.setmpCost(5);
        this.setMaxCooldown(5);
        this.setMaxDuration(2);
        
        this.setMinDamage(1);
        this.setMaxDamage(3);
    }
}

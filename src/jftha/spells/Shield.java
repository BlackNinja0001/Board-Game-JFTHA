package jftha.spells;

public class Shield extends Spell {
    
    /**
     * Constructor
     */
    public Shield(){
        this.setGoldCost(10);
        this.setmpCost(5);
        this.setMaxCooldown(5);
        this.setMaxDuration(2);
        
        this.setMinDamage(1);
        this.setMaxDamage(3);
        
        this.setMessage("Shield. Temporarily increase defense(1-3) for 2 turns. Cost " + this.getmpCost() + "MP");
    }
}

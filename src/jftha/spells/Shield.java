package jftha.spells;

public class Shield extends Spell {
    
    public Shield(){
        this.setmpCost(5);
        this.setCooldown(5);
        this.setDuration(2);
        
        this.setMinDamage(1);
        this.setMaxDamage(3);
    }
}

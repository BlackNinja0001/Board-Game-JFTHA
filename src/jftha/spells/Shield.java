package jftha.spells;

import jftha.heroes.*;
import jftha.statchanges.Defense_TSC;

public class Shield extends SelfSpell {
    
    /**
     * Constructor
     */
    public Shield(){
        this.setGoldCost(10);
        this.setmpCost(5);
        this.setMaxCooldown(5);
        this.setMaxDuration(2);
        
        this.setMinHPChange(1);
        this.setMaxHPChange(3);
        
        this.setMessage("Shield. Temporarily increase defense(1-3) for 2 turns. Cost " + this.getmpCost() + " MP");
    }

    @Override
    public void castSpell(Hero caster) {
        //Damage is the heal amount
        if (getCurrentCD() > 0) {
            int spellEffect = getHpChange();
            double actualEffect = ((caster.getMagic() * .5) + spellEffect + (caster.getLuck() * .2));
            int finalEffect = (int) Math.round(actualEffect);
            if(finalEffect < this.getMinHPChange()) {
                finalEffect = this.getMinHPChange();
            }
            if(finalEffect > this.getMaxHPChange()) {
                finalEffect = this.getMaxHPChange();
            }
            
            if(caster instanceof Mage) {
                caster.setCurrentMP(caster.getCurrentMP() - (int)(getmpCost() * Mage.multiplier));
            } else {
                caster.setCurrentMP(caster.getCurrentMP() - getmpCost());
            }
            caster.addTSC(new Defense_TSC(getMaxDuration(), finalEffect));
        }
    }
}

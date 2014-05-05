 package jftha.spells;

import jftha.heroes.*;

public class Heal extends SelfSpell{
    
    /**
     * Constructor
     */
    public Heal() {
        this.setGoldCost(10);
        this.setmpCost(5); //**Placeholder until real value is set**
        
        //This is heal
        this.setMinHPChange(5);
        this.setMaxHPChange(10);
        
        this.setMessage("Heal. Heals current player between 5-10 HP. Cost " + this.getmpCost() + " MP");
    }

    @Override
    public void castSpell(Hero caster) {
        setCurrentCD(this.getMaxCooldown());
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

        caster.setCurrentHP(caster.getCurrentHP() + finalEffect);
    }
    
    
}

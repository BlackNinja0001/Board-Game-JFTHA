package jftha.spells;

import jftha.heroes.Hero;
import jftha.heroes.Mage;
import jftha.statchanges.CurHP_SCPT;
import jftha.statchanges.Defense_TSC;

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

    @Override
    public void castSpell(Hero caster) {
        //Damage is the heal amount
        if (getCurrentCD() > 0) {
            setCurrentCD(this.getMaxCooldown());
            int spellEffect = getDamage();
            double actualEffect = ((caster.getMagic() * .5) + spellEffect + (caster.getLuck() * .2));
            int finalEffect = (int) Math.round(actualEffect);
            if(finalEffect <=0) {
                finalEffect = 1;
            }
            
            if(caster instanceof Mage) {
                caster.setCurrentMP(caster.getCurrentMP() - (int)(getmpCost() * Mage.multiplier));
            } else {
                caster.setCurrentMP(caster.getCurrentMP() - getmpCost());
            }
            
            caster.addTSC(new Defense_TSC(1, finalEffect));
        } else  {
            setCurrentCD(this.getCurrentCD() - 1);
        }
    }
    
    @Override
    public void castSpell(Hero caster, Hero victim) {}
}

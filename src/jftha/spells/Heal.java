package jftha.spells;

import jftha.heroes.Hero;
import jftha.heroes.Mage;
import jftha.statchanges.CurHP_SCPT;

public class Heal extends Spell{
    
    /**
     * Constructor
     */
    public Heal() {
        this.setGoldCost(10);
        this.setmpCost(5); //**Placeholder until real value is set**
        
        //This is heal
        this.setMinDamage(5);
        this.setMaxDamage(10);
        
        this.setMessage("Heal. Heals current player between 5-10 HP. Cost " + this.getmpCost() + "MP");
    }

    @Override
    public void castSpell(Hero caster) {
        //Damage is the heal amount
        if (getCurrentCD() > 0) {
            setCurrentCD(this.getMaxCooldown());
            int spellEffect = getHpChange();
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
            
            caster.addTSC(new CurHP_SCPT(1, finalEffect));
        } else  {
            setCurrentCD(this.getCurrentCD() - 1);
        }
    }

    @Override
    public void castSpell(Hero caster, Hero victim) {}
    
    
}

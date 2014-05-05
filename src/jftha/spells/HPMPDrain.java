package jftha.spells;

import java.util.Random;
import jftha.heroes.Hero;
import jftha.heroes.Mage;
import jftha.statchanges.CurHP_SCPT;
import jftha.statchanges.CurMP_SCPT;

public class HPMPDrain extends AttackSpell{

    /**
     * Constructor
     */
    public HPMPDrain() {
        this.setGoldCost(10);
        this.setMaxDuration(5);
        this.setMaxCooldown(6);
        this.setmpCost(15);
        this.setMessage("HP/MP Drain. Absorb HP/MP from enemy player for 5 turns. Cost " + this.getmpCost() + " MP");
    }
    
    //Saps 1-5 HP/MP per turn (saps when whomever the spell was cast on begins turn)

    @Override
    public void castSpell(Hero caster, Hero enemy) {
        //Damage is the buff amount
        if (getCurrentCD() > 0) {
            int spellEffect = getHpChange();
            double actualEffect = ((caster.getMagic() * .5) + spellEffect + (caster.getLuck() * .2))
                - ((enemy.getMagic() * .5) + (enemy.getDefense() * .5) + (enemy.getLuck() * .2));
            
            int finalEffect = (int) Math.round(actualEffect);
            
            if(finalEffect <= 0) {
                finalEffect = 1;
            }
            
            if(caster instanceof Mage) {
                caster.setCurrentMP(caster.getCurrentMP() - (int)(getmpCost() * Mage.multiplier));
            } else {
                caster.setCurrentMP(caster.getCurrentMP() - getmpCost());
            }
            Random rand = new Random();
            int luck = rand.nextInt(100) + caster.getLuck() - enemy.getLuck();
            if(luck > 75) { // drain both
                caster.addTSC(new CurHP_SCPT(getMaxDuration(),finalEffect));
                enemy.addTSC(new CurHP_SCPT(getMaxDuration(),(-1) * finalEffect));
                caster.addTSC(new CurMP_SCPT(getMaxDuration(),finalEffect));
                enemy.addTSC(new CurMP_SCPT(getMaxDuration(),(-1) * finalEffect));
            } else if(rand.nextBoolean()) { // drain mp
                caster.addTSC(new CurMP_SCPT(getMaxDuration(),finalEffect));
                enemy.addTSC(new CurMP_SCPT(getMaxDuration(),(-1) * finalEffect));
            } else { // drain hp
                caster.addTSC(new CurHP_SCPT(getMaxDuration(),finalEffect));
                enemy.addTSC(new CurHP_SCPT(getMaxDuration(),(-1) * finalEffect));
            }
        }
    }
}

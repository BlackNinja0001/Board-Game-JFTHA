package jftha.spells;

import jftha.heroes.*;

public class Fireball extends AttackSpell {
    
    /**
     * Constructor
     */
    public Fireball() {
        this.setGoldCost(10);
        this.setmpCost(5);
        this.setMinHPChange(1);
        this.setMaxHPChange(5);
        this.setMessage("Fireball. Random magic damage between 1-5 to enemy player. Cost " + this.getmpCost() + " MP");
    }
    
    /**
     * Allows a character to cast a damage inflicting spell at another player.
     *
     * @param caster The caster of the spell
     * @param enemy The victim of the spell
     */
    @Override
    public void castSpell(Hero caster, Hero enemy) {
        int spellDmg = getHpChange();
        double actualDmg = ((caster.getMagic() * .5) + spellDmg + (caster.getLuck() * .2))
                - ((enemy.getMagic() * .5) + (enemy.getDefense() * .5) + (enemy.getLuck() * .2));
        int finalDmg = (int) Math.round(actualDmg);
        if(finalDmg < this.getMinHPChange()) {
            finalDmg = this.getMinHPChange();
        }
        if(finalDmg > this.getMaxHPChange()) {
            finalDmg = this.getMaxHPChange();
        }
        
        if(caster instanceof Mage) {
                caster.setCurrentMP(caster.getCurrentMP() - (int)(getmpCost() * Mage.multiplier));
            } else {
                caster.setCurrentMP(caster.getCurrentMP() - getmpCost());
            }
        
        enemy.setCurrentHP(enemy.getCurrentHP() - finalDmg);
    }
}

package jftha.spells;

import jftha.heroes.Hero;
import jftha.heroes.Mage;

public class Fireball extends Spell {
    
    /**
     * Constructor
     */
    public Fireball() {
        this.setGoldCost(10);
        this.setmpCost(5);
        this.setMinDamage(1);
        this.setMaxDamage(5);
        this.setMessage("Fireball. Random magic damage between 1-5 to enemy player. Cost " + this.getmpCost() + "MP");
    }
    
    @Override
    public void castSpell(Hero caster) {}
    
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
        caster.setCurrentMP(caster.getCurrentMP() - getmpCost());
        if (finalDmg <= 0) {
            finalDmg = 1;
        }
        
        if(caster instanceof Mage) {
                caster.setCurrentMP(caster.getCurrentMP() - (int)(getmpCost() * Mage.multiplier));
            } else {
                caster.setCurrentMP(caster.getCurrentMP() - getmpCost());
            }
        
        enemy.setCurrentHP(enemy.getCurrentHP() - finalDmg);
    }
}

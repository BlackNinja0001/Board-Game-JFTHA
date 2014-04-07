package jftha.heroes;

import jftha.items.MageRobe;
import jftha.items.SpellBook;
import jftha.spells.*;

public class Mage extends Hero{
    
    Spell spells = new Spell();
    final double multiplier = 0.9;
    
    //Constructor
    public Mage(){
        this.setMagic(super.getMagic() + 2);
        this.setStrength(super.getStrength() - 2);
        this.setDefense(super.getDefense() - 3);
        this.setSpellSlots(super.getSpellSlots() + 2);
        this.addItem(new MageRobe());
        this.addItem(new SpellBook());
        this.addSpell(new Fireball());
        this.addSpell(new Shield());
        this.setClassName("Mage");
    }
    /**Mage's version of spell casting. The spell costs 10% less magic.
     * 
     * @param spell The spell to be cast.
     */
    @Override
    public void castSpell(Spell spell , Hero enemy){
        int f = this.getCurrentMP(); 
        f -= (spell.getmpCost() * multiplier);
        super.castSpell(spell, enemy);
        this.setCurrentMP(f);
    }
    // Add for all versions of cast spell
    
        //self heal spells
    @Override
    public void castHealSpell(Spell spell) {
        if(spell.getCurrentCD() > 0){
            int f = this.getCurrentMP();
            f -= (spell.getmpCost() * multiplier);
            super.castHealSpell(spell);
            this.setCurrentMP(f);
        }
    }

    //Self buff spells
    @Override
    public void castBuffSpell(Spell spell) {
        if(spell.getCurrentCD() > 0){
            int f = this.getCurrentMP();
            f -= (spell.getmpCost() * multiplier);
            super.castBuffSpell(spell);
            this.setCurrentMP(f);
        }
    }
}

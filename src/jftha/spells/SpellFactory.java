package jftha.spells;

import java.util.Random;

public class SpellFactory {
    public Spell buildSpell() {
        Spell sp = null;
        SpellList sl = new SpellList();
        Random rand = new Random(System.currentTimeMillis());
        int i = rand.nextInt(sl.getSpellSize());
        Class clazz = sl.getSpellClass(i);
        try {
            sp = (Spell)clazz.newInstance();
        } catch(IllegalAccessException | InstantiationException ex) {
        }
        
        return sp;
    }

    public Spell buildSpell(SpellEnum spellEnum) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

package jftha.spells;

import jftha.heroes.Hero;

public abstract class AttackSpell extends Spell {
    public abstract void castSpell(Hero caster, Hero victim);
}

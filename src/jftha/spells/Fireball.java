package jftha.spells;

public class Fireball extends Spell {
    public Fireball() {
        this.setGoldCost(10);
        this.setMinDamage(1);
        this.setMaxDamage(5);
    }
    
    /*
    public int fireball(Hero caster){
        double damage;
        damage = caster.getMagic() + (caster.getLuck() * .2);
        int intdamage = (int)Math.round(damage);
        return intdamage;
    }
    * 
    */
}

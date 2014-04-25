package jftha.spells;

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

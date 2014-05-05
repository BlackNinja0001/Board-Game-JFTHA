package jftha.spells;

import java.util.Random;
import jftha.heroes.Hero;
import jftha.heroes.Mage;

public class SummonPet extends SelfSpell {

    private int petDamage;
    
    private int petHealth;
    
    /**
     * Constructor
     */
    public SummonPet() {
        this.setMaxCooldown(6);
        this.setGoldCost(15);
        this.setmpCost(30);
        randomizeDamage();
        randomizeHealth();
        this.setMessage("Summon Pet. Allows hero to summon a pet to his/her side."
                + " Cost " + this.getmpCost() + " MP");
    }

    public int getPetDamage() {
        return petDamage;
    }
    
    public int getPetHealth() {
        return petHealth;
    }

    public void setPetDamage(int petDamage) {
        this.petDamage = petDamage;
    }
    
    public void setPetHealth(int petHealth){
        this.petHealth = petHealth;
    }
    
    /**
     * Random damage from 2-10
     * @return 
     * Pet Damage
     */
    public final int randomizeDamage(){
        Random rand = new Random();
        petDamage = rand.nextInt(9) + 2; //2-10
        return petDamage;
    }
    
    /**
     * Random health from 5-15
     * @return 
     * Pet Health
     */
    public final int randomizeHealth(){
        Random rand = new Random();
        petHealth = rand.nextInt(10) + 5; //5-15
        return petHealth;
    }

    @Override
    public void castSpell(Hero caster) {
        if(this.getCurrentCD() > 0) {
            caster.addPet();
            if(caster instanceof Mage) {
                    caster.setCurrentMP(caster.getCurrentMP() - (int)(getmpCost() * Mage.multiplier));
                } else {
                    caster.setCurrentMP(caster.getCurrentMP() - getmpCost());
                }
            } else if (this.getCurrentCD() == 0) {
                setCurrentCD(this.getMaxCooldown());
            } else {
                setCurrentCD(this.getCurrentCD() - 1);
            }
    }
}

package jftha.spells;

import java.util.Random;

public class SummonPet extends Spell {

    private int petDamage;
    
    private int petHealth;
    
    public SummonPet() {
        this.setMaxCooldown(6);
        this.setmpCost(30);
        randomizeDamage();
        this.petDamage = 0;
        this.petHealth = 0;
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
    
    public int randomizeDamage(){
        Random rand = new Random();
        petDamage = rand.nextInt(9) + 2; //2-10
        return petDamage;
    }
    
    public int randomizeHealth(){
        Random rand = new Random();
        petHealth = rand.nextInt(10) + 5; //5-15
        return petHealth;
    }
}
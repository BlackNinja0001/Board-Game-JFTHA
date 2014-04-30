package jftha.spells;

import java.util.Random;
import jftha.main.Buyable;
import jftha.heroes.Hero;

public abstract class Spell extends Buyable{
    private int mpCost;
    private int hpChange;
    private int maxCooldown = (-1);
    private int maxDuration = (-1);

    private int minHPChange;
    private int maxHPChange;
    private int currentCD;
    private int currentDuraton;
    
    String message;
    
    // Constructor
    public Spell() {
    }
    
    private void randomize(){
        Random rand = new Random();
        this.hpChange = minHPChange + (int)(rand.nextDouble() * (maxHPChange - minHPChange) + 1); //potential off by one error, thx to Shane       
    }
    
    public abstract void castSpell(Hero caster);
    
    public abstract void castSpell(Hero caster, Hero victim);
    
    // Setter methods
    public void setmpCost(int newmpCost){
        this.mpCost = newmpCost;
    }
    
    public void setMaxCooldown(int newcooldown){
        this.maxCooldown = newcooldown;
        this.setCurrentCD(newcooldown);
    }
    
    public void setMaxDuration(int maxDuration) {
        this.maxDuration = maxDuration;
        this.setCurrentDuraton(maxDuration);
    }

    public void setMinHPChange(int minHPChange) {
        this.minHPChange = minHPChange;
    }
    
    public void setMaxHPChange(int maxHPChange) {
        this.maxHPChange = maxHPChange;
    }
    
    public void setCurrentCD(int currentCD) {
        this.currentCD = currentCD;
    }
    
    public void setCurrentDuraton(int currentDuraton) {
        this.currentDuraton = currentDuraton;
    }
    
    public void setMessage(String message){
        this.message = message;
    }
    
    // Gettter methods
    public int getmpCost(){
        return this.mpCost;
    }
    
    public int getMaxCooldown(){
        return this.maxCooldown;
    }
    
    public int getMaxDuration() {
        return maxDuration;
    }
    
    public int getHpChange() {
        this.randomize();
        return hpChange;
    }
    
    public int getMinHPChange() {
        return minHPChange;
    }
    
    public int getMaxHPChange() {
        return maxHPChange;
    }
    
    public int getCurrentCD() {
        return currentCD;
    }
    
    public int getCurrentDuraton() {
        return currentDuraton;
    }
    
    public String getMessage(){
        return this.message;
    }
}

package jftha.spells;

import java.util.Random;
import jftha.main.Buyable;

public class Spell extends Buyable{
    private int mpCost;
    private int damage;
    private int cooldown = (-1);
    private int duration = (-1);

    private int minDamage;
    private int maxDamage;
    private int currentCD;
    private int currentDuraton;
    
    // Constructor
    public Spell() {
    }
    
    private void randomize(){
        Random rand = new Random();
        this.damage = minDamage + (int)(rand.nextDouble() * (maxDamage - minDamage) + 1); //potential off by one error, thx to Shane       
    }
    
    public void countdown(){
        
    }
    
    // Setter methods
    public void setmpCost(int newmpCost){
        this.mpCost = newmpCost;
    }
    
    public void setCooldown(int newcooldown){
        this.cooldown = newcooldown;
        this.setCurrentCD(newcooldown);
    }
    
    public void setDuration(int duration) {
        this.duration = duration;
        this.setCurrentDuraton(duration);
    }

    public void setMinDamage(int minDamage) {
        this.minDamage = minDamage;
    }
    
    public void setMaxDamage(int maxDamage) {
        this.maxDamage = maxDamage;
    }
    
    public void setCurrentCD(int currentCD) {
        this.currentCD = currentCD;
    }
    
    public void setCurrentDuraton(int currentDuraton) {
        this.currentDuraton = currentDuraton;
    }
    
    
    // Gettter methods
    public int getmpCost(){
        return this.mpCost;
    }
    
    public int getCooldown(){
        return this.cooldown;
    }
    
    public int getDuration() {
        return duration;
    }
    
    public int getDamage() {
        this.randomize();
        return damage;
    }
    
    public int getMinDamage() {
        return minDamage;
    }
    
    public int getMaxDamage() {
        return maxDamage;
    }
    
    public int getCurrentCD() {
        return currentCD;
    }
    
    public int getCurrentDuraton() {
        return currentDuraton;
    }
}

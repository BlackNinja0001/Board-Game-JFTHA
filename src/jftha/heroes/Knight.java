package jftha.heroes;

import jftha.items.*;
public class Knight extends Hero{
    
    
    
    //Constructor
    public Knight(){
        this.setDefense(super.getDefense() + 2);
        this.setAgility(super.getAgility() - 2);
        this.addItem(new SuitOfArmor());
        this.addItem(new IronSword());
        this.setClassName("Knight");
        this.setCurCooldown(0);
        this.setCurDuration(0);
        this.setMaxCooldown(10);
        this.setMaxDuration(3);
    }
    
    /**
     * Portable Protection - When activated, cannot move for the next turn. 
     * After missed turn, become invincible for 3 turns. 
     * Cooldown period: 10 turns.
     */
    @Override
    public void triggerSpecial(){
        //will watch if knight is invincible in Hero's Attack method
        super.triggerSpecial();
        
    }
}

package jftha.main;

import java.util.*;
import jftha.effects.*;

public class Buyable { //created because Spell and Item share many characteristics
    private String name;
    private ArrayList<Effect> effects;
    private int goldCost;
    private String description;

    //Setter methods
    public void setName(String newName) {
        this.name = newName;
    }

    public void addEffect(Effect newEffect) {
        this.effects.add(newEffect);
    }
    
    //dropEffect
    public boolean dropEffect(Effect effect) {
        if(!effects.contains(effect)){
            return false;
        } else {
            effects.remove(effect);
            return true;
        }
    }
    
    public void setGoldCost(int newGoldCost){
        this.goldCost = newGoldCost;
    }
    
    public void setDescription(String newDesc){
        this.description = newDesc;
    }
    
    //Getter methods
    public String getName(){
        return this.name;
    }
    
    public ArrayList<Effect> getEffects(){
        return this.effects;
    }
    
    public int getGoldCost(){
        return this.goldCost;
    }
    
    public String getDescription(){
        return this.description;
    }
}

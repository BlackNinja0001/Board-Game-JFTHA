package jftha.main;

import java.util.*;

public class Buyable { //created because Spell and Item share many characteristics
    private String name;
    private int goldCost;
    private String description;

    //Setter methods
    public void setName(String newName) {
        this.name = newName;
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
    
    public int getGoldCost(){
        return this.goldCost;
    }
    
    public String getDescription(){
        return this.description;
    }
}

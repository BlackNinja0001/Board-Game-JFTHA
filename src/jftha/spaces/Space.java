package jftha.spaces;

import jftha.main.Effect;
import jftha.heroes.Hero;

public class Space {
    private int spaceID;
    private Effect effect;
    private char activationType; //p for pass-by, l for land-on
    private Hero activator;
    private boolean isChest;
    private boolean isStore;
    private boolean isD2D; // Duel to the Death
    private boolean isHealth;
    private boolean isCard;
    
    public Space next;
    public Space prev;
    
    public Space(){
        next = null;
        prev = null;
    }
    
    public Space(Effect inEffect){
        effect = inEffect;
        
        next = null;
        prev = null;
    }
    
    public Space(char inActivationType){
        activationType = inActivationType;
        
        next = null;
        prev = null;
    }
    
    public Space(Hero inActivater){
        activator = inActivater;
        
        next = null;
        prev = null;
    }
    public Space(int inSpaceID){
        spaceID = inSpaceID;
        
        next = null;
        prev = null;
    }
    public Space(int inSpaceID, boolean inIsChest, boolean inIsStore, boolean inIsD2D, boolean inIsHealth, boolean inIsCard){
        spaceID = inSpaceID;
        isChest = inIsChest;
        isStore = inIsStore;
        isD2D = inIsD2D;
        isHealth = inIsHealth;
        isCard = inIsCard;
        
        next = null;
        prev = null;
    }
    
    public Space(int inSpaceID, Effect inEffect, char inActivationType, Hero inActivater){
        spaceID = inSpaceID;
        effect = inEffect;
        activationType = inActivationType;
        activator = inActivater;
        
        next = null;
        prev = null;
    }
    
    //Getter Methods
    public int getSpaceID(){
        return spaceID;
    }
    public boolean getIsChest(){
        return isChest;
    }
    public boolean getIsStore(){
        return isStore;
    }
    public boolean getIsD2D(){
        return isD2D;
    }
    public boolean getIsHealth(){
        return isHealth;
    }
    public boolean getIsCard(){
        return isCard;
    }
}

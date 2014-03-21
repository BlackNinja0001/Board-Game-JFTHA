package jftha.spaces;

import jftha.main.Effect;
import jftha.heroes.Hero;

public class Space {
    private int spaceID;
    private Effect effect;
    private char activationType; //p for pass-by, l for land-on
    private Hero activater;
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
        activater = inActivater;
        
        next = null;
        prev = null;
    }
    public Space(int inSpaceID){
        spaceID = inSpaceID;
        
        next = null;
        prev = null;
    }
    
    public Space(int inSpaceID, Effect inEffect, char inActivationType, Hero inActivater){
        spaceID = inSpaceID;
        effect = inEffect;
        activationType = inActivationType;
        activater = inActivater;
        
        next = null;
        prev = null;
    }

}

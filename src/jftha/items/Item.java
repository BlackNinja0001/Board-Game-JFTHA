package jftha.items;

import jftha.main.Buyable;
import jftha.main.Player;

public abstract class Item extends Buyable{

    private RarityEnum rarity;
    private boolean isSpiritual;
    private String description;
    private String message;
    
    public void setMessage(String message){
        this.message = message;
    }
    
    public void setRarity(RarityEnum newRarity){
        this.rarity = newRarity;
    }
    
    public void setSpiritual(boolean isSpiritual){
        this.isSpiritual = isSpiritual;
    }
    
    public void setDesc(String desc){
        this.description = desc;
    }
    
    public RarityEnum getRarity(){
        return this.rarity;
    }
    
    public boolean getSpiritual(){
        return this.isSpiritual;
    }
    
    public String getDesc(){
        return this.description;
    }
    
    public String getMessage(){
        return this.message;
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
    
    public abstract void triggerEffect();
    
    public abstract void triggerEffect(Player affected);
    
    public abstract void triggerEffect(Player affected1, Player affected2);
    
    public abstract void triggerEffect(Player affected1, Player affected2, Player affected3);
}

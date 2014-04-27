package jftha.items;

import jftha.main.Buyable;
import jftha.heroes.Hero;

public abstract class Item extends Buyable{

    private RarityEnum rarity;
    private boolean isSpiritual;
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
    
    public RarityEnum getRarity(){
        return this.rarity;
    }
    
    public boolean getSpiritual(){
        return this.isSpiritual;
    }
    
    public String getMessage(){
        return this.message;
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
    
    public abstract void triggerEffect();
    
    public abstract void triggerEffect(Hero affected);
    
    public abstract void triggerEffect(Hero affected1, Hero affected2);
}

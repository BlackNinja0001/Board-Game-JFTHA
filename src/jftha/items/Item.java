package jftha.items;

import jftha.main.Buyable;

public class Item extends Buyable{

    private RarityEnum rarity;
    private boolean isSpiritual;
    
    public void setRarity(RarityEnum newRarity){
        this.rarity = newRarity;
    }
    
    public RarityEnum getRarity(){
        return this.rarity;
    }
    
    public void setSpiritual(boolean isSpiritual){
        this.isSpiritual = isSpiritual;
    }
    
    public boolean getSpiritual(){
        return this.isSpiritual;
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

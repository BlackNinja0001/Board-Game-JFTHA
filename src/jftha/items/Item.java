package jftha.items;

import jftha.main.Buyable;
import java.util.ArrayList;

public class Item extends Buyable{

    private String rarity;
    private boolean isSpiritual;
    
    public void setRarity(String newRarity){
        this.rarity = newRarity;
    }
    
    public String getRarity(){
        return this.rarity;
    }
    
    public void setSpiritual(boolean isSpiritual){
        this.isSpiritual = isSpiritual;
    }
    
    public boolean getSpiritual(){
        return this.isSpiritual;
    }
}

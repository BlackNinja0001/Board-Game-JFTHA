package jftha.cards;

import jftha.main.Effect;

public class Card {
    
    private Effect effect;
    private String message;

    //Setter oethods
    public void setMessage(String message) {
        this.message = message;
    }
    
    public void setEffect(Effect e){
        this.effect = e;
    }

    //Getter methods
    public String getMessage() {
        return message;
    }
    
    public Effect getEffect(){
        return this.effect;
    }
}

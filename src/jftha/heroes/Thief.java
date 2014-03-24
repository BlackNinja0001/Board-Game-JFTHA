package jftha.heroes;

import jftha.items.Tuxedo;
import jftha.items.FastHands;

public class Thief extends Hero{

    //Constructor
    public Thief(){
        this.setLuck(super.getLuck() + 2);
        this.addItem(new Tuxedo());
        this.addItem(new FastHands());
        this.setClassName("Thief");
    }
}

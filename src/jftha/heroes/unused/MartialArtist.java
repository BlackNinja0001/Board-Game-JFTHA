package jftha.heroes.unused;

import jftha.heroes.Hero;

public class MartialArtist extends Hero{
    
    //Constructor
    public MartialArtist(){
        this.setStrength(super.getStrength() + 2);
        this.setAgility(super.getAgility() + 2);
        this.setMaxHP(super.getMaxHP() + 10);
        this.setMaxMP(super.getMaxMP() + 10);
        this.setClassName("Martial Artist");
    }
    
}

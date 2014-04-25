package jftha.items;

import jftha.heroes.Hero;

public abstract class Weapon extends Equippable{
    
    public Weapon(){
        
    }
    
    public abstract void equipWeap(Hero hero);
    public abstract void dropWeap(Hero hero);
    public abstract void weapEffect(Hero hero);
}

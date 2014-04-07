package jftha.items;

import jftha.main.Player;

public abstract class Weapon extends Equippable{
    public Weapon(){
        
    }
    
    public abstract void equipWeap(Player player);
    public abstract void dropWeap(Player player);
    public abstract void weapEffect(Player player);
    public abstract void weapEffect(Player attacker, Player attacked);
}

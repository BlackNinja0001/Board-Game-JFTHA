package jftha.items;

import jftha.main.Player;

public abstract class Armor extends Equippable{
    
    public abstract void equipArmor(Player player);
    public abstract void dropArmor(Player player);
    public abstract void armorEffect(Player player);
}

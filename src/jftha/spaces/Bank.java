package jftha.spaces;

import jftha.heroes.*;
import jftha.main.Player;

public class Bank extends Space{
    int bankTax = 0;
    
    public Bank(){
        this.setActivationType('L');
        this.setSpaceType(SpaceEnum.Bank);
    }
    
    public void collect(int tax){
        bankTax += tax;
    }

    @Override
    public void triggerEffect() {
        Player p = getActivator();
        Hero recipient = p.getCharacter();
        recipient.setGold(recipient.getGold() + bankTax);
        bankTax = 0;
    }

    @Override
    public void triggerEffect(Player affected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

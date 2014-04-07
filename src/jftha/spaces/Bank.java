package jftha.spaces;

import jftha.heroes.*;

public class Bank extends Space{
    int bankTax = 0;
    
    public Bank(){
        this.setActivationType('l');
        this.setSpaceType(SpaceEnum.Bank);
    }
    
    public void collect(int tax){
        bankTax += tax;
    }

    @Override
    public void triggerEffect() {
        Hero recipient = this.getActivator();
        recipient.setGold(recipient.getGold() + bankTax);
        bankTax = 0;
    }

    @Override
    public void triggerEffect(Hero affected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

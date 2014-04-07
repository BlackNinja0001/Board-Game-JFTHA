package jftha.spaces;

import jftha.heroes.*;

public class Bank extends Space{
    int bankTax;
    
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
    }
    
}

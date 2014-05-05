package jftha.spaces;

import jftha.heroes.*;
import jftha.main.Player;

public class Bank extends Space{
    int bankTax = 0;
    
    /**
     * Constructor
     */
    public Bank(){
        this.setActivationType('L');
        this.setSpaceType(SpaceEnum.Bank);
    }
    
    /**
     * Takes in an Integer as a parameter.
     * Creates a sum to be used.
     * @param tax 
     */
    public void collect(Hero hero, int tax){
        hero.setGold(hero.getGold() - tax);
        if (hero.getGold() < 0){
            hero.setGold(0);
        }
        bankTax += tax;
    }

    /**
     * Give current player the sum collected by collect method.
     * Then reset it back to zero.
     */
    @Override
    public void triggerEffect() {
        Player p = getActivator();
        Hero recipient = p.getCharacter();
        recipient.setGold(recipient.getGold() + bankTax);
        bankTax = 0;
    }

    /**
     * No Effect
     * @param affected 
     */
    @Override
    public void triggerEffect(Player affected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

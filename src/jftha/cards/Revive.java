package jftha.cards;

import jftha.heroes.*;
import jftha.main.*;

public class Revive extends Card{

    /**NO EFFECT.
     * 
     */
    @Override
    public void triggerEffect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void triggerEffect(Player affected) {
         Hero hero = affected.getCharacter();
         if(hero.isGhost() == false){
             this.setMessage("You're not dead. Go away.");
         }else if(hero.isGhost() == true){
             this.setMessage("Its your lucky day. Welcome back to the land of the living.");
             hero.unGhost();
         }
    }

    /**NO EFFECT.
     * 
     */
    @Override
    public void triggerEffect(Player affected1, Player affected2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**NO EFFECT.
     * 
     */
    @Override
    public void triggerEffect(Player affected1, Player affected2, Player affected3) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

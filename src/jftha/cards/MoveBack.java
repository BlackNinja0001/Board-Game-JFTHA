package jftha.cards;

import jftha.main.*;
import jftha.spaces.*;

public class MoveBack extends Card {

    /**
     * Takes in Player Class as a parameter.
     * Moves current player back 3 spaces.
     * @param affected 
     */
    @Override
    public void triggerEffect(Player affected) {
        int movement = 3;
        while (movement >= 0) {
            Space current = affected.move("b");
            if (current.getActivationType() == 'p') { //pass-by
                ((RegularSpace)current).triggerEffect();
            } else if (movement == 0 && current.getActivationType() == 'l') { //land-on
                if (current instanceof AttackSpace) {
                    // prompt for hero
                    Player p = null;
                    ((AttackSpace)current).triggerEffect(p);
                } else {
                    ((RegularSpace)current).triggerEffect();
                }
                movement--;
            } else {
                throw new IllegalActivationTypeException();
            }
        }
        this.setMessage("A friar in front of you has really bad B.O. Move back 3 spaces to avoid the fumes.");
    }

    /**NO EFFECT.
     * 
     */
    @Override
    public void triggerEffect(Player affected1, Player affected2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

package jftha.spaces;

import java.util.Random;
import jftha.cards.CardFactory;
import jftha.cards.RarityEnum;

public class SpaceFactory {
    public Space buildItem(SpaceEnum type) {
        Space space = null;
        switch(type) {
            case Chest:
                space = new Chest();
                break;
            case D2D:
                space = new D2D();
                break;
            case Gold:
                space = new Gold();
                break;
            case Health:
                space = new Health();
                break;
            case Store:
                space = new Store();
                break;
            case Card:
                // Need to make a random card space
                break;
            default:
                //throw new IllegalActivationTypeException("Oops. There is no such type of space.");
        }
        return space;
    }
}

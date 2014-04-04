package jftha.spaces;

import jftha.effects.*;
import jftha.heroes.*;

public class Space {

    private int spaceID;
    private char activationType; //p for pass-by, l for land-on
    private Hero activator;
    private boolean isChest;
    private boolean isStore;
    private boolean isD2D; // Duel to the Death
    private boolean isHealth;
    private boolean isCard;
    private boolean isGold;
    public Space next;
    public Space prev;

    public Space() {
        next = null;
        prev = null;
    }

    public Space(char inActivationType) {
        activationType = inActivationType;

        next = null;
        prev = null;
    }

    public Space(Hero inActivator) {
        activator = inActivator;

        next = null;
        prev = null;
    }

    public Space(int inSpaceID) {
        spaceID = inSpaceID;

        next = null;
        prev = null;
    }

    public Space(int inSpaceID, boolean inIsChest, boolean inIsStore, boolean inIsD2D, boolean inIsHealth, boolean inIsCard) {
        spaceID = inSpaceID;
        isChest = inIsChest;
        isStore = inIsStore;
        isD2D = inIsD2D;
        isHealth = inIsHealth;
        isCard = inIsCard;

        next = null;
        prev = null;
    }

    public Space(int inSpaceID, char inActivationType, Hero inActivator) {
        spaceID = inSpaceID;
        activationType = inActivationType;
        activator = inActivator;

        next = null;
        prev = null;
    }

    //Getter Methods
    public int getSpaceID() {
        return spaceID;
    }

    public boolean getIsChest() {
        return isChest;
    }

    public boolean getIsStore() {
        return isStore;
    }

    public boolean getIsD2D() {
        return isD2D;
    }

    public boolean getIsHealth() {
        return isHealth;
    }

    public boolean getIsCard() {
        return isCard;
    }

    public boolean getIsGold() {
        return isGold;
    }

    public char getActivationType() {
        return activationType;
    }

    public Hero getActivator() {
        return activator;
    }

    // Setter method
    protected void setActivationType(char c) {
        activationType = c;
    }

    protected void setActivator(Hero hero) {
        this.activator = hero;
    }
}

package jftha.main;

import jftha.heroes.*;

public class Player {

    private String customName;
    private Hero character;
    private int turnOrder = -1;

    public Player() {
        this.customName = "";
        this.character = null;
    }

    public Player(String customName, Hero character) {
        this.customName = customName;
        this.character = character;
    }

    //Getter methods
    public String getCustomName() {
        return customName;
    }

    public Hero getCharacter() {
        return character;
    }

    public int getTurnOrder() {
        return turnOrder;
    }

    //Setter methods
    public void setCustomName(String customName) {
        this.customName = customName;
    }

    public void setCharacter(Hero character) {
        this.character = character;
    }

    public void setTurnOrder(int turnOrder) {
        this.turnOrder = turnOrder;
    }
}

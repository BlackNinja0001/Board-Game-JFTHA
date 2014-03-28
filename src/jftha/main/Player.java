package jftha.main;

import jftha.heroes.*;

public class Player {

    private String customName;
    private Hero character;
    private int turnOrder = -1;
    private boolean isWinner;
    private int winCount = 0;

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
    public boolean isWinner() {
        return isWinner;
    }
    public int getWinCount() {
        return winCount;
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
    public void setIsWinner(boolean isWinner) {
        this.isWinner = isWinner;
    }    
    public void setWinCount(int winCount) {
        this.winCount = winCount;
    }
    public void upWinCount() {
        this.winCount++;
    }
}

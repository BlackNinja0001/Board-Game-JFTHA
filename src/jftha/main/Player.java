package jftha.main;

import jftha.heroes.*;
import jftha.items.Armor;
import jftha.items.Weapon;
import jftha.spaces.Space;

public class Player {

    private String customName;
    private Hero character;
    private int turnOrder = -1;
    private boolean isWinner;
    private int winCount = 0;
    private Space currentSpace;
    private int lostTurns;
    // Keeps track of the weapon that player has equipped
    private Weapon weapon;
    private boolean hasWeapon;
    // Keeps track of the armor that player has equipped
    private Armor armor;
    private boolean hasArmor;
    
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

    public Space getCurrentSpace() {
        return currentSpace;
    }

    public int getLostTurns() {
        return lostTurns;
    }
    public Weapon getWeapon() {
        return weapon;
    }
    
    public boolean hasWeapon() {
        return hasWeapon;
    }
    
    public Armor getArmor() {
        return armor;
    }
    
    public boolean hasArmor() {
        return hasArmor;
    }

    //Setter methods
    public void setCustomName(String customName) {
        this.customName = customName;
    }
    
    public void setCurrentSpace(Space space){
        this.currentSpace = space;
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

    public void setLostTurns(int lostTurns) {
        this.lostTurns = lostTurns;
    }
    
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
    
    public void setHasWeapon(boolean hasWeapon) {
        this.hasWeapon = hasWeapon;
    }
    
    public void setArmor(Armor armor) {
        this.armor = armor;
    }
    
    public void setHasArmor(boolean hasArmor) {
        this.hasArmor = hasArmor;
    }
    

    public Space move(String s) {
        if (this.lostTurns == 0) {
            if (s.equalsIgnoreCase("f")) { // move forward
                this.currentSpace = this.currentSpace.next;
                currentSpace.setActivator(this);
                System.out.println("Current Space ID = " + this.currentSpace.getSpaceID());
                return this.currentSpace;
            } else if (s.equalsIgnoreCase("b")) { // move backward
                this.currentSpace = this.currentSpace.prev;
                currentSpace.setActivator(this);
                System.out.println("Current Space ID = " + this.currentSpace.getSpaceID());
                return this.currentSpace;
            } else {
                return null;
            }
        } else {
            this.lostTurns--;
            return this.currentSpace;
        }
    }
}

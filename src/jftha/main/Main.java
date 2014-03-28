package jftha.main;

import jftha.heroes.*;
import java.util.Scanner;

public class Main { //definitely need more error handling

    int turnNumber = 0;
    public static void main(String[] args) {
        Player[] players = new Player[4];
        Scanner scan = new Scanner(System.in);
        // add conditions to naming/character selection process
        System.out.println("How many players?");
        int howmany = scan.nextInt(); // keep asking if given invalid number // handle error/exception for non-int
        Dice die = new Dice(howmany);

        for (int i = 1; (i - 1) < howmany; i++) { //may need more error handling
            System.out.println("Player " + i + ", what is your name?");
            String name = scan.next();
            System.out.println("Player " + i + ", which character do you pick?"); // handle error/exception for non-int
            int heroNum = scan.nextInt();
            Hero playerHero = null;
            switch (heroNum) {
                case 1:
                    playerHero = new Barbarian();
                    break;
                case 2:
                    playerHero = new Ninja();
                    break;
                case 3:
                    playerHero = new Mage();
                    break;
                case 4:
                    playerHero = new Knight();
                    break;
                case 5:
                    playerHero = new MartialArtist();
                    break;
                case 6:
                    playerHero = new Thief();
                    break;
                case 7:
                    playerHero = new Priest();
                    break;
                case 8:
                    playerHero = new Merchant();
                    break;
                case 9:
                    playerHero = new Paladin();
                    break;
                default:
                    System.out.println("Error: No character picked.");
            }
            players[i - 1] = new Player(name, playerHero);
        }

        System.out.println("Determining turn order...");
        for (int i = 0; i < howmany; i++) { //Give every player an initial turn order
            players[i].setTurnOrder(die.roll());
        }

        for (int j = 0; j < howmany; j++) { //for every player
            int roll = die.roll();
            boolean didReroll = true;
            while (didReroll) {
                didReroll = false;
                for (int k = 0; k < howmany; k++) { //check if any turnOrders match and changes accordingly
                    if (j != k) { //not checking player to itself
                        while (roll == players[k].getTurnOrder()) { //reroll until it doesn't match the current player
                            roll = die.roll();
                            didReroll = true;
                        }
                    }
                }
            }
            players[j].setTurnOrder(roll);
        }

        for (int i = 1; (i - 1) < howmany; i++) {
            StringBuilder sb = new StringBuilder();
            String order = "";
            int curTurnOrder = players[i - 1].getTurnOrder();
            if (curTurnOrder == 1) {
                order = "1st";
            } else if (curTurnOrder == 2) {
                order = "2nd";
            } else if (curTurnOrder == 3) {
                order = "3rd";
            } else if (curTurnOrder == 4) {
                order = "4th";
            }
            sb.append("Player ").append(i)
                    .append(" is a ").append(players[i - 1].getCharacter().getClassName())
                    .append(" named ").append(players[i - 1].getCustomName())
                    .append(" and is going ").append(order).append(".");
            System.out.println(sb.toString());
        }
    }
    //Needs testing
    public Player winner(Player[] players) {
        Player ret = null;
        int numPlayers = 0;
        for(Player p : players) {
            numPlayers++;
        }
        if(numPlayers == 4) {
            // Have all opponents dead for at least a period of 5 turns (4 player only)
            if(players[1].getCharacter().isGhost() && players[2].getCharacter().isGhost() 
                    && players[3].getCharacter().isGhost()) {
                players[0].upWinCount();
                if(players[0].getWinCount() > 4) {
                    players[0].setIsWinner(true);
                    ret = players[0];  // redundant; need to pick which method
                }
            } else if(players[0].getCharacter().isGhost() && players[2].getCharacter().isGhost() 
                    && players[3].getCharacter().isGhost()) {
                players[1].upWinCount();
                if(players[1].getWinCount() > 4) {
                    players[1].setIsWinner(true);
                    ret = players[1];  // redundant; need to pick which method
                }
            } else if(players[0].getCharacter().isGhost() && players[1].getCharacter().isGhost() 
                    && players[3].getCharacter().isGhost()) {
                players[2].upWinCount();
                if(players[2].getWinCount() > 4) {
                    players[2].setIsWinner(true);
                    ret = players[2];  // redundant; need to pick which method
                }
            } else if(players[0].getCharacter().isGhost() && players[1].getCharacter().isGhost() 
                    && players[2].getCharacter().isGhost()) {
                players[3].upWinCount();
                if(players[3].getWinCount() > 4) {
                    players[3].setIsWinner(true);
                    ret = players[3];  // redundant; need to pick which method
                }
            }
            
            // any resurrections reset counter
        }
        
        // OR
        // Have all player ghosts non-existent (killed as ghost)
        else if(numPlayers == 3) { 
            if(players[1].getCharacter().getEliminated() && players[2].getCharacter().getEliminated()){
                players[0].setIsWinner(true);
                ret = players[0];
            } else if(players[0].getCharacter().getEliminated() && players[2].getCharacter().getEliminated()){
                players[1].setIsWinner(true);
                ret = players[1];
            } else {
                players[2].setIsWinner(true);
                ret = players[2];
            }          
        } 
        else { // two players should eleminate posibilty of one above
            if(players[1].getCharacter().getEliminated()) {
                players[0].setIsWinner(true);
                ret = players[0];
            }
        }
        
        return ret;
    }
}

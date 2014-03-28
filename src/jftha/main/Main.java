package jftha.main;

import jftha.heroes.*;
import java.util.Scanner;

public class Main { //definitely need more error handling

    int turnNumber = 0;
    public static void main(String[] args) {
        Player[] players = new Player[4];
        Scanner scan = new Scanner(System.in);
        System.out.println("How many players?");
        int howmany = scan.nextInt();
        Dice die = new Dice(howmany);

        for (int i = 1; (i - 1) < howmany; i++) { //may need more error handling
            System.out.println("Player " + i + ", what is your name?");
            String name = scan.next();
            System.out.println("Player " + i + ", which character do you pick?");
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
        for (int i = 0; i < howmany; i++) {
            int j = 0, roll = die.roll();

            //probably needs better implementation
            while (j < (howmany - 1)) { //checks if any turnOrders match and changes accordingly
                if (roll == players[j + 1].getTurnOrder()) { //will not affect last player
                    roll = die.roll();
                } else if ((j - 1) == (howmany - 1)) { //last player
                    boolean not1 = false,
                            not2 = false,
                            not3 = false,
                            not4 = false;
                   for (int k = 0; k < howmany; k++){
                       switch (players[k].getTurnOrder()){
                           case 1:
                               not1 = true;
                           case 2:
                               not2 = true;
                           case 3:
                               not3 = true;
                           case 4:
                               not4 = true;
                       }
                       
                       if (not1){
                           if (not2){
                               if (not3){
                                   players[i].setTurnOrder(4);
                               }else{
                                   players[i].setTurnOrder(3);
                               }
                           } else {
                               players[i].setTurnOrder(2);
                           }
                       }else{
                           players[i].setTurnOrder(1);
                       }
                   }
                } else {
                    players[i].setTurnOrder(roll);
                    j++;
                }
            }
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
                    .append(" is a(n) ").append(players[i - 1].getCharacter().getClassName())
                    .append(" named ").append(players[i - 1].getCustomName())
                    .append(" and is going ").append(order).append(".");
            System.out.println(sb.toString());
        }
    }
    
    public Player winner(Player[] players) {
        int numPlayers = 0;
        for(Player p : players) {
            numPlayers++;
        }
        System.out.println(numPlayers);
        // Have all opponents dead for at least a period of 5 turns (4 player only)
        // OR
        // Have all player ghosts non-existent (killed as ghost)
        return null;
    }
}

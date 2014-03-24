package jftha.main;

import jftha.heroes.*;
import java.util.Scanner;
import java.lang.*;

public class Main {

    /**
     * @param args the command line arguments
     */
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
            findHero(heroNum, playerHero);
            players[i - 1] = new Player(name, playerHero);
        }

        System.out.println("Determining turn order...");
        for (int i = 0; i < howmany; i++) {
            int j = i, roll = die.roll();

            while (j < (howmany - 1)) { //checks if any turnOrders match and changes accordingly
                if (roll == players[j + 1].getTurnOrder()) {
                    roll = die.roll();
                } else {
                    players[j].setTurnOrder(roll);
                    j++;
                }
            }
        }

        for (int i = 1; (i - 1) < howmany; i++) {
            StringBuilder sb = new StringBuilder();
            sb.append("Player " + i + " is a(n) " + players[i-1].getCharacter().getClass().getSimpleName() + " named " + players[i-1].getCustomName());
            System.out.println(sb.toString());
        }
    }

    private static void findHero(int heroId, Hero h) {
        switch (heroId) {
            case 1:
                h = new Barbarian();
                break;
            case 2:
                h = new Ninja();
                break;
            case 3:
                h = new Mage();
                break;
            case 4:
                h = new Knight();
                break;
            case 5:
                h = new MartialArtist();
                break;
            case 6:
                h = new Thief();
                break;
            case 7:
                h = new Priest();
                break;
            case 8:
                h = new Merchant();
                break;
            case 9:
                h = new Paladin();
                break;
            default:
                System.out.println("Error: No character picked.");
        }
    }
}

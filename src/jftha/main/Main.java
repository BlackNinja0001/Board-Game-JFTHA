package jftha.main;

import java.util.ArrayList;
import jftha.heroes.*;
import jftha.items.*;
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
        int numPlayers = 0, winnerIndex = -1;

        for (Player p : players) {
            numPlayers++;
        }
        if (numPlayers == 4) {
            // Have all opponents dead for at least a period of 5 turns (4 player only)

            for (int i = 0; i < players.length; i++) {
                upWinCountValidated(players, i);
                if (allOpponentsNonExistent(players, i)) {
                    ret = players[i];
                }
            }

            if ((winnerIndex = anyoneWon(players)) != -1) {
                ret = players[winnerIndex];
            }

            // any resurrections reset counter
        } // OR
        // Have all player ghosts non-existent (killed as ghost)
        else {
            for (int i = 0; i < players.length; i++) {
                if (allOpponentsNonExistent(players, i)) {
                    ret = players[i];
                }
            }
        }

        return ret;
    }

    /**
     * Checks if players[winningPlayer]'s winCount can be upped (all opponents
     * dead). If so, then increment players[winningPlayer]'s winCount
     *
     * @param players the players currently playing
     * @param winningPlayer the index of the player soon to win
     * @return true if players[winningPlayer]'s winCount is ready to be upped
     * @return false if not
     */
    public boolean upWinCountValidated(Player[] players, int winningPlayer) {
        //Winning players cannot be ghosts and this method only applies to 4-player games
        if ((players[winningPlayer].getCharacter().isGhost()) || (players.length < 4)) {
            return false;
        }

        boolean valid = true;
        for (int i = 0; i < players.length; i++) {
            if (i != winningPlayer) { //do not check if winning player is ghost
                if (!players[i].getCharacter().isGhost()) {
                    valid = false;
                }
            }
        }

        if (valid) {
            players[winningPlayer].upWinCount();
        }

        if (players[winningPlayer].getWinCount() > 4) { //if 5 turns elapsed, player wins
            players[winningPlayer].setIsWinner(true);
        }

        return valid;
    }

    /**
     * Checks if anyone won the game.
     *
     * @param players the players currently playing
     * @return the index of the winner
     */
    public int anyoneWon(Player[] players) {
        int winnerIndex = -1;

        for (int i = 0; i < players.length; i++) {
            if (players[i].isWinner()) {
                winnerIndex = i;
                return winnerIndex;
            }
        }

        return winnerIndex;
    }

    /**
     * Checks if all opponents of "winningPlayer" are non-existent (died as
     * ghost)
     *
     * @return true if all opponents were killed as ghosts
     * @return false if at least one opponent is still in play
     */
    public boolean allOpponentsNonExistent(Player[] players, int winningPlayer) {
        boolean valid = true;

        for (int i = 0; i < players.length; i++) {
            if (i != winningPlayer) { //do not check if winning player is ghost
                if (!players[i].getCharacter().getEliminated()) {
                    valid = false;
                }
            }
        }

        if (valid) {
            players[winningPlayer].setIsWinner(true);
        }

        return valid;
    }

    public void executeTurn(Player performer) {
        //Item phase 1
        turnPhase(performer);

        //Dice Roll

        //Attack

        //Item 2

        //Turn End
    }

    public void turnPhase(Player performer) {
        Scanner s = new Scanner(System.in);
        int itemCount = 0;
        ArrayList<Item> myItems = new ArrayList<Item>();

        char yesOrNo = '~';  //arbitrary character not 'y' or 'n'
        int mistakes = 0;
        while (true) { //will break
            System.out.println("Use item ('y' for yes, 'n' for no)?");
            yesOrNo = s.next().trim().charAt(0);
            if (yesOrNo == 'y') {
                myItems = performer.getCharacter().getItems();
                if (!(myItems).isEmpty()) {
                    for (Item item : myItems) {
                        itemCount++;
                        System.out.println(itemCount + ". " + item.getName());
                    }
                    System.out.println("Which item would you like to use (0 for cancel)");
                    int choice = s.nextInt();
                    
                    //Error: Need to allow player to choose item again
                    if (choice == 0) {
                        return;
                    } else if (choice < 0 || choice > myItems.size()) {
                        System.out.println("Invalid Choice.");
                    } else {
                        Item toBeUsed = myItems.get(choice);
                        //use Item
                    }
                }
                break;
            } else if (yesOrNo == 'n') {
                break;
            } else {
                if (mistakes <= 2) {
                    System.out.println("Invalid Answer.");
                } else if (mistakes == 3) {
                    System.out.println("Invalid Answer. Might I recommend learning how to type correctly?");
                } else if (mistakes == 4) {
                    System.out.println("My bad. Maybe you can type. It's probably your ability to distinguish between y's and n's.");
                } else if (mistakes == 5) {
                    System.out.println("The n looks like a headless camel. The y looks like a person buried headfirst in the sand. It's so tempting to make a y out of you right now.");
                } else if (mistakes == 6) {
                    System.out.println("You're doing this on purpose aren't you? Alright, tell you what. i'll turn my back. Maybe I'm making you nervous.");
                } else if (mistakes == 7) {
                    System.out.println("Is that even a letter? Seriously you need to try.");
                } else {
                    System.out.println("Alright, that's it. I give up. I've given you the benefit of the doubt for far too long.");
                    System.out.println("*The almighty narrator sticks the player's head in the nearest sand pit. It's no use because the player's brainless head needs no oxygen to function.*");
                    performer.getCharacter().setEliminated(true);
                    System.out.println("Game Over");
                    break;
                }
                mistakes++;
            }
        }
    }
}

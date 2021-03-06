package jftha.main;

import java.util.List;
import jftha.heroes.*;
import jftha.items.*;
import java.util.Scanner;
import jftha.spaces.*;
import jftha.spells.AttackSpell;
import jftha.spells.SelfSpell;
import jftha.spells.Spell;

public class Main { //definitely need more error handling

    int turnNumber = 0;
    Player orderedPlayers[];

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // add conditions to naming/character selection process
        System.out.println("How many players?");
        int howmany = scan.nextInt(); // keep asking if given invalid number // handle error/exception for non-int
        Dice die = new Dice(howmany);
        Player[] players = new Player[howmany];
        playerSelection(howmany, scan, players);

        System.out.println("Determining turn order...");
        Main main = new Main();
        main.setTurnOrder(howmany, players, die);

        //Spawn board
        Board board = new Board();
        board.generateBoard(25);
        board.iterateBoard();
        //Spawn players
        for (int i = 0; i < howmany; i++) {
            players[i].setCurrentSpace(board.getStart());
        }
        //Main main = new Main();
        //They take turns
        main.orderedPlayers = new Player[howmany];
        for (int i = 0; i < howmany; i++) {
            main.orderedPlayers[players[i].getTurnOrder() - 1] = players[i];
        }
        int winner;
        do {
            int i;
            for (i = 0; i < howmany; i++) {
                main.executeTurn(main.orderedPlayers[i]);
            }
            i = 0;
            winner = main.anyoneWon(main.orderedPlayers);
        } while (winner == -1);
        //Win message for winner
    }

    public void setTurnOrder(int howmany, Player[] players, Dice die) {
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

    protected static void playerSelection(int howmany, Scanner scan, Player[] players) {
        for (int i = 1; (i - 1) < howmany; i++) { //may need more error handling
            System.out.println("Player " + i + ", what is your name?");
            String name = scan.next();
            System.out.println("Player " + i + ", which character do you pick?"); // handle error/exception for non-int
            System.out.println("Input 1 for Barbarian\nInput 2 for Ninja\nInput 3 for Mage\nInput 4 for Knight\nInput 5 for MartialArtist\n"
                    + "Input 6 for Thief\nInput 7 for Priest\nInput 8 for Merchant\nInput 9 for Paladin");
            int heroNum = scan.nextInt();
            Hero playerHero = null;
            playerHero = assignPlayer(heroNum, playerHero);
            players[i - 1] = new Player(name, playerHero);
        }
    }

    protected static Hero assignPlayer(int heroNum, Hero playerHero) {
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
        return playerHero;
    }

    /**
     * Checks whether or not a player has won the game.
     *
     * @param players The players in the game
     * @return The player that won the game
     */
    public Player winner(Player[] players) {
        Player ret = null;
        int winnerIndex;
        for (Player p : players) {
            if (5 == p.getCharacter().getArtifacts().size()) {
                p.setIsWinner(true);
                return p;
            }
        }

        if (players.length == 4) {
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
                    players[i].setIsWinner(true);
                    ret = players[i];
                }
            }
        }
        return ret;
    }

    /**
     * Checks if players[winningPlayer]'s winCount can be upped (all opponents
     * dead). If so, then increment players[winningPlayer]'s winCount. If not
     * players[winningPlayer]'s winCount is reset to zero.
     *
     * @param players the players currently playing
     * @param winningPlayer the index of the player soon to win
     * @return true if players[winningPlayer]'s winCount is ready to be upped
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
        } else {
            players[winningPlayer].setWinCount(0);
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
     * @return the index of the winner or -1 if there is no winner
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
     * @param players The players in the game
     * @param winningPlayer The player that is currently winning
     * @return true if all opponents were killed as ghosts; false if at least
     * one opponent is still in play
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

    /**
     * Current Player's Turn Phase
     * @param performer
     * @throws IllegalActivationTypeException 
     */
    public void executeTurn(Player performer) throws IllegalActivationTypeException {
        Scanner scan = new Scanner(System.in);
        Hero playerChar = performer.getCharacter();
        playerChar.activateTSCs();
        //Item phase 1
        itemPhase(performer);

        //Dice Roll (factoring in Agility and Luck)
        Dice die = new Dice();
        double maxAmount = (playerChar.getAgility() * 0.8) + (playerChar.getLuck() * 0.2); //may need tinkering
        int intMaxAmount = (int) Math.round(maxAmount);
        die.setMaxAmount(intMaxAmount);
        int movement = die.roll();
        //move the player
        // choose direction
        System.out.println("It's now " + performer.getCustomName() + "'s turn.");
        System.out.println("You rolled a " + movement);
        /*System.out.println("Move forward(f) or backward(b): ");
         String s = scan.next();*/

        while (movement > 0) {
            movement--;
            Space current = performer.move("f");
            if (current.getActivationType() == 'p' && movement >= 0) { //pass-by not landed on
                ((RegularSpace)current).triggerEffect();
            } else if (movement == 0 && current.getActivationType() == 'L') { //land-on landed on
                if (current instanceof AttackSpace) {
                    // Prompt for opponent and pass to triggerEffect
                    System.out.println("Select your victim: "); //Needs to loop if player typed in is not available
                    String opponent = scan.next();
                    for (int i = 0; i < orderedPlayers.length; i++) {
                        Player potVictim = orderedPlayers[i];
                        if (opponent.equalsIgnoreCase(performer.getCustomName())) {
                            continue;
                        }
                        if (!opponent.equalsIgnoreCase(potVictim.getCustomName()) && (i == orderedPlayers.length - 1)) {
                            System.out.println("No such player.");
                            i = 0;
                            System.out.println("Select your victim: "); //Needs to loop if player typed in is not available
                            opponent = scan.next();
                        } else {
                            ((AttackSpace)current).triggerEffect(potVictim);
                        }
                    }
                } else {
                    ((RegularSpace)current).triggerEffect();
                }
            } else if ((movement > 0) && (current.getActivationType() == 'L')) { //land-on passed by
                continue;
            } else {
                System.out.println("Error");
                throw new IllegalActivationTypeException();
            }
            //Attack
            if (turnNumber > 2) {
                if (current.getActivator() != null) {
                    //Then allow to attack
                    // prompt for response
                    playerChar.attackEnemy(current.getActivator().getCharacter());

                }
            }
        }
        //Item 2
        itemPhase(performer);

        //Turn End
        //Decrement CD and duration of spells if casted
        //Need to remove buff of hero after duration is over to prevent ridiculous stacking of buffs
    }

    /**
     * Current player's item phase
     * @param performer 
     */
    public void itemPhase(Player performer) {
        Scanner s = new Scanner(System.in);
        Hero playerChar = performer.getCharacter();
        System.out.println("Spell(1), special(2), item(3), or cancel(0)");
        int choice = s.nextInt();
        if (choice == 1) {
            this.askForSpell(performer);
        } else if (choice == 2) {
            playerChar.triggerSpecial();
            if (playerChar instanceof Ninja) { //special instance
                //ask if forward or backward


                for (int i = 0; i < 3; i++) {
                    performer.move("f"); //can only move forward for now
                }

                for (int i = 0; i < orderedPlayers.length; i++) {
                    if (i != performer.getTurnOrder()) { //prevent comparing performer to itself
                        if (performer.getCurrentSpace() == orderedPlayers[i].getCurrentSpace()) {
                            playerChar.attackEnemy(orderedPlayers[i].getCharacter());
                            orderedPlayers[i].getCharacter().attackEnemy(playerChar);
                        }
                    }
                }
            }
        } else if (choice == 3) {
            this.askForItem(performer);
        } else if (choice == 0) {
            return;
        } else {
            System.out.println("Invalid Answer.");
        }
    }

    /**
     * Ask if "performer" wants to use a spell.
     * @param performer 
     */
    public void askForSpell(Player performer){
        Hero playerChar = performer.getCharacter();
        Scanner s = new Scanner(System.in);
        int spellCount = 0;
        List<Spell> mySpells;
        char yesOrNo;
        int mistakes = 0;
        while(true){
            System.out.println("Use spell('y' for yes, 'n' for no)?");
            yesOrNo = s.next().trim().charAt(0);
            if(yesOrNo == 'y'){
                mySpells = playerChar.getSpells();
                if(!(mySpells).isEmpty()){
                    for(Spell spell : mySpells){
                        spellCount++;
                        System.out.println(spellCount + ". " + spell.getMessage());
                    }
                    int choice = -1;
                    while((choice < 0) || (choice >= mySpells.size())){
                        System.out.println("Which spell would you like to use (0 to cancel)");
                        choice = s.nextInt();
                        
                        if(choice == 0){
                            return;
                        }else if ((choice > 0) && (choice <= mySpells.size())) {
                            Spell toBeUsed = mySpells.get(choice - 1);
                            if(toBeUsed instanceof SelfSpell) {
                                ((SelfSpell)toBeUsed).castSpell(playerChar);
                            } else {
                                boolean choosingOpponent = true;
                                String custName = performer.getCustomName();
                                while (choosingOpponent) {
                                    System.out.println(custName + ", select your victim: "); //Needs to loop if player typed in is not available
                                    String opponent = s.next();
                                    for (int i = 0; i < orderedPlayers.length; i++) {
                                        Player potVictim = orderedPlayers[i];
                                        if (opponent != null && !opponent.equals("")) {
                                            String oppTrim = opponent.trim();
                                            if ((oppTrim.equalsIgnoreCase(potVictim.getCustomName())) && (!oppTrim.equalsIgnoreCase(custName))) { //valid player found that is not "performer"
                                                choosingOpponent = false;
                                                ((AttackSpell)toBeUsed).castSpell(playerChar, potVictim.getCharacter());
                                                
                                                System.out.println(performer.getCustomName() + " cast " + toBeUsed.getClass().getSimpleName()+ " on " + potVictim.getCustomName());
                                                break;
                                            } else if (oppTrim.equalsIgnoreCase(custName)) { //player chooses to fight himself
                                                System.out.println( "You can't fight yourself unless you're in Fight Club.");
                                                break; //makes sure victim is not skipped if opponent's index comes before player's
                                            } else if (i == orderedPlayers.length - 1) { //input does not match any player's name
                                                System.out.println("No such player.");
                                            }
                                        } else {
                                            System.out.println( "Type something in!");
                                            break;
                                        }
                                    }
                                } 
                            }
                        } else {
                            System.out.println("Invalid Choice");
                        }
                    }
                }
                break;
            }else if(yesOrNo == 'n'){
                break;
            }else{
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
                    //End game
                    break;
                }
                mistakes++;
            }
        }
    }
    /**
     * Asks if "performer" wants to use an item
     *
     * @param performer
     */
    public void askForItem(Player performer) {
        Hero playerChar = performer.getCharacter();
        Scanner s = new Scanner(System.in);
        int itemCount = 0;
        List<Item> myItems;
        char yesOrNo;
        int mistakes = 0;
        while (true) {
            System.out.println("Use item ('y' for yes, 'n' for no)?");
            yesOrNo = s.next().trim().charAt(0);
            if (yesOrNo == 'y') {
                myItems = playerChar.getItems();
                if (!(myItems).isEmpty()) {
                    for (Item item : myItems) {
                        itemCount++;
                        System.out.println(itemCount + ". " + item.getMessage());
                    }
                    int choice = -1;
                    while ((choice < 0) || (choice > myItems.size())) {
                        System.out.println("Which item would you like to use/equip (0 for cancel)");
                        choice = s.nextInt();

                        if (choice == 0) {
                            return;
                        } else if ((choice > 0) && (choice <= myItems.size())) {
                            Item toBeUsed = myItems.get(choice - 1);
                            if (Equippable.class.isAssignableFrom(toBeUsed.getClass())) {
                                if (Weapon.class.isAssignableFrom(toBeUsed.getClass())) {
                                    if (playerChar.getWeaponEquipped()) {
                                        playerChar.getWeapon().dropWeap(playerChar);
                                    }

                                    ((Weapon) toBeUsed).equipWeap(playerChar);
                                } else if (Armor.class.isAssignableFrom(toBeUsed.getClass())) {
                                    if (playerChar.getArmorEquipped()) {
                                        playerChar.getArmor().dropArmor(playerChar);
                                    }

                                    ((Armor) toBeUsed).equipArmor(playerChar);
                                }
                            } else if (Item.class.isAssignableFrom(toBeUsed.getClass())) {
                            }
                        } else {
                            System.out.println("Invalid Choice.");
                        }
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
                    //End game
                    break;
                }
                mistakes++;
            }
        }
    }
}
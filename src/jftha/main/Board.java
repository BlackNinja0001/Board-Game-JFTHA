package jftha.main;

import jftha.spaces.*;

public class Board {

    public Space getStart() {
        return start;
    }

    public void setStart(Space start) {
        this.start = start;
    }

    public Space getEnd() {
        return end;
    }

    public void setEnd(Space end) {
        this.end = end;
    }

    private Space start;
    private Space end;

    public Board() {
        start = null;
        end = null;
    }

    /**
     * Takes in SpaceEnum class as a parameter.
     * Adds a space node using the Circle Linked List.
     * @param type 
     */
    public void addSpace(SpaceEnum type) {
        SpaceFactory factory = new SpaceFactory();
        Space newSpace = factory.buildItem(type);
        int i;
        //If the list is empty, this will create the first Space
        if (end == null) {
            newSpace.prev = newSpace;
            newSpace.next = newSpace;
            this.start = newSpace;
            this.end = newSpace;
            i = 1;
            newSpace.setSpaceID(i);
        } else {
            newSpace.next = end.next;
            newSpace.prev = end;
            end.next.prev = newSpace;
            end.next = newSpace;
            newSpace.setSpaceID(end.getSpaceID() + 1);
            this.end = newSpace;
        }
    }

    /**
     * Takes in an integer as a parameter.
     * Deletes the space node at index "index"
     * @param index 
     */
    public void deleteSpace(int index) {
        Space current = start;
        int ret = index;
        index -= 1;

        while (index > 0) {
            current = current.next;
            index--;
        }
        current.next = current.next.next;
    }

    public int iterator() {
        Space current = start;
        int num = 0;
        while (current.next != start) {
            num++;
            current = current.next;
        }
        return num;
    }

    /**
     * Test iterator to print the id and type of space.
     *
     */
    public void iterateBoard() {
        Space current = start;
        while (current.next != start) {
            if (current.getSpaceType() == SpaceEnum.Card) {
                System.out.printf("Space #%d: This space is a Card Space%n", current.getSpaceID());
            } else if (current.getSpaceType() == SpaceEnum.Chest) {
                System.out.printf("Space #%d: This space is a Chest Space%n", current.getSpaceID());
            } else if (current.getSpaceType() == SpaceEnum.D2D) {
                System.out.printf("Space #%d: This space is a Duel to the Death Space%n", current.getSpaceID());
            } else if (current.getSpaceType() == SpaceEnum.Gold) {
                System.out.printf("Space #%d: This space is a Gold Space%n", current.getSpaceID());
            } else if (current.getSpaceType() == SpaceEnum.Health) {
                System.out.printf("Space #%d: This space is a Health Space%n", current.getSpaceID());
            } else if (current.getSpaceType() == SpaceEnum.Store) {
                System.out.printf("Space #%d: This space is a Store Space%n", current.getSpaceID());
            } else if (current.getSpaceType() == SpaceEnum.Blank) {
                System.out.printf("Space #%d: This space is a Blank Space%n", current.getSpaceID());
            } else if (current.getSpaceType() == SpaceEnum.Bank) {
                System.out.printf("Space #%d: This space is a Bank Space%n", current.getSpaceID());
            } else if (current.getSpaceType() == SpaceEnum.Monster) {
                System.out.printf("Space #%d: This space is a Monster space%n", current.getSpaceID());
            }
            current = current.next;
        }
    }

    /**
     * Takes in an integer as a parameter.
     * Uses addSpace method to create a Circle Linked List.
     * numSpaces = number of spaces this method will generate.
     * @param numSpaces 
     */
    public void generateBoard(int numSpaces) {

        for (int i = 0; i < numSpaces; i++) {
            if (i == 2) {
                addSpace(SpaceEnum.Store);
            } else if (i == 4) {
                addSpace(SpaceEnum.Chest);
            } else if (i == 6) {
                addSpace(SpaceEnum.D2D);
            } else if (i == 8) {
                addSpace(SpaceEnum.Gold);
            } else if (i == 10) {
                addSpace(SpaceEnum.Health);
            } else if (i == 12) {
                addSpace(SpaceEnum.Card);
            } else if (i == 14) {
                addSpace(SpaceEnum.Monster);
            } else if (i == 16) {
                addSpace(SpaceEnum.Gold);
            } else {
                addSpace(SpaceEnum.Blank);
            }
        }
    }

    /** Places the players an equal distance apart from each other at the start
     * of the game.
     * 
     * @param players An array of the players in the game
     * @param numSpaces The number of spaces on the board
     */
    public void placePlayers(Player players[], int numSpaces) {
        Space current = start.next;
        int distance = numSpaces / players.length;
        int count = 2, i = 0;
        while (current != start) {
            if (count % distance == 0) {
                //spawn player
                players[i].setCurrentSpace(current);
                i++;
            }
            count++;
            current = current.next;
        }
    }
}

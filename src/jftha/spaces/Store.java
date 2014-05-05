package jftha.spaces;

import java.awt.Component;
import java.util.*;
import javax.swing.JOptionPane;
import jftha.heroes.*;
import jftha.items.*;
import jftha.main.Player;

public class Store extends RegularSpace {

    /**
     * Constructor
     */
    public Store() {
        this.setActivationType('p');
        this.setSpaceType(SpaceEnum.Store);
    }

    /**
     * Generates 5 random items(base on current player's luck). Lets current
     * player choose which item to buy.
     */
    @Override
    public void triggerEffect() {
        Player p = getActivator();
        Hero hero = p.getCharacter();
        System.out.println("You have " + hero.getGold() + " gold");

        Random rand = new Random(System.currentTimeMillis());
        int luck;
        ItemFactory factory = new ItemFactory();
        ArrayList<Item> items = new ArrayList<>();

        while (items.size() < 5) {
            boolean shouldAdd = true;
            luck = rand.nextInt(100) + 1 + hero.getLuck();
            Item temp;
            if (luck > 90) {
                temp = factory.buildItem(RarityEnum.rare);
            } else if (luck > 75) {
                temp = factory.buildItem(RarityEnum.uncommon);
            } else {
                temp = factory.buildItem(RarityEnum.common);
            }
            for (Item k : items) {
                if (temp.getClass().equals(k.getClass())) {
                    shouldAdd = false;
                }
            }
            if (shouldAdd) {
                items.add(temp);
            }
        }

        for (int j = 0; j < 5; j++) {
            String item = items.get(j).toString();
            System.out.println("Input " + (j + 1) + " to buy " + item + ". Cost " + items.get(j).getGoldCost() + " gold");
        }

        System.out.println("Input 6 to choose not to buy");
        Scanner scan = new Scanner(System.in);
        int select = scan.nextInt();
        boolean res;

        if ((select >= 1) && (select < 6)) {
            res = hero.buy(items.get(select - 1));
            if (res) {
                System.out.println("You bought a " + items.get(select - 1).toString());
                System.out.println("You have " + hero.getGold() + " gold left");
            } else {
                System.out.println("You don't have enough gold");
                System.out.println("You still have " + hero.getGold() + " gold");
            }
        } else if (select == 6) {
            System.out.println("You chose not to buy anything");
        } else {
            throw new IllegalArgumentException("Error: Did not select an option");
        }
    }

    /**
     * Generates 5 random items(base on current player's luck). Lets current
     * player choose which item to buy. Very similar to triggerEffect() except
     * this has a Component parameter
     *
     * @param rootPane Used as parameter for JOptionPane
     */
    public StringBuilder triggerEffectGUI(Component rootPane) {
        StringBuilder sb = new StringBuilder();
        Player p = getActivator();
        Hero hero = p.getCharacter();
        ArrayList<Item> items = new ArrayList<>();

        //Scanner scan = new Scanner(System.in);
        int select = -1;
        while (true) { //will break for correct input
            select = askForInput(rootPane, p, items);
            if ((select >= 0) && (select < 6)) { //0-6
                boolean res;

                //while (true) { //will break for correct input
                if ((select >= 1) && (select < 6)) { //1-6, valid choice given
                    res = hero.buy(items.get(select - 1));
                    if (res) {
                        sb.append(p.getCustomName()).append(" has bought a ")
                                .append(items.get(select - 1).toString() + ".\n");
                        sb.append(p.getCustomName() + " has ").append(hero.getGold()).append(" gold left.\n");
                        break;
                    } else {
                        JOptionPane.showMessageDialog(rootPane, p.getCustomName() + ", you don't have enough gold.\n"
                                + "You still have " + hero.getGold() + " gold.");
                    }
                } else { //0
                    sb.append(p.getCustomName()).append(" has chosen not to buy anything\n");
                    break;
                }
                //} //old while
            } else {
                //IllegalArgumentException
                JOptionPane.showMessageDialog(rootPane, "Error: Did not select an option");
            }
        }
        return sb;
    }

    private int askForInput(Component rootPane, Player p, ArrayList<Item> items) {
        StringBuilder sb = new StringBuilder();
        Hero hero = p.getCharacter();
        sb.append(p.getCustomName()).append(", you have ").append(hero.getGold())
                .append(" gold\n");
        Random rand = new Random(System.currentTimeMillis());
        int luck;
        ItemFactory factory = new ItemFactory();

        while (items.size() < 5) {
            boolean shouldAdd = true;
            luck = rand.nextInt(100) + 1 + hero.getLuck();
            Item temp;
            if (luck > 90) {
                temp = factory.buildItem(RarityEnum.rare);
            } else if (luck > 75) {
                temp = factory.buildItem(RarityEnum.uncommon);
            } else {
                temp = factory.buildItem(RarityEnum.common);
            }
            for (Item k : items) {
                if (temp.getClass().equals(k.getClass())) {
                    shouldAdd = false;
                }
            }
            if (shouldAdd) {
                items.add(temp);
            }
        }

        for (int j = 0; j < 5; j++) {
            String item = items.get(j).toString();
            sb.append("Input ").append(j + 1).append(" to buy ").append(item)
                    .append(". Cost ").append(items.get(j).getGoldCost())
                    .append(" gold\n");
        }
        sb.append("Input 0 to choose not to buy anything.\n");
        int select = -1;
        try {
            select = Integer.parseInt(JOptionPane.showInputDialog(rootPane, sb.toString()));
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(rootPane, "Invalid selection: " + e.getMessage());
        }
        return select;
    }
}

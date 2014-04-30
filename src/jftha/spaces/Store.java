package jftha.spaces;

import java.awt.Component;
import java.util.*;
import javax.swing.JOptionPane;
import jftha.heroes.*;
import jftha.items.*;
import jftha.main.Player;

public class Store extends Space {

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
     * this has a StringBuilder parameter
     *
     * @param sb Used to print to GUI
     */
    public StringBuilder triggerEffect(Component rootPane, StringBuilder sb) {
        Player p = getActivator();
        Hero hero = p.getCharacter();
        sb = new StringBuilder();
        ArrayList<Item> items = new ArrayList<>();
        sb.append(p.getCustomName()).append(", you have ").append(hero.getGold())
                .append(" gold\n");
        
        askForInput(hero, items, sb);
        
        //Scanner scan = new Scanner(System.in);
        String s = JOptionPane.showInputDialog(null, sb.toString());
        sb = new StringBuilder(); //erases old dialog
        int select;
        if ((s != null) && (!s.equals(""))) {
            try {
                select = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                sb.append("Not a valid response.\n");
                return sb;
            }
            boolean res;

            while (true) { //will break for correct input
                if ((select >= 1) && (select < 6)) {
                    res = hero.buy(items.get(select - 1));
                    if (res) {
                        sb.append(p.getCustomName()).append(" has bought a ")
                                .append(items.get(select - 1).toString() + ".\n");
                        sb.append(p.getCustomName() + " has ").append(hero.getGold()).append(" gold left.\n");
                        break;
                    } else {
                        JOptionPane.showMessageDialog(rootPane, p.getCustomName() + ", you don't have enough gold.\n" + 
                                "You still have " + hero.getGold() + " gold.");
                        askForInput(hero, items, sb);
                    }
                } else {
                    //IllegalArgumentException
                    JOptionPane.showMessageDialog(rootPane, "Error: Did not select an option");
                    askForInput(hero, items, sb);
                }
            }
        } else {
            sb.append(p.getCustomName()).append(" has chosen not to buy anything\n");
        }
        return sb;
    }
    
    public void askForInput (Hero hero, ArrayList<Item> items, StringBuilder sb){
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
    }

    /**
     * No Effect
     *
     * @param affected
     */
    @Override
    public void triggerEffect(Player affected) {
    }
}

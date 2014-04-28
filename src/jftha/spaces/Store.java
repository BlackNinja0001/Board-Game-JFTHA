package jftha.spaces;

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
        StringBuilder sb = new StringBuilder();
        sb.append("You have " + hero.getGold() + " gold\n");

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
            sb.append("Input " + (j + 1) + " to buy " + item + ". Cost " + items.get(j).getGoldCost() + " gold\n");
        }
        //Scanner scan = new Scanner(System.in);
        String s = JOptionPane.showInputDialog(null, sb.toString());
        int select = -1;
        if (s != null) {
            select = Integer.parseInt(s);

            boolean crap;
            sb = new StringBuilder();//erases old dialog

            if ((select >= 1) && (select < 6)) {
                crap = hero.buy(items.get(select - 1));
                if (crap) {
                    sb.append(p.getCustomName() + " has bought a " + items.get(select - 1).toString());
                    sb.append("You have " + hero.getGold() + " gold left");
                } else {
                    sb.append("You don't have enough gold");
                    sb.append("You still have " + hero.getGold() + " gold");
                }
            } else if (s.equals("")) {
                System.out.println("You chose not to buy anything");
            } else {
                throw new IllegalArgumentException("Error: Did not select an option");
            }
        }
    }

    /**
     * Generates 5 random items(base on current player's luck). Lets current
     * player choose which item to buy. Very similar to triggerEffect() except
     * this has a StringBuilder parameter
     *
     * @param StringBuilder sb Used to print to GUI
     */
    public void triggerEffect(StringBuilder sb) {
        Player p = getActivator();
        Hero hero = p.getCharacter();
        sb = new StringBuilder();
        sb.append("You have " + hero.getGold() + " gold\n");

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
            sb.append("Input " + (j + 1) + " to buy " + item + ". Cost " + items.get(j).getGoldCost() + " gold\n");
        }
        //Scanner scan = new Scanner(System.in);
        String s = JOptionPane.showInputDialog(null, sb.toString());
        int select = -1;
        if (s != null) {
            select = Integer.parseInt(s);

            boolean crap;
            sb = new StringBuilder();//erases old dialog

            if ((select >= 1) && (select < 6)) {
                crap = hero.buy(items.get(select - 1));
                if (crap) {
                    sb.append(p.getCustomName() + " has bought a " + items.get(select - 1).toString());
                    sb.append("You have " + hero.getGold() + " gold left");
                } else {
                    sb.append("You don't have enough gold");
                    sb.append("You still have " + hero.getGold() + " gold");
                }
            } else if (s.equals("")) {
                System.out.println("You chose not to buy anything");
            } else {
                throw new IllegalArgumentException("Error: Did not select an option");
            }
        }
    }

    /**
     * No Effect
     *
     * @param affected
     */
    @Override
    public void triggerEffect(Player affected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

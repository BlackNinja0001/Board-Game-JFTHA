package jftha.spaces;

import java.util.*;
import jftha.main.Player;
import jftha.heroes.*;
import jftha.items.*;

public class Store extends Space{
    
    public Store(){
        this.setActivationType('p');
        this.setSpaceType(SpaceEnum.Store);
    }
        
    /**
     *
     */
    @Override
    public void triggerEffect() {
        Hero hero = this.getActivator();
        System.out.println("You have " + hero.getGold() + " gold");
        
        Random rand = new Random(System.currentTimeMillis());
        int luck;
        ItemFactory factory = new ItemFactory();
        ArrayList<Item> items = new ArrayList<>();
        
        while (items.size() < 5){
            boolean shouldAdd = true;
            luck = rand.nextInt(100) + 1 + hero.getLuck();
            Item temp;
            if(luck > 90){
                temp = factory.buildItem(RarityEnum.rare);
            } else if(luck > 75){
                temp = factory.buildItem(RarityEnum.uncommon);
            } else{
                temp = factory.buildItem(RarityEnum.common);
            }
            for(Item k : items) {
                if(temp.getClass().equals(k.getClass())) {
                    shouldAdd = false;
                }
            }
            if(shouldAdd){
                items.add(temp);
            }
        }
        
        for (int j = 0; j < 5; j++) {
            String item = items.get(j).toString();
            System.out.println("Input " + (j+1) + " to buy " + item + ". Cost " + items.get(j).getGoldCost() + " gold");
        }
        
        System.out.println("Input 6 to choose not to buy");
        Scanner scan = new Scanner(System.in);
        int select = scan.nextInt();
        switch (select) {
            case 1:
                hero.buy(items.get(select-1));
                        System.out.println("You bought a " + items.get(select-1).toString());
                        System.out.println("You have " + hero.getGold() + " gold left");
                break;
            case 2:
                hero.buy(items.get(select-1));
                System.out.println("You bought a " + items.get(select-1).toString());
                System.out.println("You have " + hero.getGold() + " gold left");
                break;
            case 3:
                hero.buy(items.get(select-1));
                System.out.println("You bought a " + items.get(select-1).toString());
                System.out.println("You have " + hero.getGold() + " gold left");
                break;
            case 4:
                hero.buy(items.get(select-1));
                System.out.println("You bought a " + items.get(select-1).toString());
                System.out.println("You have " + hero.getGold() + " gold left");
                break;
            case 5:
                hero.buy(items.get(select-1));
                System.out.println("You bought a " + items.get(select-1).toString());
                System.out.println("You have " + hero.getGold() + " gold left");
                break;
            case 6:
                System.out.println("You chose not to buy anything");
                break;
            default:
                throw new IllegalArgumentException("Error: Did not select an option");
            }
    }

    @Override
    public void triggerEffect(Hero affected) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

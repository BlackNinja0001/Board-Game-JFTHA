package jftha.spaces;

import java.util.*;
import jftha.heroes.*;
import jftha.items.*;

public class Store extends Space{
    
    public Store(){
        this.setActivationType('p');
    }
    
    //this method is for testing purposes
    public void buyTest(){
        Hero h = getActivator();

        ItemFactory i = new ItemFactory();
        ArrayList<Item> items = new ArrayList<>(5);
        AnimalSkin as = new AnimalSkin();
        Ax ax = new Ax();
        Bible bible = new Bible();
        SuitOfArmor soa = new SuitOfArmor();
        Tuxedo tux = new Tuxedo();
        
        items.add(as);
        items.add(ax);
        items.add(bible);
        items.add(soa);
        items.add(tux);
            
        for(int j = 0; j < 5; j++){
            String item = items.get(j).toString();
            System.out.println("Input " + (j+1) + "to buy " + item);
        }

        System.out.println("Input 6 to choose not to buy");
        Scanner scan = new Scanner(System.in);
        int select = scan.nextInt();
        switch (select) {
                case 1:
                    h.buy(items.get(0));
                    break;
                case 2:
                    h.buy(items.get(1));
                    break;
                case 3:
                    h.buy(items.get(2));
                    break;
                case 4:
                    h.buy(items.get(3));
                    break;
                case 5:
                    h.buy(items.get(4));
                    break;
                case 6:
                    System.out.println("You chose not to buy anything");
                    break;
                default:
                    System.out.println("Error: Did not select an option");
            }
    }
    
    public void buy(){
        Hero h = getActivator();
        
        Random rand = new Random(System.currentTimeMillis());
        int luck;
        ItemFactory i = new ItemFactory();
        ArrayList<Item> items = new ArrayList<>(5);
        for(int j = 0; j < 5; j++){
            luck = rand.nextInt(100) + 1 + h.getLuck();
            if(luck > 90){
                items.add(i.buildItem(RarityEnum.rare));
                String item = items.get(j).toString();
                System.out.println("Input " + (j+1) + "to buy " + item);
            }else if(luck > 75){
                items.add(i.buildItem(RarityEnum.uncommon));
                String item = items.get(j).toString();
                System.out.println("Input " + (j+1) + "to buy " + item);
            }else{
                items.add(i.buildItem(RarityEnum.common));
                String item = items.get(j).toString();
                System.out.println("Input " + (j+1) + "to buy " + item);
            }
        }
        System.out.println("Input 6 to choose not to buy");
        Scanner scan = new Scanner(System.in);
        int select = scan.nextInt();
        switch (select) {
                case 1:
                    h.buy(items.get(0));
                    break;
                case 2:
                    h.buy(items.get(1));
                    break;
                case 3:
                    h.buy(items.get(2));
                    break;
                case 4:
                    h.buy(items.get(3));
                    break;
                case 5:
                    h.buy(items.get(4));
                    break;
                case 6:
                    System.out.println("You chose not to buy anything");
                    break;
                default:
                    System.out.println("Error: Did not select an option");
            }
    }
    /**
     *
     * @param hero
     */
    public void buy(Hero hero){
        hero = getActivator();
        
        Random rand = new Random(System.currentTimeMillis());
        int luck;
        ItemFactory i = new ItemFactory();
        ArrayList<Item> items = new ArrayList<>(5);
        for(int j = 0; j < 5; j++){
            luck = rand.nextInt(100) + 1 + hero.getLuck();
            if(luck > 90){
                items.add(i.buildItem(RarityEnum.rare));
                String item = items.get(j).toString();
                System.out.println("Input " + (j+1) + "to buy " + item);
            }else if(luck > 75){
                items.add(i.buildItem(RarityEnum.uncommon));
                String item = items.get(j).toString();
                System.out.println("Input " + (j+1) + "to buy " + item);
            }else{
                items.add(i.buildItem(RarityEnum.common));
                String item = items.get(j).toString();
                System.out.println("Input " + (j+1) + "to buy " + item);
            }
        }
        System.out.println("Input 6 to choose not to buy");
        Scanner scan = new Scanner(System.in);
        int select = scan.nextInt();
        switch (select) {
                case 1:
                    hero.buy(items.get(0));
                    break;
                case 2:
                    hero.buy(items.get(1));
                    break;
                case 3:
                    hero.buy(items.get(2));
                    break;
                case 4:
                    hero.buy(items.get(3));
                    break;
                case 5:
                    hero.buy(items.get(4));
                    break;
                case 6:
                    System.out.println("You chose not to buy anything");
                    break;
                default:
                    System.out.println("Error: Did not select an option");
            }
    }
}

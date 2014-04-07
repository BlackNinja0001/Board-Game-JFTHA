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
    
    /*Add in if hero's items/spells are full ask which one to replace and use
     * replaceItem/replaceSpell in Hero
     */
        
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
                throw new IllegalArgumentException("Error: Did not select an option");
            }
    }
    /**
     *
     */
    @Override
    public void triggerEffect() {
        Hero hero = this.getActivator();
        
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
            System.out.println("Input " + (j+1) + " to buy " + item);
        }
        
        System.out.println("Input 6 to choose not to buy");
        Scanner scan = new Scanner(System.in);
        int select = scan.nextInt();
        switch (select) {
            case 1:
                hero.buy(items.get(select-1));
                System.out.println("You bought a " + items.get(select-1).toString());
                break;
            case 2:
                hero.buy(items.get(select-1));
                System.out.println("You bought a " + items.get(select-1).toString());
                break;
            case 3:
                hero.buy(items.get(select-1));
                System.out.println("You bought a " + items.get(select-1).toString());
                break;
            case 4:
                hero.buy(items.get(select-1));
                System.out.println("You bought a " + items.get(select-1).toString());
                break;
            case 5:
                hero.buy(items.get(select-1));
                System.out.println("You bought a " + items.get(select-1).toString());
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

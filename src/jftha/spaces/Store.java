package jftha.spaces;

import java.util.*;
import jftha.heroes.*;
import jftha.items.*;

public class Store extends Space{
    
    public Store(){
        this.setActivationType('p');
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
                    System.out.println("Error: Did not select an option");
            }
    }
}

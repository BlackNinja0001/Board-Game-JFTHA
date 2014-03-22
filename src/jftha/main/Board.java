package jftha.main;

import jftha.spaces.*;
import jftha.heroes.*;

public class Board {
    Space start;
    Space end;
    int i = 0;
    
    public Board(){
        start = null;
        end = null;
    }
    
    public void addSpace(int inSpaceID, Effect inEffect, char inActivationType, Hero inActivater){
        Space newSpace = new Space(inSpaceID, inEffect, inActivationType, inActivater);
        
        //If the list is empty, this will create the first Space
        if(start == end){
            newSpace.prev = start;
            newSpace.next = end;
            start = newSpace;
            end = newSpace;         
        }else{
            Space current = end;
            
            newSpace.prev = current;
            newSpace.next = null;
            current.next = newSpace;
            end = newSpace;
        }
    }
    
    //addSpace for testing purposes
    //can leave it or remove later
    public void addSpace(int inSpaceID, boolean inIsChest, boolean inIsStore, boolean inIsD2D, boolean inIsHealth, boolean inIsCard){
        Space newSpace = new Space(inSpaceID, inIsChest, inIsStore, inIsD2D, inIsHealth, inIsCard);
        
        //If the list is empty, this will create the first Space
        if(start == end){
            newSpace.prev = start;
            newSpace.next = end;
            start = newSpace;
            end = newSpace;         
        }else{
            Space current = end;
            
            newSpace.prev = current;
            newSpace.next = null;
            current.next = newSpace;
            end = newSpace;
        }
    }
    
    public void deleteSpace(int index){
        Space current = start;
        int ret = index;
        index -= 1;
        
        while(index > 0){
            current = current.next;
            index--;
        }
        current.next = current.next.next;
    }
    
    public int iterator(){
        Space current = start;
        int num = 0;
        while(current.next != null){
            num++;
            
            current = current.next;
        }
        return num;
    }
    
    //Test iterator to check if the space location is one of the 5 main spaces
    //Chest, Store, D2D, Health, or Card, otherwise will just print out the spaceID
    public void iterateBoard(){
        Space current = start;
        while(current.next != null){
            if(current.getIsCard() == true){
                System.out.println("This space is a Card Space");
            }else if(current.getIsChest() == true){
                System.out.println("This space is a Chest Space");
            }else if(current.getIsD2D() == true){
                System.out.println("This space is a D2D Space");
            }else if(current.getIsHealth() == true){
                System.out.println("This space is a Health Space");
            }else if(current.getIsStore() == true){
                System.out.println("This space is a Store Space");
            }else{
                System.out.println("Current Location is " + current.getSpaceID());
            }
            current = current.next;
        }
    }
}

package jftha.main;

import jftha.spaces.*;

public class Board {
    Space start;
    Space end;
    
    public Board(){
        start = null;
        end = null;
    }
    
    public void addSpace(SpaceEnum type){
        SpaceFactory factory = new SpaceFactory();
        Space newSpace = factory.buildItem(type);
        int i;
        //If the list is empty, this will create the first Space
        if(end == null){
            newSpace.prev = newSpace;
            newSpace.next = newSpace;
            this.start = newSpace;
            this.end = newSpace;
            i = 1;
            newSpace.setSpaceID(i);
        }else{
            newSpace.next = end.next; 
            newSpace.prev = end;
            end.next.prev = newSpace;
            end.next = newSpace;
            newSpace.setSpaceID(end.getSpaceID() + 1);
            this.end = newSpace;
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
        while(current.next != start){
            num++;
            current = current.next;
        }
        return num;
    }
    
    /** Test iterator to print the id and type of space.
     * 
     */
    public void iterateBoard(){
        Space current = start;
        while(current.next != start){
            if(current.getSpaceType() == SpaceEnum.Card){
                System.out.printf("Space #%d: This space is a Card Space%n", current.getSpaceID());
            } else if(current.getSpaceType() == SpaceEnum.Chest){
                System.out.printf("Space #%d: This space is a Chest Space%n", current.getSpaceID());
            } else if(current.getSpaceType() == SpaceEnum.D2D){
                System.out.printf("Space #%d: This space is a Duel to the Death Space%n", current.getSpaceID());
            } else if (current.getSpaceType() == SpaceEnum.Gold) {
                System.out.printf("Space #%d: This space is a Gold Space%n", current.getSpaceID());
            } else if(current.getSpaceType() == SpaceEnum.Health){
                System.out.printf("Space #%d: This space is a Health Space%n", current.getSpaceID());
            } else if(current.getSpaceType() == SpaceEnum.Store){
                System.out.printf("Space #%d: This space is a Store Space%n", current.getSpaceID());
            } else if(current.getSpaceType() == SpaceEnum.Blank){
                System.out.printf("Space #%d: This space is a Blank Space%n", current.getSpaceID());
            } else if(current.getSpaceType() == SpaceEnum.Bank){
                System.out.printf("Space #%d: This space is a Bank Space%n", current.getSpaceID());
            } else if(current.getSpaceType() == SpaceEnum.Monster){
                System.out.printf("Space #%d: This space is a Monster space%n", current.getSpaceID());
            }
            current = current.next;
        }
    }
}

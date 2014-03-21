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
    //create double linked list of spaces
    //create what each spaces is
}

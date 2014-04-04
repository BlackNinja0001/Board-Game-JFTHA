/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jftha.heroes;

import jftha.items.Cloak;
import jftha.items.Dagger;

public class Ninja extends Hero{
    
    //Constructor
    public Ninja(){
        this.setAgility(super.getAgility() + 2);
        this.setDefense(super.getDefense() - 2);
        this.addItem(new Cloak());
        this.addItem(new Dagger());
        this.setClassName("Ninja");
    }
}

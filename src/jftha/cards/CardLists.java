/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jftha.cards;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tue75856
 */
public class CardLists {
    private List<Class> commonClasses = new ArrayList<>();
    private List<Class> uncommonClasses = new ArrayList<>();
    private List<Class> rareClasses = new ArrayList<>();
    private List<Class> veryRareClasses = new ArrayList<>();
    private List<Class> almostImpossibleClasses = new ArrayList<>();
    
    public int getCommonSize() {
        return commonClasses.size();
    }
    public Class getCommonClass(int i) {
        return commonClasses.get(i);
    }
    
    public int getUncommonSize() {
        return uncommonClasses.size();
    }
    public Class getUncommonClass(int i) {
        return uncommonClasses.get(i);
    }
    
    public int getRareSize() {
        return rareClasses.size();
    }
    public Class getRareClass(int i) {
        return rareClasses.get(i);
    }
    
    public int getVeryRareSize() {
        return veryRareClasses.size();
    }
    
    public Class getVeryRareClass(int i) {
        return veryRareClasses.get(i);
    }
    
    public int getAlmostImpossibleSize() {
        return almostImpossibleClasses.size();
    }
    public Class getAlmostImpossibleClass(int i) {
        return almostImpossibleClasses.get(i);
    }
    
    public CardLists() {
        commonClasses.add(FreeGold.class);
        commonClasses.add(FreeCommonItem.class);
        uncommonClasses.add(MPDrain.class);
        uncommonClasses.add(RandomDamage.class);
        uncommonClasses.add(StealGold.class);
        uncommonClasses.add(Tax.class);
        rareClasses.add(RestoreAll.class);
        rareClasses.add(RestoreHP.class);
        rareClasses.add(RestoreMP.class);
        rareClasses.add(MoveBack.class);
        veryRareClasses.add(Revive.class);
        almostImpossibleClasses.add(InstantDeath.class);
        almostImpossibleClasses.add(FreeRareItem.class);
    }
}

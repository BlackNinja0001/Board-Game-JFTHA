/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jftha.cards;

import java.util.ArrayList;
import java.util.List;
import jftha.items.AnimalSkin;
import jftha.items.ArtifactPiece1;
import jftha.items.ArtifactPiece2;
import jftha.items.ArtifactPiece3;
import jftha.items.ArtifactPiece4;
import jftha.items.ArtifactPiece5;
import jftha.items.Ax;
import jftha.items.Bible;
import jftha.items.Chasuble;
import jftha.items.Cloak;
import jftha.items.Dagger;
import jftha.items.DivineBlade;
import jftha.items.FastHands;
import jftha.items.IronSword;
import jftha.items.MageRobe;
import jftha.items.ShiningArmor;
import jftha.items.SpellBook;
import jftha.items.SuitOfArmor;
import jftha.items.Tuxedo;
import jftha.items.UncommonItem;
import jftha.items.WagonOfGoods;
import jftha.items.WoolClothing;

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
        uncommonClasses.add(MPDrain.class);
        uncommonClasses.add(RandomDamage.class);
        uncommonClasses.add(StealGold.class);
        almostImpossibleClasses.add(InstantDeath.class);
    }
}

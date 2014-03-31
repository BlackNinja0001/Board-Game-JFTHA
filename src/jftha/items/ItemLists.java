package jftha.items;

import java.util.ArrayList;
import java.util.List;

public class ItemLists {
    private List<Class> commonClasses = new ArrayList<>();
    private List<Class> uncommonClasses = new ArrayList<>();
    private List<Class> rareClasses = new ArrayList<>();
    
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
        return commonClasses.size();
    }
    public Class getRareClass(int i) {
        return commonClasses.get(i);
    }
    
    public ItemLists() {
        commonClasses.add(AnimalSkin.class);
        commonClasses.add(Ax.class);
        commonClasses.add(Bible.class);
        commonClasses.add(Chasuble.class);
        commonClasses.add(Cloak.class);
        commonClasses.add(Dagger.class);
        commonClasses.add(DivineBlade.class);
        commonClasses.add(FastHands.class);
        commonClasses.add(IronSword.class);
        commonClasses.add(MageRobe.class);
        commonClasses.add(ShiningArmor.class);
        commonClasses.add(SpellBook.class);
        commonClasses.add(SuitOfArmor.class);
        commonClasses.add(Tuxedo.class);
        commonClasses.add(WagonOfGoods.class);
        commonClasses.add(WoolClothing.class);
        uncommonClasses.add(UncommonItem.class);
        rareClasses.add(ArtifactPiece1.class);
        rareClasses.add(ArtifactPiece2.class);
        rareClasses.add(ArtifactPiece3.class);
        rareClasses.add(ArtifactPiece4.class);
        rareClasses.add(ArtifactPiece5.class);
    }
}

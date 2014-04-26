package jftha.items;

import java.util.ArrayList;
import java.util.List;

public class ItemLists {
    private final List<Class> commonClasses = new ArrayList<>();
    private final List<Class> uncommonClasses = new ArrayList<>();
    private final List<Class> rareClasses = new ArrayList<>();
    
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
    
    public ItemLists() {
        commonClasses.add(AnimalSkin.class);
        commonClasses.add(Ax.class);
        commonClasses.add(Bible.class);
//        commonClasses.add(Chasuble.class);
        commonClasses.add(Cloak.class);
        commonClasses.add(Dagger.class);
        commonClasses.add(DivineBlade.class);
        commonClasses.add(Ether.class);
//        commonClasses.add(FastHands.class);
        commonClasses.add(IronSword.class);
        commonClasses.add(MageRobe.class);
        commonClasses.add(Potion.class);
        commonClasses.add(SpellBook.class);
//        commonClasses.add(Tuxedo.class);
//        commonClasses.add(WagonOfGoods.class);
//        commonClasses.add(WoolClothing.class);
        commonClasses.add(MageStaff.class);
        commonClasses.add(SuitOfArmor.class);
        uncommonClasses.add(HiEther.class);
        uncommonClasses.add(HiPotion.class);
        uncommonClasses.add(ShiningArmor.class);
        rareClasses.add(Elixir.class);
        rareClasses.add(Goldskin.class);
        rareClasses.add(SwordOf1000Truth.class);
        rareClasses.add(ArtifactPiece1.class);
        rareClasses.add(ArtifactPiece2.class);
        rareClasses.add(ArtifactPiece3.class);
        rareClasses.add(ArtifactPiece4.class);
        rareClasses.add(ArtifactPiece5.class);
    }
}

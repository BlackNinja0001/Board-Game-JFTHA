package jftha.spaces;

public class SpaceFactory {
    public Space buildItem(SpaceEnum type) {
        Space space = null;
        switch(type) {
            case Chest:
                space = new Chest();
                break;
            case D2D:
                space = new D2D();
                break;
            case Gold:
                space = new Gold();
                break;
            case Health:
                space = new Health();
                break;
            case Store:
                space = new Store();
                break;
            case Card:
                space = new CardSpace();
                break;
            case Bank:
                space = new Bank();
                break;
            case Blank:
                space = new BlankSpace();
                break;
            default:
                throw new IllegalActivationTypeException("Oops. There is no such type of space.");
        }
        return space;
    }
}

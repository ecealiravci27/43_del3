package Model;

public class Property {
    boolean[] ownedProperties;

    public boolean isOwned(int id){
        return ownedProperties[id];
    }

    public boolean buyProperty(int id){
        if (isOwned(id)) {
            return false;
        }

        return ownedProperties[id];
    }

}

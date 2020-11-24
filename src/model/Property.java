package model;

public class Property {
    int[] ownedProperties;

    public int isOwned(int id){
        return ownedProperties[id];
    }

    public boolean buyProperty(int id){
        if (isOwned(id)) {
            return false;
        }

        return ownedProperties[id];
    }
}
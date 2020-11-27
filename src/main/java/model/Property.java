package model;

public class Property {
    int[] ownedProperties;

    public Property() {
        this.ownedProperties = new int[]{5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5};
    }

    public boolean isOwned(int id) {
        if (ownedProperties[id] == 0) {
            return true;
        }
        if (ownedProperties[id] == 1) {
            return true;
        }
        if (ownedProperties[id] == 2) {
            return true;
        }
        if (ownedProperties[id] == 3) {
            return true;
        }
        if (ownedProperties[id] == 5) {
            return false;
        }
        return false;
    }
    public void buy(int field, int playertype){
        ownedProperties[field] = playertype;
    }
    public int getOwner (int fieldIndex){
        return ownedProperties[fieldIndex];
    }


}
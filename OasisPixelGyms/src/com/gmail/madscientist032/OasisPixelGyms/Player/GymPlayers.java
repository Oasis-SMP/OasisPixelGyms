package com.gmail.madscientist032.OasisPixelGyms.Player;

public abstract class GymPlayers {

    public abstract String getName(); // returns player name
    
    public abstract boolean hasGroup(String group);
    
    public abstract String[] getGroups();
    
    public abstract boolean hasPermission(String perm);
    
    @Override
    public boolean equals(Object obj) {

        return obj instanceof GymPlayers && ((GymPlayers) obj).getName().equals(getName());

    }
    
    @Override
    public int hashCode() {
        return getName().hashCode();
    }
}

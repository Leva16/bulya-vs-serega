package com.test;

/**
 * Created by leva on 5/7/15.
 */
public class Dota {
    private String name;
    private String faction;
    int strength;
    int agility;
    int intellect;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaction() {
        return faction;
    }

    public void setFaction(String faction) {
        this.faction = faction;
    }


}

class AttributDota extends Dota {
    String attribut;


    AttributDota(int s, int a, int i, String at) {
        strength = s;
        agility = a;
        intellect = i;
        attribut = at;
    }

}

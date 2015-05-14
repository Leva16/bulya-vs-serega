package com.test;

/**
 * Created by leva on 5/14/15.
 */
public class Hero {

    private String name;
    private int life;
    private int mana;

    public Hero(String name, int life, int mana) {
        this.name = name;
        this.life = life;
        this.mana = mana;
    }

    public Hero() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public void hit(int damage) {
        this.life = this.life - damage;
    }
}

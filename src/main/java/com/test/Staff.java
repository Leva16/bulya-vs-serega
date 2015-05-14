package com.test;

/**
 * Created by leva on 5/14/15.
 */
public class Staff extends Weapon {
    private int magicalDamage;
    private int castTime;
    private int manaCostPerCast;

    public int getMagicalDamage() {
        return magicalDamage;
    }

    public void setMagicalDamage(int magicalDamage) {
        this.magicalDamage = magicalDamage;
    }

    public int getCastTime() {
        return castTime;
    }

    public void setCastTime(int castTime) {
        this.castTime = castTime;
    }

    public int getManaCostPerCast() {
        return manaCostPerCast;
    }

    public void setManaCostPerCast(int manaCostPerCast) {
        this.manaCostPerCast = manaCostPerCast;
    }
}

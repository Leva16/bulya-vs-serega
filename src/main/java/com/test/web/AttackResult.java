package com.test.web;

/**
 * Created by leva on 5/14/15.
 */
public class AttackResult {

    private int damage;
    private boolean magicDamage;
    private boolean crit;
    private int realDamage;
    private boolean weaponIsBroken;

    public boolean isWeaponIsBroken() {
        return weaponIsBroken;
    }

    public void setWeaponIsBroken(boolean weaponIsBroken) {
        this.weaponIsBroken = weaponIsBroken;
    }

    public boolean isMagicDamage() {
        return magicDamage;
    }

    public void setMagicDamage(boolean magicDamage) {
        this.magicDamage = magicDamage;
    }

    public int getRealDamage() {
        return realDamage;
    }

    public void setRealDamage(int realDamage) {
        this.realDamage = realDamage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public boolean isCrit() {
        return crit;
    }

    public void setCrit(boolean crit) {
        this.crit = crit;
    }
}

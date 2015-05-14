package com.test;

/**
 * Created by leva on 5/14/15.
 */
public class Weapon {

    private String weaponName;
    private int physicalDamage;
    private int attackSpeed;
    private boolean oneHand;
    private String magicSpell;

    public String getMagicSpell() {
        return magicSpell;
    }

    public void setMagicSpell(String magicSpell) {
        this.magicSpell = magicSpell;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getPhysicalDamage() {
        return physicalDamage;
    }

    public void setPhysicalDamage(int physicalDamage) {
        this.physicalDamage = physicalDamage;
    }

    public int getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(int attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public boolean isOneHand() {
        return oneHand;
    }

    public void setOneHand(boolean oneHand) {
        this.oneHand = oneHand;
    }
}

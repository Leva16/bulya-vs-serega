package com.test;

/**
 * Created by leva on 5/14/15.
 */
public class Weapon {

    private String weaponName;
    private int minPhysicalDamage;
    private int maxPhysicalDamage;
    private int physicalDamage;
    private double attackSpeed;
    private boolean oneHand;
    private int critChance;

    public int getBrokeChance() {
        return brokeChance;
    }

    public void setBrokeChance(int brokeChance) {
        this.brokeChance = brokeChance;
    }

    private int brokeChance;

    public Weapon(String weaponName, int minPhysicalDamage, int maxPhysicalDamage, double attackSpeed, boolean oneHand, int critChance, int brokeChance) {
        this.weaponName = weaponName;
        this.minPhysicalDamage = minPhysicalDamage;
        this.maxPhysicalDamage = maxPhysicalDamage;
        this.attackSpeed = attackSpeed;
        this.oneHand = oneHand;
        this.critChance = critChance;
        this.brokeChance = brokeChance;
    }

    public int getPhysicalDamage() {
        return physicalDamage;
    }

    public void setPhysicalDamage(int physicalDamage) {
        this.physicalDamage = physicalDamage;
    }

    public int getMinPhysicalDamage() {
        return minPhysicalDamage;
    }

    public void setMinPhysicalDamage(int minPhysicalDamage) {
        this.minPhysicalDamage = minPhysicalDamage;
    }

    public int getMaxPhysicalDamage() {
        return maxPhysicalDamage;
    }

    public void setMaxPhysicalDamage(int maxPhysicalDamage) {
        this.maxPhysicalDamage = maxPhysicalDamage;
    }

    public int getCritChance() {
        return critChance;
    }

    public void setCritChance(int critChance) {
        this.critChance = critChance;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public boolean isOneHand() {
        return oneHand;
    }

    public void setOneHand(boolean oneHand) {
        this.oneHand = oneHand;
    }

    @Override
    public String toString() {
        return getWeaponName();
    }
}

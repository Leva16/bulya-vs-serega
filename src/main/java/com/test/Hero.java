package com.test;

import com.test.web.AttackResult;

import java.util.Random;

/**
 * Created by leva on 5/14/15.
 */
public class Hero {

    public static final String[] PHRASE = new String[] {
            "I kill you!",
            "I'm sorry, did you say stop?",
            "Hi will be mine!",
            "Nobody can hurt me without my permission.",
            "Die!!!",
            "This is a good day for someone to die!",
            "Blood for the blood!!!",
            "I'll wash my beard in your blood!",
            "For Justice!",
            "Is that really all you've got?",
            "I'll show you hell!",
            "Today i will celebrate my victory!",
            "For my love!",
            "Game is over!",
            "Today i will celebrate my victory!",
            "Bitch, you don't have a future!",
            "Come and get some!",
            "In your face!",
            "You wanna piece of me boy?",
            "Get away from him, you Bitch!!",
            "Taste my blade!",
            "Bitch, you don't have a future!",
            "Come and get some!",
            "In your face!",
            "You wanna piece of me boy?",
            "Get away from him, you Bitch!!",
            "Taste my blade!",
            "I'll teach you a lesson!",
            "Fuck you!",
            "Prey for mercy!"
    };
    private String name;
    private String ansiColor;

    public String getAnsiColor() {
        return ansiColor;
    }

    public void setAnsiColor(String ansiColor) {
        this.ansiColor = ansiColor;
    }

    private int life;
    private int mana;
    private Armor armor;

    public Armor getArmor() {
        return armor;
    }

    public void setReservedWeapon(Weapon reservedWeapon) {
        this.reservedWeapon = reservedWeapon;
    }

    private  Weapon reservedWeapon;
    private  Weapon weapon;

    public Magic getMagic() {
        return magic;
    }

    public void setMagic(Magic magic) {
        this.magic = magic;
    }

    private Magic magic;

    private static Random random = new Random(System.currentTimeMillis());

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Hero(String name, int life, int mana) {
        this.name = name;
        this.life = life;
        this.mana = mana;
    }

    public Hero() {}

    public String getAnsiName() {
        return ansiColor + name + "\u001B[0m";
    }
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

    public int hit(int damage) {
        int realDamage = (int)(damage - damage * this.armor.getDefence() * 0.05);
        this.life = this.life - realDamage;
        return realDamage;
    }

    public Magic selectMagic(Magic[] magics) {
        int choice = random.nextInt(magics.length);
        this.magic = magics[choice];
        return this.magic;
    }

    public Weapon selectWeapon(Weapon[] weapons) {
        int choice = random.nextInt(weapons.length);
        this.weapon = weapons[choice];
        return this.weapon;
    }

    public Armor selectArmor(Armor[] armors) {
        int choice = random.nextInt(armors.length);
        this.armor = armors[choice];
        return this.armor;
    }



    public AttackResult attack(Hero hero) {

        // create instance of class AttackResult
        AttackResult heroAttackResult = new AttackResult();

        int brakeChance = random.nextInt(this.getWeapon().getBrokeChance());
        if (brakeChance == 1) {
            this.weapon = this.reservedWeapon;
            heroAttackResult.setWeaponIsBroken(true);
            hero.setWeapon(hero.reservedWeapon);
        }


        // get damage value of the used weapon hero who attack
        int damage = random.nextInt(1 + this.getWeapon().getMaxPhysicalDamage() - this.getWeapon().getMinPhysicalDamage()) + this.getWeapon().getMinPhysicalDamage();

        //int damage = this.getWeapon().getPhysicalDamage();

        // calculate random number of crit chance
        int critChance = random.nextInt(getWeapon().getCritChance());
        // check, if the value of crit chance equal 1
        if (critChance == 1 && getWeapon().getCritChance() != Integer.MAX_VALUE) {
            // increase damage in 20%
            damage += damage * 1;
            //set info about crit to the hero attack result instance
            heroAttackResult.setCrit(true);
        }

        //magic damage chanse
        int magicChance = random.nextInt(2);
        if (magicChance == 1) {
            damage += this.getMagic().getDamage();
            heroAttackResult.setMagicDamage(true);
        }

        // reduce life for the attacked hero
        int realDamage = hero.hit(damage);
        //set info about damage to the AttackResult instance
        heroAttackResult.setDamage(damage);
        heroAttackResult.setRealDamage(realDamage);
        //return our heroAttackResult variable
        return heroAttackResult;
    }
}

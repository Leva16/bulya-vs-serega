package com.test;
import java.nio.file.Watchable;
import java.util.Random;
import com.test.animals.Cat;
import com.test.web.AttackResult;
import com.test.web.WebApp;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.Random;

/**
 * Created by leva on 06/05/15.
 */
public class Hello {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String[] REWARD_PHRASES = new String[] {
            "You are my Hero!!!",
            "I know it would be you.",
            "You are my brave boy!",
            "You killed a Monster!",
            "You wanna go to my place?",
            "Let me hill your wounds.",
            "I preyed for you, my brave boy.",
            "I knew you're the best!"
    };

    static Random random = new Random(System.currentTimeMillis());

    public static void main(String[] args) throws IOException {

        Hero serejka = new Hero("Serejka", 1300, 400);
        Hero bulya = new Hero("Bulya", 1500, 600);
        serejka.setAnsiColor(ANSI_YELLOW);
        bulya.setAnsiColor(ANSI_PURPLE);


        Armor simplArmor = new Armor("T-shirt", 1);
        Armor simplArmor1 = new Armor("Sweater", 2);
        Armor simplArmor2 = new Armor("Tylyp", 6);
        Armor simplArmor3 = new Armor("Setocka Leontieva", 1);

        Weapon hand = new Weapon("Hand", 5, 10, 1, false, 2, Integer.MAX_VALUE);
        Weapon simpleSword = new Weapon("Simple Sword", 40, 50, 1.8, true, 4, 150);
        Weapon greatSword = new Weapon("Great Sword", 80, 90, 1.4, true, 3, 170);
        Weapon twoHandSword = new Weapon("Two Hand Sword", 90, 110, 2.1, false, Integer.MAX_VALUE, 110);
        Weapon bow = new Weapon("Bow", 30, 35, 1, false, 2, 150);
        Weapon knife = new Weapon("Knife", 30, 40, 1, true, 3, 140);
        Weapon staff = new Weapon("Staff", 25, 30, 2, false, 2, 140);


        Armor[] armors = new Armor[] {
                simplArmor,
                simplArmor1,
                simplArmor2,
                simplArmor3
        };


        Weapon[] weapons = new Weapon[] {
                simpleSword,
                greatSword,
                twoHandSword,
                bow,
                knife,
                staff
        };

        serejka.setReservedWeapon(hand);
        bulya.setReservedWeapon(hand);

        serejka.selectWeapon(weapons);
        bulya.selectWeapon(weapons);
        serejka.selectArmor(armors);
        bulya.selectArmor(armors);

        showIntro(bulya, serejka);



        while (serejka.getLife() > 0 && bulya.getLife() > 0) {

            int fightCase = random.nextInt(4);


            println("\n");
            switch (fightCase) {
                case 0: {
                    System.out.println("Both missed");
                    break;
                }
                case 1: {
                    attackAndPrint(serejka, bulya);
                    break;
                }
                case 2: {
                    attackAndPrint(bulya, serejka);
                    break;
                }
                case 3: {
                    System.out.println("Both strike... ");
                    sleep(1000);
                    attackAndPrint(serejka, bulya);
                    attackAndPrint(bulya, serejka);
//                    AttackResult serejkaAttackResult = serejka.attack(bulya);
//                    sleep(1000);
//                    /*if (attackResult.isWeaponIsBroken()) {
//                        println("OMG!!!, the weapon is broken..., now " + serejka.getAnsiName() + " must fight by fist.");
//                    }
//                    if (serejkaAttackResult.isCrit()) {
//                        println(ANSI_RED + "Serejka CRIT!!!" + ANSI_RESET);
//                    }
//                    println(ANSI_YELLOW + "Serejka " +ANSI_RESET + "deal damage " + serejkaAttackResult.getRealDamage() + "(" + serejkaAttackResult.getDamage()+ ").");
//                    AttackResult attackResult = bulya.attack(serejka);
//                    sleep(1000);
//                    if (attackResult.isCrit()) {
//                        println(ANSI_RED + "Bulya CRIT!!!" + ANSI_RESET);
//                    }
//                    println(ANSI_PURPLE + "Bulya " +ANSI_RESET + "deal damage " + attackResult.getRealDamage() + "(" +attackResult.getDamage()+ ")."); */
                    break;
                }
            }
            println(String.format("%s life is %s", bulya.getAnsiName(), bulya.getLife()));
            println(String.format("%s life is %s", serejka.getAnsiName(), serejka.getLife()));
            sleep(2000);
        }

        int i = random.nextInt(2);

        String rewardName = (i == 1) ? "Leva" : "Aleksitto";
        println("i = " + i);
        if (bulya.getLife() <= 0 && serejka.getLife() <= 0) {
            println(rewardName + " is crying!!!");

        } else if (bulya.getLife() <= 0) {
            System.out.println("\nWe have a winner " + serejka.getAnsiName() + ".");
            println("Roses for the winner " + ANSI_RED + "இڿڰۣ-ڰۣ—" + ANSI_RESET + " and kiss from " + rewardName +".");
        } else {
            System.out.println("\nWe have a winner " + bulya.getAnsiName() + ".");
            println("Roses for the winner " + ANSI_RED + "இڿڰۣ-ڰۣ—" + ANSI_RESET + " and kiss from " + rewardName +".");
        }
        if (random.nextInt(2) == 1) {

            int cries = random.nextInt(REWARD_PHRASES.length);
            println(ANSI_BLUE + REWARD_PHRASES[cries] + ANSI_RESET + " - says " + rewardName + ".");
        }
    }
    public static void sleep (long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void println(String txt) {
        System.out.println(txt);
    }
    public static void showIntro(Hero hero1, Hero hero2) {
        println(String.format("%s life is %s", hero1.getAnsiName(), hero1.getLife()));
        System.out.print(hero1.getAnsiName() + " choice... ");
        sleep(1000);
        println(hero1.getWeapon().getWeaponName() + " with damage " + hero1.getWeapon().getMinPhysicalDamage() + "-" + hero1.getWeapon().getMaxPhysicalDamage());
        println(hero1.getArmor().getName() + " with " + hero1.getArmor().getDefence() + " defence.");
        println(String.format("%s life is %s", hero2.getAnsiName(), hero2.getLife()));
        System.out.print(hero2.getAnsiName() + " choice... ");
        sleep(1000);
        println(hero2.getWeapon().getWeaponName() + " with damage " + hero2.getWeapon().getMinPhysicalDamage() +"-" + hero2.getWeapon().getMaxPhysicalDamage());
        println(hero2.getArmor().getName() + " with " + hero2.getArmor().getDefence() + " defence.");
        sleep(2000);
        println("\n3...");
        sleep(1000);
        println("2...");
        sleep(1000);
        println("1...");
        sleep(1000);
        println(ANSI_RED +"\nFight!!!" + ANSI_RESET);
        sleep(1000);
    }
    public static void attackAndPrint(Hero hero1, Hero hero2) {
        System.out.print(hero1.getAnsiName() + " strike... ");
        sleep(1000);
        AttackResult attackResult = hero1.attack(hero2);
        sleep(1000);
        if (attackResult.isWeaponIsBroken()) {
            println("OMG!!!, the weapon is broken..., now " + hero1.getAnsiName() + " must fight by fist.");
        }
        if (attackResult.isCrit()) {

            if (random.nextInt(5) == 1) {

                int cries = random.nextInt(Hero.PHRASE.length);

                println(ANSI_RED + "CRIT!!! " + ANSI_RESET + ANSI_CYAN + Hero.PHRASE[cries] + ANSI_RESET);
            } else {
                println(ANSI_RED + "CRIT!!! " + ANSI_RESET);
            }
        }
        println("Damage " + attackResult.getRealDamage() + "(" +attackResult.getDamage()+ ").");

    }
}
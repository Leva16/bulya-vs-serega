package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Watchable;
import java.security.spec.MGF1ParameterSpec;
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

    public static final String[] REWARD_PHRASES = new String[]{
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


        Hero serejka = new Hero("Serejka", 300, 400);
        Hero bulya = new Hero("Bulya", 500, 600);
        serejka.setAnsiColor(ANSI_YELLOW);
        bulya.setAnsiColor(ANSI_PURPLE);


        Armor simplArmor = new Armor("T-shirt", 1);
        Armor simplArmor1 = new Armor("Sweater", 2);
        Armor simplArmor2 = new Armor("Tylyp", 6);
        Armor simplArmor3 = new Armor("Setocka Leontieva", 1);

        Weapon hand = new Weapon("Hand", 5, 10, 1, false, 2, Integer.MAX_VALUE);
        Weapon simpleSword = new Weapon("Simple Sword", 40, 50, 1.8, true, 4, 2);
        Weapon greatSword = new Weapon("Great Sword", 80, 90, 1.4, true, 3, 2);
        Weapon twoHandSword = new Weapon("Two Hand Sword", 90, 110, 2.1, false, Integer.MAX_VALUE, 2);
        Weapon bow = new Weapon("Bow", 30, 35, 1, false, 2, 2);
        Weapon knife = new Weapon("Knife", 30, 40, 1, true, 3, 2);
        Weapon staff = new Weapon("Staff", 25, 30, 2, false, 2, 2);

        Magic ligthStrike = new Magic(ANSI_CYAN + "Slept by ass" + ANSI_RESET, 40, 100 );
        Magic fireStrike = new Magic(ANSI_CYAN + "Twist nipples" + ANSI_RESET, 42, 110);
        Magic gunShot = new Magic(ANSI_CYAN + "Powder in the eyes" + ANSI_RESET, 50, 120);
        Magic dragonBlaze = new Magic(ANSI_CYAN + "Stretch underwave to the head" + ANSI_RESET, 60, 150);
        Magic lavaRage = new Magic(ANSI_CYAN + "Slap in the Face" + ANSI_RESET, 68, 170);

        Magic[] magics = new Magic[] {
                ligthStrike,
                fireStrike,
                gunShot,
                dragonBlaze,
                lavaRage
        };


        Armor[] armors = new Armor[]{
                simplArmor,
                simplArmor1,
                simplArmor2,
                simplArmor3
        };


        Weapon[] weapons = new Weapon[]{
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

        println("weapon " + serejka.getWeapon());



        showIntro(bulya, serejka);

        //int mercy = random.nextInt(2);

        int mercy = 1;
        boolean isGo = false;

        int count = 0;
        while (serejka.getLife() > 0 && bulya.getLife() > 0) {
            count += 1;
            int fightCase = random.nextInt(4);
            serejka.selectMagic(magics);
            bulya.selectMagic(magics);

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

            if (count == 5) {
                println("\n");
                println("\n");
                int i = random.nextInt(2);
                String rewardName = (i == 1) ? "Leva" : "Aleksitto";
                sleep(2000);
                println(ANSI_GREEN + rewardName + ANSI_RESET + " runs to the warriors and scream: Boys, stops, you kill each others!");
                println("No, say boys, we fight for you till someone is die.");
            }

                if (bulya.getLife() <= 200 && !isGo) {
                    print(String.format("%s life is %s, would you like to mercy him (finger up) or finish him (finger down) or go till the end (go): ", bulya.getAnsiName(), bulya.getLife()));
                    BufferedReader text = new BufferedReader(new InputStreamReader(System.in));
                    String txt = text.readLine().toLowerCase();
                    println(txt);

                    while (!"up".equals(txt) && !"down".equals(txt) && !"go".equals(txt)) {
                        print("You should write 'Up' or 'Down' or 'Go' word: ");
                        txt = text.readLine().toLowerCase();
                        println(txt);
                    }

                    if ("up".equals(txt)) {
                        print(bulya.getAnsiName() + " thanks you.");
                        break;
                    } else if ("down".equals(txt)) {
                        println(serejka.getAnsiName() + " get final strike whit e" + bulya.getLife() + " damage");
                        bulya.setLife(0);
                    } else {
                        isGo = true;
                        continue;
                    }
                } else if (serejka.getLife() < 200 && !isGo) {
                    print(String.format("%s life is %s, would you like to mercy him (finger up) or finish him (finger down): ", serejka.getAnsiName(), serejka.getLife()));
                    BufferedReader text = new BufferedReader(new InputStreamReader(System.in));
                    String txt = text.readLine().toLowerCase();

                    while (!"up".equals(txt) && !"down".equals(txt) && !"go".equals(txt)) {
                        print("You should write 'Up' or 'Down' or 'Go' word: ");
                        txt = text.readLine().toLowerCase();
                        println(txt);
                    }
                    if ("up".equals(txt)) {
                        println(serejka.getAnsiName() + " thanks you.");
                        break;
                    } else if ("down".equals(txt)) {
                        println(bulya.getAnsiName() + " get final strike whit " + serejka.getLife() + " damage.");
                        serejka.setLife(0);
                    } else {
                        isGo = true;
                        continue;
                    }

                }

            }


        int i = random.nextInt(2);

        String rewardName = (i == 1) ? "Leva" : "Aleksitto";



        //println("i = " + i);
        if (bulya.getLife() <= 0 && serejka.getLife() <= 0) {
            println(rewardName + " is crying!!!");
            return;

        } else if (bulya.getLife() <= 0) {
            System.out.println("\nWe have a winner " + serejka.getAnsiName() + ".");
            println("Roses for the winner " + ANSI_RED + "இڿڰۣ-ڰۣ—" + ANSI_RESET + " and kiss from " + rewardName + ".");
        } else {
            System.out.println("\nWe have a winner " + bulya.getAnsiName() + ".");
            println("Roses for the winner " + ANSI_RED + "இڿڰۣ-ڰۣ—" + ANSI_RESET + " and kiss from " + rewardName + ".");
        }
        if (random.nextInt(2) == 1) {

            int cries = random.nextInt(REWARD_PHRASES.length);
            println(ANSI_BLUE + REWARD_PHRASES[cries] + ANSI_RESET + " - says " + rewardName + ".");
        }
        // return mercy;
    }

    public static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void println(String txt) {
        System.out.println(txt);
    }

    public static void print(String txt) {
        System.out.print(txt);
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
        println(hero2.getWeapon().getWeaponName() + " with damage " + hero2.getWeapon().getMinPhysicalDamage() + "-" + hero2.getWeapon().getMaxPhysicalDamage());
        println(hero2.getArmor().getName() + " with " + hero2.getArmor().getDefence() + " defence.");
        sleep(2000);
        println("\n3...");
        sleep(1000);
        println("2...");
        sleep(1000);
        println("1...");
        sleep(1000);
        println(ANSI_RED + "\nFight!!!" + ANSI_RESET);
        sleep(1000);
    }

    public static void attackAndPrint(Hero hero1, Hero hero2) {
        System.out.print(hero1.getAnsiName() + " strike... ");
        sleep(1000);
        AttackResult attackResult = hero1.attack(hero2);
        sleep(1000);
        if (attackResult.isWeaponIsBroken()) {
            println("OMG!!!, the weapon is broken..., now " + hero1.getAnsiName() + " must fight by fist.");
            println(hero2.getAnsiName() + " throw his " + hero2.getWeapon() + " away. ");
            println(ANSI_RED + "Fist FIGHT!!!");
        }
        if (attackResult.isCrit()) {

            if (random.nextInt(5) == 1) {

                int cries = random.nextInt(Hero.PHRASE.length);

                println(ANSI_RED + "CRIT!!! " + ANSI_RESET + ANSI_CYAN + Hero.PHRASE[cries] + ANSI_RESET);
            } else {
                println(ANSI_RED + "CRIT!!! " + ANSI_RESET);
            }
        }
        if (attackResult.isMagicDamage()) {
            println("WOW... " + hero1.getAnsiName() + " has magic spell " + hero1.getMagic().getName() + " he deal " + hero2.getAnsiName() + " extra "+ hero1.getMagic().getDamage() + " damage.");
        }
        println("Damage " + attackResult.getRealDamage() + "(" + attackResult.getDamage() + ").");

    }
}
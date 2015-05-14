package com.test;
import java.util.Random;
import com.test.animals.Cat;
import com.test.web.WebApp;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.util.Random;

/**
 * Created by alekseydudchenko on 06/05/15.
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

    public static void main(String[] args) throws IOException {

        Hero serejka = new Hero("Serejka", 1300, 400);
        Hero bulya = new Hero("Bulya", 1500, 600);

        Weapon serejkaSword = new Weapon();
        Weapon bulyaSword = new Weapon();
        serejkaSword.setPhysicalDamage(100);
        bulyaSword.setPhysicalDamage(80);

        showIntro(bulya, serejka);

        Random random = new Random(System.currentTimeMillis());

        while (serejka.getLife() > 0 && bulya.getLife() > 0) {

            int fightCase = random.nextInt(4);
            int critSer = random.nextInt(5);
            int critBul = random.nextInt(5);

            println("\n");
            switch (fightCase) {
                case 0: {
                    System.out.println("Both missed");
                    break;
                }
                case 1: {
                    System.out.print("Serejka strike... ");
                    sleep(1000);
                    int commonDamage = serejkaSword.getPhysicalDamage();
                    if (critSer == 1) {
                        commonDamage += 40;
                        println(ANSI_RED + "CRIT!!!" + ANSI_RESET);
                    }
                    bulya.hit(commonDamage);
                    println("Damage " + commonDamage + ".");
                    break;
                }
                case 2: {
                    System.out.print("Bulya strike... ");
                    sleep(1000);
                    int commonDamage = bulyaSword.getPhysicalDamage();
                    if (critBul == 1) {
                        commonDamage += 30;
                        println(ANSI_RED + "CRIT!!!" + ANSI_RESET);
                    }
                    serejka.hit(commonDamage);
                    System.out.println("Damage " + commonDamage + ".");
                    break;
                }
                case 3: {
                    System.out.print("Both strike... ");
                    sleep(1000);
                    int commonDamageSer = serejkaSword.getPhysicalDamage();
                    int commonDamageBul = bulyaSword.getPhysicalDamage();
                    if (critBul == 1) {
                        commonDamageBul += 30;
                        System.out.print(ANSI_RED + "Bulya has CRIT!!! " + ANSI_RESET);

                    }
                    if (critSer ==1) {
                        commonDamageSer += 40;
                        System.out.print(ANSI_RED + "Serejka has CRIT!!!" + ANSI_RESET);
                    }
                    bulya.hit(commonDamageSer);
                    serejka.hit(commonDamageBul);
                    System.out.print("\nSerejka damage " + commonDamageSer);
                    System.out.println(" Bulya damage " + commonDamageBul);
                    break;
                }
            }
            println(String.format("%s life is %s", bulya.getName(), bulya.getLife()));
            println(String.format("%s life is %s", serejka.getName(), serejka.getLife()));
            sleep(2000);
        }

        int i = random.nextInt(2);

        String rewardName = (i == 1) ? "Leva" : "Aleksitto";
        println("i = " + i);
        if (bulya.getLife() <= 0 && serejka.getLife() <= 0) {
            println(rewardName + " is crying!!!");

        } else if (bulya.getLife() <= 0) {
            System.out.println("\nWe have a winner " + serejka.getName() + ".");
            println("Roses for the winner " + ANSI_RED + "இڿڰۣ-ڰۣ—" + ANSI_RESET + " and kiss from " + rewardName +".");
        } else {
            System.out.println("\nWe have a winner " + bulya.getName() + ".");
            println("Roses for the winner " + ANSI_RED + "இڿڰۣ-ڰۣ—" + ANSI_RESET + " and kiss from " + rewardName +".");
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
        println(String.format("%s life is %s", hero1.getName(), hero1.getLife()));
        println(String.format("%s life is %s", hero2.getName(), hero2.getLife()));
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
}


      /*  String catTranslate = Cat.translate("Hello, kitty");

        //System.out.println("Kitty says: " + catTranslate);

        Cat cat = new Cat();
        Car car = new Car();
        car.setColor("yellow");
        car.setModel("Tesla");
        car.setEngine("electric");
        car.setYear(2014);

        Car vw = new Car();
        vw.setModel("Golf");
        vw.setEngine("diesel");
        vw.setColor("white");
        vw.setYear(2015);

        System.out.println("I have a car, model " + car.getModel() + ", whit " + car.getEngine() + " engine, " + car.getColor() + " color, " + car.getYear() + " year.");
        System.out.println("I have a car, model " + vw.getModel() + ", whit " + vw.getEngine() + " engine, " + vw.getColor() + " color, " + vw.getYear() + " year.");

        vw.setColor("black");
        System.out.println("I paint my " + vw.getModel() + " to " + vw.getColor() + " color.");


        //Dota axe = new AttributDota(30, 20, 10, "Strength");
        AttributDota axe = new AttributDota(30, 20, 10, "Strength");

        axe.setName("Axe");
        axe.setFaction("Dire");
        System.out.println(axe.strength);
        System.out.println(axe.attribut);



        Human human = new Human();

        human.setAge(27);
        human.setName("Serega");

       // System.out.println("The human sex is " + human.getName());


     *    ConfigurableApplicationContext context = SpringApplication.run(WebApp.class, args);
     *     Run Spring
     *     ConfigurableApplicationContext context = SpringApplication.run(WebApplication.class, args);
     *     System.exit(0);
     */
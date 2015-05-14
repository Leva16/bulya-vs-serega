package com.test.animals;

/**
 * Created by leva on 5/7/15.
 */
public class Cat {
    private String name;
    private int weight;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public static String translate(String text) {
        return "Meow, meow, " + text;
    }
}

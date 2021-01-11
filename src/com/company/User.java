package com.company;

public class User {
    private String name;
    private int age;
    private int health;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.health = 5;
    }

    public int getHealth() {
        return health;
    }

    public void addHealth(int health) {
        this.health += health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}

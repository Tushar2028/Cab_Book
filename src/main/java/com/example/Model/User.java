package com.example.Model;

public abstract class User {
    private String name;
    private Character gender;
    private int age;

    public User(String name, Character gender, int age){
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public String getName() {
        return name;
    }
}

package com.example.Model;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Driver {

    private String name;
    private Character gender;
    private int age;
    private String carNumber;
    private Location location;
    private boolean available;
    private Vehicle vehicle;

    public Driver(String name, Character gender, int age, String carNumber, Location location, Boolean available){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.carNumber = carNumber;
        this.location = location;
        this.available = available;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Character getGender() {
        return gender;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public void setCarNumber(String carNumber) {
        this.carNumber = carNumber;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}

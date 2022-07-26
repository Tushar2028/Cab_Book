package com.example.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class User {

    private String name;
    private Character gender;
    private int age;
    Location fromLocation;
    Location toLocation;
    private List<Ride> rideList = new ArrayList<Ride>();

    public User(String name, Character gender, int age, Location fromLocation, Location toLocation){
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
    }

    public String getName() {
        return name;
    }

    public Character getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Character gender) {
        this.gender = gender;
    }

    public List<Ride> getRideList() {
        return rideList;
    }

    public Location getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(Location fromLocation) {
        this.fromLocation = fromLocation;
    }

    public Location getToLocation() {
        return toLocation;
    }

    public void setToLocation(Location toLocation) {
        this.toLocation = toLocation;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

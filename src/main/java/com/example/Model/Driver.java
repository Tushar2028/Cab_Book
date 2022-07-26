package com.example.Model;

import com.sun.org.apache.xpath.internal.operations.Bool;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Driver extends User{
    private String carNumber;
    private Location location;
    private boolean available;

    public Driver(String name, Character gender, int age, String carNumber, Location location, Boolean available){
        super(name, gender, age);
        this.carNumber = carNumber;
        this.location = location;
        this.available = available;    }

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

//    public Vehicle getVehicle() {
//        return vehicle;
//    }
//
//    public void setVehicle(Vehicle vehicle) {
//        this.vehicle = vehicle;
//    }
}

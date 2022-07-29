package com.example.Service;

import com.example.Model.Driver;
import com.example.Model.Location;
import com.example.Model.Rider;

import java.util.HashMap;
import java.util.Map;

public class RiderOnboarding {

    private static RiderOnboarding userOnboarding = null;

    public RiderOnboarding(){

    }

    public Map<String, Rider> userMap = new HashMap<>();

    public Map<String, Driver> driverMap = new HashMap<>();

    public static RiderOnboarding getInstance(){
        if(userOnboarding == null){
            userOnboarding = new RiderOnboarding();
        }
        return userOnboarding;
    }

    public Rider addUser(String name, Character gender, int age) {
        Rider user = new Rider(name, gender, age, null, null);
        if(user == null || userMap.containsKey(user.getName())){
            System.out.println("Rider not created.");
        }
        userMap.put(user.getName(), user);
        return user;
    }

    public Driver addDriver(String name, Character gender, int age, String carNumber, Location location, Boolean available) {
        Driver driver = new Driver(name, gender, age , carNumber, location, available);
        if(driver == null || driverMap.containsKey(driver.getName())){
            System.out.println("Driver not created!");
        }
        driverMap.put(driver.getName(), driver);
        return driver;
    }

    public Rider updateUserLocation(String name, Location location) {
        Rider user = new Rider(name, null, 0, location, null);
        if(user == null){
            System.out.println("error in updating userLocation");
        }
        user.setFromLocation(location);
        userMap.put(user.getName(), user);
        return user;
    }

    public Driver updateDriverLocation(String name, Location location) {
        Driver driver = new Driver(name, '\uu0000', 0, null, location, Boolean.TRUE );
        if(driver == null){
            System.out.println("error in updating driverLocation");
        }
        driver.setLocation(location);
        driverMap.put(driver.getName(), driver);
        return driver;
    }

    public void updateUserDetails(String name, Rider user){
        for(Rider rider: userMap.values()) {
            if (rider.getName() == name) {
                userMap.put(name, user);
            }
        }
    }
}

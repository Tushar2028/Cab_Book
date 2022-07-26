package com.example.Service;

import com.example.Exceptions.DriverNotAvailableException;
import com.example.Model.Driver;
import com.example.Model.Location;
import com.example.Model.Ride;
import com.example.Model.Rider;
import com.example.Exceptions.CreateException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RiderOnboarding {

    private static RiderOnboarding userOnboarding = null;

    public RiderOnboarding(){

    }

    public Map<String, Rider> userMap = new HashMap<>();

    public Map<String, Driver> driverMap = new HashMap<>();

    public Map<String, Location> locationMap = new HashMap<>();

//    public Map<Integer, Vehicle> vehicleMap = new HashMap<Integer, Vehicle>();

    public static RiderOnboarding getInstance(){
        if(userOnboarding == null){
            userOnboarding = new RiderOnboarding();
        }
        return userOnboarding;
    }


    public Rider addUser(String name, Character gender, int age) throws CreateException {
        Rider user = new Rider(name, gender, age, null, null);
        if(user == null || userMap.containsKey(user.getName())){
            throw new CreateException("Rider not created.");
        }
        userMap.put(user.getName(), user);
        return user;
    }

    public Driver addDriver(String name, Character gender, int age, String carNumber, Location location, Boolean available) throws CreateException{
        Driver driver = new Driver(name, gender, age , carNumber, location, available);
        if(driver == null || driverMap.containsKey(driver.getName())){
            throw new CreateException("Driver not created !");
        }
        driverMap.put(driver.getName(), driver);
        return driver;
    }


    public void updateUser(String name, Location location){

    }

    public Rider updateUserLocation(String name, Location location) throws CreateException {
        Rider user = new Rider(name, null, 0, location, null);
        if(user == null){
            throw new CreateException("error in updating userLocation");
        }
        user.setFromLocation(location);
        userMap.put(user.getName(), user);
        return user;
    }

    public Map<String, Rider> getUserMap() {
        return userMap;
    }

    public Driver findRide(String riderName, Location fromLocation, Location toLocation) throws DriverNotAvailableException {
        Rider user = userMap.get(riderName);
        List<Driver> driverList = getAllAvailableDrivers(fromLocation);
        if(driverList.isEmpty()){
            System.out.println("Not driver found");
        }
        driverList.get(0).setAvailable(false);
        Ride ride = new Ride(driverList.get(0), user, fromLocation, toLocation);
        user.getRideList().add(ride);
        return driverList.get(0);
    }

    public List<Driver> getAllAvailableDrivers(Location location) {
        List<Driver> driverList = new ArrayList<Driver>();
        for(Driver driver : driverMap.values()){
            if(driver.isAvailable() && distance(driver.getLocation(), location) <= 5){
                driverList.add(driver);
            }
        }
        return driverList;
    }

    public Integer distance(Location l1, Location l2){
        return Math.abs(l1.getX() - l2.getX()) + Math.abs(l1.getY() - l2.getY());
    }
}

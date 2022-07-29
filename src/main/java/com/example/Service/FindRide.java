package com.example.Service;

import com.example.Model.Driver;
import com.example.Model.Ride;
import com.example.Model.Rider;
import com.example.Model.Location;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindRide {

    private static FindRide findRide = null;

    private RiderOnboarding riderOnboarding = RiderOnboarding.getInstance();

    public List<Driver> driverList = new ArrayList<Driver>();

    public Map<String, Integer> earningMap = new HashMap<>();

    private FindRide(){

    }

    public static FindRide getInstance(){
        if(findRide == null){
            findRide = new FindRide();
        }
        return findRide;
    }

    public final int MAX_DISTANCE = 5;

    public Driver findRide(String riderName, Location fromLocation, Location toLocation) {
        Rider user = riderOnboarding.userMap.get(riderName);
        List<Driver> driverList = getAllAvailableDrivers(fromLocation);
        Driver ans = new Driver(null, null, 0, null, null, false);
        for(Driver driver: driverList){
            if(!driver.isAvailable() == Boolean.FALSE){
                Ride ride = new Ride(driver, user, fromLocation, toLocation);
                user.getRideList().add(ride);
                System.out.println(driver.getName() + " [Available]");
                ans = driver;
                break;
            }
        }
        if(ans.getName() == null){
            System.out.println("No ride found");
        }
        return ans;
    }

    public List<Driver> getAllAvailableDrivers(Location location) {
        for(Driver driver : riderOnboarding.driverMap.values()){
            if(driver.isAvailable() && distance(driver.getLocation(), location) <= MAX_DISTANCE){
                driverList.add(driver);
            }
        }
        return driverList;
    }

    public Integer distance(Location l1, Location l2){
        return Math.abs(l1.getX() - l2.getX()) + Math.abs(l1.getY() - l2.getY());
    }

    public Ride chooseRide(String riderName, String driverName) {
        Rider user = riderOnboarding.userMap.get(riderName);
        Ride ride = null;
        for (Driver driver : driverList) {
            ride = new Ride(driver, user, null, null);
            if (driver == null) {
                System.out.println("no ride chosen");
            }
            if (driver.getName().equals(driverName)) {
                driver.setAvailable(false);
                System.out.println("ride Started");
            }
        }
        return ride;
    }

    public int calculateBill(String riderName) {
        Rider user = riderOnboarding.userMap.get(riderName);
        riderOnboarding.updateUserLocation(riderName, user.getRideList().get(0).getToLocation());
        riderOnboarding.updateDriverLocation(user.getRideList().get(0).getDriver().getName(), user.getRideList().get(0).getToLocation());
        int billTotal = distance(user.getRideList().get(0).getFromLocation(), user.getRideList().get(0).getToLocation());
        earningMap.put(user.getRideList().get(0).getDriver().getName() ,billTotal);
        return billTotal;
    }

    public void changeDriverStatus(String driverName, Boolean status){
        for(Driver driver: riderOnboarding.driverMap.values()){
            if(driver.getName() == driverName){
                driver.setAvailable(status);
            }
        }
    }

    public void totalEarning() {
        for (Driver driver : riderOnboarding.driverMap.values()) {
            if(earningMap.get(driver.getName()) != null){
                System.out.println(driver.getName() + " earns " + earningMap.get(driver.getName()));
            }
            else{
                System.out.println(driver.getName() + " earns " + 0);
            }
        }
    }
}

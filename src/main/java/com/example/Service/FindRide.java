package com.example.Service;

import com.example.Model.Driver;
import com.example.Model.Ride;
import com.example.Model.Rider;
import com.example.Exceptions.DriverNotAvailableException;
import com.example.Model.Location;

import java.util.ArrayList;
import java.util.List;

public class FindRide {

    private static FindRide findRide = null;

    private RiderOnboarding riderOnboarding = RiderOnboarding.getInstance();

    private FindRide(){

    }

    public static FindRide getInstance(){
        if(findRide == null){
            findRide = new FindRide();
        }
        return findRide;
    }

    public final int MAX_DISTANCE = 5;

    public Driver findRide(String riderName, Location fromLocation, Location toLocation) throws DriverNotAvailableException {
        Rider user = riderOnboarding.userMap.get(riderName);
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

    public void chooseRide(String riderName, String driverName) throws DriverNotAvailableException {


    }

    public void calculateBill(String riderName){
        String name = String.valueOf(riderOnboarding.userMap.get(riderName));
        Location fromLocation = riderOnboarding.userMap;
    }
}

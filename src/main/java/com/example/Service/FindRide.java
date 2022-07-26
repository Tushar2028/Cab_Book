package com.example.Service;

import com.example.Exceptions.CreateException;
import com.example.Model.Driver;
import com.example.Model.Ride;
import com.example.Model.Rider;
import com.example.Exceptions.DriverNotAvailableException;
import com.example.Model.Location;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.ArrayList;
import java.util.List;

public class FindRide {

    private static FindRide findRide = null;

    private RiderOnboarding riderOnboarding = RiderOnboarding.getInstance();

    public List<Driver> driverList = new ArrayList<Driver>();

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
        System.out.println(driverList.get(0).getName() + " [" + driverList.get(0).isAvailable() + "]");
        return driverList.get(0);
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

    public Ride chooseRide(String riderName, String driverName) throws DriverNotAvailableException {
        Rider user = riderOnboarding.userMap.get(riderName);
        Ride ride = new Ride(driverList.get(0), user, null, null);
        if(driverList.isEmpty()){
            System.out.println("no ride chosen");
        }
        if(driverList.get(0).getName().equals(driverName)){
            driverList.get(0).setAvailable(false);
            System.out.println("ride Started");
        }

        return ride;
    }

    public int calculateBill(String riderName) throws CreateException {
        Rider user = riderOnboarding.userMap.get(riderName);
        riderOnboarding.updateUserLocation(riderName, user.getRideList().get(0).getToLocation());
        riderOnboarding.updateDriverLocation(user.getRideList().get(0).getDriver().getName(), user.getRideList().get(0).getToLocation());
        return distance(user.getRideList().get(0).getFromLocation(), user.getRideList().get(0).getToLocation());
    }

    public void changeDriverStatus(String driverName, Boolean status){
        Ride ride = new Ride(driverList.get(0), null, null, null);
        if(driverList.contains(driverName)){
            driverList.get(0).setAvailable(Boolean.FALSE);
        }
    }
}

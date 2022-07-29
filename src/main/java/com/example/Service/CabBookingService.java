package com.example.Service;

import com.example.Model.Driver;
import com.example.Model.Location;
import com.example.Model.Rider;


public class CabBookingService {
    private static CabBookingService cabBookingService = null;

    public CabBookingService(){

    }

    public static CabBookingService getInstance(){
        if(cabBookingService == null){
            cabBookingService = new CabBookingService();
        }
        return cabBookingService;
    }

    private RiderOnboarding riderOnboarding = RiderOnboarding.getInstance();

    private FindRide findRide = FindRide.getInstance();

    public Rider addUser(String name, Character gender, int age) {
        return riderOnboarding.addUser(name, gender, age);
    }
    public Driver addDriver(String name, Character gender, int age, String carNumber, Location location, Boolean available)  {
        return riderOnboarding.addDriver(name, gender, age, carNumber, location, available);
    }

    public Driver findRide(String name, Location fromLocation, Location toLocation) {
        return findRide.findRide(name, fromLocation, toLocation);
    }

    public Rider updateUserLocation(String name, Location location) {
        return riderOnboarding.updateUserLocation(name, location);
    }

    public void chooseRide(String riderName, String driverName) {
        findRide.chooseRide(riderName, driverName);
    }

    public int calculateBill(String riderName) {
        return findRide.calculateBill(riderName);
    }

    public Boolean changeDriverStatus(String driverName, Boolean status){
        findRide.changeDriverStatus(driverName, status);
        return status;
    }

    public void findTotalEarning(){
        findRide.totalEarning();
    }
}

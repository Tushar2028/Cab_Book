package com.example.Service;

import com.example.Model.Driver;
import com.example.Model.Ride;
import com.example.Model.User;
import com.example.exceptions.DriverNotAvailableException;
import com.example.Model.Location;
import java.util.ArrayList;
import java.util.List;

public class CabBookingService {

    private static CabBookingService cabBookingService = null;

    private UserOnboarding userOnboarding = UserOnboarding.getInstance();

    private static Integer MAX_DISTANCE = 5;
    private CabBookingService(){

    }

    public static CabBookingService getInstance(){
        if(cabBookingService == null){
            cabBookingService = new CabBookingService();
        }
        return cabBookingService;
    }

    public Driver findRide(int riderId, Location fromLocation, Location toLocation) throws DriverNotAvailableException {
        User user = userOnboarding.userMap.get(riderId);
        List<Driver> driverList = getAllAvailableDrivers(fromLocation);
        if(driverList.isEmpty()){
            throw new DriverNotAvailableException("Not driver found");
        }
        driverList.get(0).setAvailable(false);
        Ride ride = new Ride(driverList.get(0), user, fromLocation, toLocation);
        user.getRideList().add(ride);
        return driverList.get(0);
    }

    public List<Driver> getAllAvailableDrivers(Location location) {
        List<Driver> driverList = new ArrayList<Driver>();
        for(Driver driver : userOnboarding.getDriverMap().values()){
            if(driver.isAvailable() && distance(driver.getVehicle().getLocation(), location) <= MAX_DISTANCE){
                driverList.add(driver);
            }
        }
        return driverList;
    }

    public Integer distance(Location l1, Location l2){
        return Math.abs(l1.getX() - l2.getX()) + Math.abs(l1.getY() - l2.getY());
    }
}

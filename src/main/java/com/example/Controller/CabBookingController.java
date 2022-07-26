package com.example.Controller;

import com.example.Exceptions.DriverNotAvailableException;
import com.example.Model.Driver;
import com.example.Model.Location;
import com.example.Model.Rider;
import com.example.Service.CabBookingService;
import com.example.Service.RiderOnboarding;
import com.example.Exceptions.CreateException;

public class CabBookingController {

    public static void main(String[] args) throws CreateException, DriverNotAvailableException {
        CabBookingService cabBookingService = new CabBookingService();
        Rider rider1 = cabBookingService.addUser("Abhishek", 'M', 23);
        Location l1 = new Location(0, 0);
        System.out.println(rider1.getName()  + " successfully registered");
        rider1 = cabBookingService.updateUserLocation("Abhishek", l1);
        System.out.println("user location = " + rider1.getFromLocation());

        cabBookingService.addUser("Rahul", 'M', 29);
        Location l2 = new Location(10, 0);
        cabBookingService.updateUserLocation("Rahul", l2);

        cabBookingService.addUser("Nandini", 'F', 22);
        Location l3 = new Location(15, 6);
        cabBookingService.updateUserLocation("Nandini", l3);


        cabBookingService.addDriver("Driver1", 'M', 22, "Swift, KA-01-12345", new Location(10, 1), Boolean.TRUE);

        cabBookingService.addDriver("Driver2", 'M', 29, "Swift, KA-01-12345", new Location(11, 10), Boolean.TRUE);

        cabBookingService.addDriver("Driver3", 'M', 24, "Swift, KA-01-12345", new Location(5,3), Boolean.TRUE);


        Driver findRide = cabBookingService.findRide("Rahul", new Location(10,0), new Location(15,3));
        System.out.println(findRide.getName());

        cabBookingService.chooseRide("Rahul", "Driver1");

        int bill = cabBookingService.calculateBill("Rahul");
        System.out.println("bill = " + bill);

        Boolean status = cabBookingService.changeDriverStatus("Driver1", Boolean.FALSE);
        System.out.println("sttaus = " + status);

        Driver nand_ride = cabBookingService.findRide("Nandini", new Location(15, 6), new Location(20, 4));
        System.out.println(nand_ride.getName());
    }

}

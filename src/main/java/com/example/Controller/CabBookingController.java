package com.example.Controller;

import com.example.Model.Location;
import com.example.Model.Rider;
import com.example.Service.CabBookingService;

public class CabBookingController {

    public static void main(String[] args) {

        CabBookingService cabBookingService = new CabBookingService();

        cabBookingService.addUser("Abhishek", 'M', 23);
        cabBookingService.updateUserLocation("Abhishek", new Location(0,0));

        cabBookingService.addUser("Rahul", 'M', 29);
        cabBookingService.updateUserLocation("Rahul",  new Location(10, 0));

        cabBookingService.addUser("Nandini", 'F', 22);
        cabBookingService.updateUserLocation("Nandini", new Location(15, 6));


        cabBookingService.addDriver("Driver1", 'M', 22, "Swift, KA-01-12345", new Location(10, 1), Boolean.TRUE);

        cabBookingService.addDriver("Driver2", 'M', 29, "Swift, KA-02-12345", new Location(11, 10), Boolean.TRUE);

        cabBookingService.addDriver("Driver3", 'M', 24, "Swift, KA-03-12345", new Location(5,3), Boolean.TRUE);


        cabBookingService.findRide("Abhishek" , new Location(0,0),new Location(20,1));

        cabBookingService.findRide("Rahul", new Location(10,0), new Location(15,3));

        cabBookingService.chooseRide("Rahul", "Driver1");

        int bill = cabBookingService.calculateBill("Rahul");
        System.out.println("ride ended bill amount: " + bill);

        Boolean status = cabBookingService.changeDriverStatus("Driver1", Boolean.FALSE);

        cabBookingService.findRide("Nandini", new Location(15, 6), new Location(20, 4));

        cabBookingService.findTotalEarning();
    }
}

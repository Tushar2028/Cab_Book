package com.example.Controller;

import com.example.Model.Location;
import com.example.Service.DriverOnboarding;
import com.example.Service.UserOnboarding;
import com.example.exceptions.CreateException;

public class CabBookingController {

    public static void main(String[] args) throws CreateException {
        UserOnboarding userOnboarding = new UserOnboarding();

        userOnboarding.addUser("Abhishek", 'M', 23);
        Location l1 = new Location(0, 0);
        userOnboarding.updateUserLocation("Abhishek", l1);

        userOnboarding.addUser("Rahul", 'M', 29);
        Location l2 = new Location(10, 0);
        userOnboarding.updateUserLocation("Rahul", l2);

        userOnboarding.addUser("Nandini", 'F', 22);
        Location l3 = new Location(15, 6);
        userOnboarding.updateUserLocation("Nandini", l3);

        System.out.println("userMap = " + String.valueOf(userOnboarding.userMap));
    }

}

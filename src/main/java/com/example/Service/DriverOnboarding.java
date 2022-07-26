//package com.example.Service;
//
//import com.example.Model.Driver;
//import com.example.Model.Location;
//import com.example.Exceptions.CreateException;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class DriverOnboarding {
//
//    public Map<String, Driver> driverMap = new HashMap<>();
//
//    public Driver addDriver(String name, Character gender, int age, String carNumber, Location location, Boolean available) throws CreateException{
//        Driver driver = new Driver(name, gender, age , carNumber, location, available);
//        if(driver == null || driverMap.containsKey(driver.getName())){
//            throw new CreateException("Driver not created !");
//        }
//        driverMap.put(driver.getName(), driver);
//        return driver;
//    }
//}

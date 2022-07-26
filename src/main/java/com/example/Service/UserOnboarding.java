package com.example.Service;

import com.example.Model.Driver;
import com.example.Model.Location;
import com.example.Model.User;
import com.example.exceptions.CreateException;

import java.util.HashMap;
import java.util.Map;

public class UserOnboarding {

    private static UserOnboarding userOnboarding = null;

    public UserOnboarding(){

    }

    public Map<String, User> userMap = new HashMap<String, User>();

    public Map<Integer, Driver> driverMap = new HashMap<Integer, Driver>();

//    public Map<Integer, Vehicle> vehicleMap = new HashMap<Integer, Vehicle>();

    public static UserOnboarding getInstance(){
        if(userOnboarding == null){
            userOnboarding = new UserOnboarding();
        }
        return userOnboarding;
    }


    public User addUser(String name, Character gender, int age) throws CreateException {
        User user = new User(name, gender, age, null, null);
        if(user == null || userMap.containsKey(user.getName())){
            throw new CreateException("Rider not created.");
        }
        userMap.put(user.getName(), user);
        return user;
    }


    public void updateUser(String name, Location location){

    }

    public void updateUserLocation(String name, Location location) throws CreateException {
        User user = new User(name, null, 0, location, null);
        if(user == null){
            throw new CreateException("error in updating userLocation");
        }
        if(userMap.containsKey(user)){
            userMap.put(userMap.containsKey(user), userMap.put(user, Location));
        }

    }

    public Map<String, User> getUserMap() {
        return userMap;
    }

    public Map<Integer, Driver> getDriverMap() {
        return driverMap;
    }
}

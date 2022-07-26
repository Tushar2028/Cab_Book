package com.example.Model;

public class Ride {
    private Driver driver;
    private User user;
    private Location fromLocation;
    private Location toLocation;

    public Ride(Driver driver, User user, Location fromLocation, Location toLocation){
        this.driver = driver;
        this.user = user;
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public User getRider() {
        return user;
    }

    public void setRider(User user) {
        this.user = user;
    }

    public Location getFromLocation() {
        return fromLocation;
    }

    public void setFromLocation(Location fromLocation) {
        this.fromLocation = fromLocation;
    }

    public Location getToLocation() {
        return toLocation;
    }

    public void setToLocation(Location toLocation) {
        this.toLocation = toLocation;
    }
}
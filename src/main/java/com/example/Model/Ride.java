package com.example.Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ride {
    private Driver driver;
    private Rider user;
    private Location fromLocation;
    private Location toLocation;

    public Ride(Driver driver, Rider user, Location fromLocation, Location toLocation){
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

    public Rider getUser() {
        return user;
    }

    public void setUser(Rider user) {
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
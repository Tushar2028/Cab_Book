package com.example.Model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Rider extends User {
    Location fromLocation;
    Location toLocation;
    private List<Ride> rideList = new ArrayList<Ride>();

    public Rider(String name, Character gender, int age, Location fromLocation, Location toLocation){
        super(name, gender, age);
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
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

    public List<Ride> getRideList() {
        return rideList;
    }

    public void setRideList(List<Ride> rideList) {
        this.rideList = rideList;
    }
}

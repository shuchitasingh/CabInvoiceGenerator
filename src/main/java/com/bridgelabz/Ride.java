package com.bridgelabz;

public class Ride {
    private double distance;
    private int time;
    private String rideType;

    public Ride(double distance, int time, String rideType) {
        this.distance = distance;
        this.time = time;
        this.rideType = rideType;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getRideType() {
        return rideType;
    }

    public void setRideType(String rideType) {
        this.rideType = rideType;
    }

    @Override
    public String toString() {
        return "Ride---->" +
                "distance=" + distance +
                ", time=" + time +
                ", rideType='" + rideType + "\n";
    }
}

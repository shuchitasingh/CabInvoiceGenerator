package com.bridgelabz;

public class CabInvoiceGenerator {
    RideHistory ridesHistory = new RideHistory();
    private static final double MINIMUM_COST_PER_KM = 10;
    private static final int MINIMUM_COST_PER_MIN = 1;
    private static final double MINIMUM_FARE = 5;

    public double calculateNormalFare(double distance, int time) {
        double fare = (distance * MINIMUM_COST_PER_KM) + (time * MINIMUM_COST_PER_MIN);
        return (fare < MINIMUM_FARE) ? MINIMUM_FARE : fare;
    }

    public double calculateFare(Ride[] rides) {
        double totalFare = 0;

        for (Ride ride : rides) {
            totalFare = totalFare + calculateNormalFare(ride.getDistance(), ride.getTime());
            System.out.println(totalFare);
        }
        System.out.println("Total fare of multiple Ride=" + totalFare);
        return totalFare;
    }

    public InvoiceSummary calculateInvoiceSummary(Ride[] rides) {
        double fare = calculateFare(rides);
        return new InvoiceSummary(fare, rides.length);
    }

    public void addRidesForPerticularUser(String userId, Ride[] rides) {
        ridesHistory.addRidesForUserID(userId, rides);

    }

    public InvoiceSummary getInvoiceSummary(String userId) {
        Ride[] rideData = ridesHistory.getRidesHistory(userId);
        return calculateInvoiceSummary(rideData);
    }

}


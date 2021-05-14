package com.bridgelabz;

public class InvoiceSummary {
    private double totalFare;
    private int rides;
    private double averageFare;

    public InvoiceSummary(double totalFare, int rides) {
        this.totalFare = totalFare;
        this.rides = rides;
        this.averageFare = this.totalFare / this.rides;
    }

    public int getRides() {
        return rides;
    }

    public Object getAverageFare() {
        return averageFare;
    }
}



package com.bridgelabz;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CabInvoiceGeneratorTesting {

    CabInvoiceGenerator invoice = null;

    @BeforeEach
    public void initialize_object() {
        invoice = new CabInvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_Generate_total_fareOfJourney() {
        double distance = 5.0;
        int time = 20;
        double fare = invoice.calculateNormalFare(distance, time);
        System.out.println(fare);
        Assertions.assertEquals(70, fare, 0.0);
    }
    @Test
    public void givenSmalldistanceAndTime_shouldReturn_MinimumFare() {
        double distance = 0.2;
        int time = 2;
        double fare = invoice.calculateNormalFare(distance, time);
        System.out.println(fare);
        Assertions.assertEquals(5, fare, 0.0);
    }

    @Test
    public void given_multipleRide_shouldreturn_totalfare() {
        Ride[] rides = {new Ride(2.0, 5, "NORMAL"),
                new Ride(4.0, 5, "NORMAL"),
                new Ride(7.0, 3, "NORMAL")};
        double fare = invoice.calculateFare(rides);
        Assertions.assertEquals(143.0, fare);
    }
    @Test
    public void given_multipleRide_shouldreturn_InvoiceSummary() {
        Ride[] rides = {new Ride(2.0, 5, "NORMAL"),
                new Ride(4.0, 5, "NORMAL"),
                new Ride(7.0, 3, "NORMAL")};
        InvoiceSummary expectedSummary = new InvoiceSummary(143.0, 3);
        System.out.println("Total no of rides=" + expectedSummary.getRides());
        System.out.println("Avarage=" + expectedSummary.getAverageFare());
        InvoiceSummary summary = invoice.calculateInvoiceSummary(rides);
        System.out.println("Invoice summary=" + summary.getAverageFare());
        Assertions.assertEquals(expectedSummary.getAverageFare(), summary.getAverageFare());
    }
    @Test
    public void givenUserId_InvoiceGenerator_shouldReturn_ListOfRideHistory_AndInvoiceSummary() {
        String userId = "12345abcd";
        Ride[] rides = {new Ride(2.0, 5, "NORMAL"),
                new Ride(4.0, 5, "NORMAL"),
                new Ride(7.0, 3, "NORMAL")};
        invoice.addRidesForPerticularUser(userId, rides);
        InvoiceSummary summary = invoice.getInvoiceSummary(userId);
        System.out.println("no of rides= " + summary.getRides() + " and Avarage = " + summary.getAverageFare());

        InvoiceSummary expectedSummary = new InvoiceSummary(143.0, 3);
        System.out.println("expected no of rides = " + expectedSummary.getRides() +
                " and expected Avarage = " + expectedSummary.getAverageFare());
        Assertions.assertEquals(expectedSummary.getRides(), summary.getRides());
    }


}

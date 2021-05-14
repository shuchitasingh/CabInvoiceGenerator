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


}

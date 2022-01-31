package com.geektrust.backend.billgenerationtest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.geektrust.backend.services.billgeneration.CorporationWaterBill;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
//Using Mockito for unit testing
public class CorporationWaterBillTest {
    // Using Mock to create and inject mocked instances
    @Mock CorporationWaterBill service;

    @BeforeEach
    void setUp()
    {
        service = new CorporationWaterBill(5,5,30,1);

    }
    //People = 5
    //Litre = 5
    //Days = 30
    //Ratio = 1
    //Borewell water = 5*5*30*1 = 750 
    @Test
    public void testCorporationBill()
    {
        assertEquals(750.0,service.generateBill());
    }
}
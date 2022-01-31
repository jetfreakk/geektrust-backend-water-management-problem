package com.geektrust.backend.billgenerationtest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.geektrust.backend.services.billgeneration.BoreWellWaterBill;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class BoreWellWaterTest {
     // Using Mock to create and inject mocked instances
    @Mock BoreWellWaterBill service;

    @BeforeEach
    void setUp()
    {
        service = new BoreWellWaterBill(5,5,30,1);

    }
    //People = 5
    //Litre = 5
    //Days = 30
    //Ratio = 1
    //Borewell water = 750*1.5 = 1125
    @Test
    public void testBoreWellBill()
    {
        assertEquals(1125.0,service.generateBill());
    }
}
package com.geektrust.backend.billgenerationtest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.geektrust.backend.services.billgeneration.TankWaterBill;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class TankWaterBillTest {
     // Using Mock to create and inject mocked instances
    @Mock TankWaterBill service;

    @BeforeEach
    void setUp()
    {
        service = new TankWaterBill(5,10,30);

    }
    //People = 5
    //Litre = 10
    //Days = 30
    //Borewell water = 1000(Slab1) + 3000(Slab2) => 4000

    @Test
    public void testTankWaterBill()
    {
        assertEquals(4000.0,service.generateBill());
    }
    
}
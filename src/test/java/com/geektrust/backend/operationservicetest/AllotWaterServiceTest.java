package com.geektrust.backend.operationservicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import com.geektrust.backend.model.GeekHeights;
import com.geektrust.backend.services.operationservice.AllotWaterService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class AllotWaterServiceTest {
    // Using Mock to create and inject mocked instances
    @Mock AllotWaterService service;
    @Mock  GeekHeights c;

    @BeforeEach 

    void setup()
    {
        service = AllotWaterService.getI();
        c = new GeekHeights(10,30);

    }

    @Test

    public void testWater()
    {
        service.process(Arrays.asList("2", "1:3"), c);
        assertEquals(Integer.valueOf(3), c.getTotal_People());
        assertTrue(c.isInitialized());
      
    }
}
package com.geektrust.backend.operationservicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;

import com.geektrust.backend.enums.ApartmentType;
import com.geektrust.backend.model.GeekHeights;
import com.geektrust.backend.services.operationservice.AddGuestsService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class AddGuestsServiceTest {
    // Using Mock to create and inject mocked instances
  @Mock AddGuestsService service;
  @Mock GeekHeights c;

  @BeforeEach
  void setUp() {
    service = AddGuestsService.getI();
    c= new GeekHeights(10, 30);
  }

  @Test
  public void testAddGuest() {
    c.initializeCommunityBill(ApartmentType.TWO_BEDROOM, 3, 10);  
    service.process(Collections.singletonList("5"), c);
    //Should return 8 people as 5 guests and 3 in 2 bedroom 
    assertEquals(Integer.valueOf(8), c.getTotal_People());  
  }
}

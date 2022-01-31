package com.geektrust.backend.operationservicetest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.geektrust.backend.enums.ApartmentType;
import com.geektrust.backend.model.GeekHeights;
import com.geektrust.backend.services.operationservice.BillOpsService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

public class BillOpsServiceTest {
    @Mock BillOpsService service;
    @Mock GeekHeights c;

    @BeforeEach
    void setup()
    {
        service = BillOpsService.getI();
        c = new GeekHeights(10,30);
        c.initializeCommunityBill(ApartmentType.TWO_BEDROOM, 3, 10);
    }

    @Test
  public void testNoGuest() {
    assertEquals("900 1215", service.process(null, c));
    //Should return <TOTAL_WATER_CONSUMED_IN_LITERS> <TOTAL_COST>
    // 900 liters (3*10*30) and 1215 rs
  }

  @Test
  public void testGuest() {
    c.addGuests(10);
    assertEquals("3900 12715", service.process(null, c));
    //Should return <TOTAL_WATER_CONSUMED_IN_LITERS> <TOTAL_COST>
    // 3900 liters (3*10*30 + 10*10*30) and 12715 rs

  }

}
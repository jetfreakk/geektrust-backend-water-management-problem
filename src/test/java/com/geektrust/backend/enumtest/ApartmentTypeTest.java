package com.geektrust.backend.enumtest;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.geektrust.backend.enums.ApartmentType;
import com.geektrust.backend.exceptions.WaterException;

class ApartmentTypeTest {

  @Test
  public void testValidEntry() {
    //Checking valid entry as TWO BEDROOM = 2 and THREE BEDROOM = 3
    assertEquals(ApartmentType.TWO_BEDROOM, ApartmentType.NumberRooms(2));
    assertEquals(ApartmentType.THREE_BEDROOM, ApartmentType.NumberRooms(3));
  }

  @Test
  public void testInValidEntry() {
      //Only 2 and 3 BHK allowed hence any other entry should throw error
    assertThrows(WaterException.class, () -> ApartmentType.NumberRooms(1));
  }
}

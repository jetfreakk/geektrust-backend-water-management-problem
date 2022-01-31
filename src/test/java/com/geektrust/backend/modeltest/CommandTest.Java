package com.geektrust.backend.model;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.geektrust.backend.enums.Operations;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

class CommandTest {
  @Mock Command command;

  @BeforeEach
  void setUp() {
    command = Mockito.mock(Command.class);
  }

  @Test
  void testValidInput1() {
    String input = "ALLOT_WATER 3 1:5";
    Command command = Command.from(input);
    assertEquals(Operations.ALLOT_WATER, command.getOperation());
    assertEquals(Arrays.asList("3", "1:5"), command.getOperands());
    
  }
@Test
void testValidInput2()
{
  String input = "BILL";
  command = Command.from(input);
  assertEquals(Operations.BILL, command.getOperation());
  assertEquals(Collections.emptyList(), command.getOperands());
}

  @Test
  void testValidArgument() {
    final String input = "ALLOT_WATER 4 1:3";
    assertDoesNotThrow(() -> Command.from(input));
    final String anotherInput = "ADD_GUESTS 15";
    assertDoesNotThrow(() -> Command.from(anotherInput));
  }

  @Test
  void testInValidOperation() {
    final String input = "ADD_GUESTS 13 2";
    assertThrows(UnsupportedOperationException.class, () -> Command.from(input));
    final String anotherInput = "ALLOT_WATER 32";
    assertThrows(UnsupportedOperationException.class, () -> Command.from(anotherInput)); 
  }

  @Test
  void testConstructorWithNullValues() {
    assertThrows(NullPointerException.class, () -> new Command(Operations.ALLOT_WATER, null));
    assertThrows(NullPointerException.class, () -> new Command(null, new ArrayList<>()));
    assertThrows(NullPointerException.class, () -> new Command(null, null));
  }
}

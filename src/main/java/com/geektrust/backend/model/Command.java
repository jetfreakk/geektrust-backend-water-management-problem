package com.geektrust.backend.model;

import com.geektrust.backend.enums.Operations;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.stream.Collectors;

// To check the command from the csv file. The csv file is first processed through FileProcessor.java and then list of commands is generated from this class

public class Command {
    //Operations like ALLOT_WATER, ADD_GUESTS
    //Operands are the integers
     private Operations operation;
     private List<String> operands;
    //Constrcutor call
    //If check for null input
    public Command(Operations operation, List<String> operands) {
     this.operation = operation;
     if (operation == null) throw new NullPointerException("Null");
      this.operands = operands;
      if (operands == null) throw new NullPointerException("Null");
    }
    //from command to get the parameters for operation
    public static Command from(String str) {
        try {
          String[] commandWithArguments = str.split(" ");
          Operations operation = Operations.valueOf(commandWithArguments[0]);
          List<String> operands =
              Arrays.stream(commandWithArguments).skip(1).collect(Collectors.toList());
          Command command = new Command(operation, operands);
          command.validateOperation();
          return command;
        } catch (Exception e) {
          throw new UnsupportedOperationException("Invalid Command");
        }
      }
      // Function to check for operation. If the arguments don't match, throw exception
      public void validateOperation() {
        if (this.operation.getNumberofArguments() != operands.size()) {
          throw new InputMismatchException("The number of arguments incorrect.");
        }
      }
      //Getters and Setter for entities
      public Operations getOperation() {
        return operation;
      }

      public void setOperation(Operations operation) {
        this.operation = operation;
      }

      public List<String> getOperands() {
        return operands;
      }

      public void setOperands(List<String> operands) {
        this.operands = operands;
      }

    
}
package com.geektrust.backend;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import com.geektrust.backend.exceptions.WaterException;
import com.geektrust.backend.model.Command;
import com.geektrust.backend.model.GeekHeights;
import com.geektrust.backend.services.FileProcessor.FileProcessor;

public class App {
	//Created as per GeekHeights, can be changed later
	static Integer ALLOCATED_WATER = 10;
	static Integer BILLABLE_DAYS = 30;

	public static void main(String[] args) {
		try {
			// Checking if file is present
			if (args.length != 1) {
				throw new WaterException("No Input File");
			}
			// Reading file
			String Path = args[0];
			// Passing through fileprocessor
			FileProcessor readfile = new FileProcessor(Path);
			// Generating list of commands
			List<Command> cmds = readfile.getCommands();
			// Creating object of the community and passing 10 litres per day and billable
			// days as 30
			GeekHeights ghcomm = new GeekHeights(ALLOCATED_WATER, BILLABLE_DAYS);
	//Generating outputs and storing as string
	List<String> outputs = cmds.stream().map(cmd ->cmd.getOperation().getOperationService().get().process(cmd.getOperands(), ghcomm))
		.filter(Objects::nonNull)
		.collect(Collectors.toList());
outputs.forEach(System.out::println);
	}
	catch (Exception e) {
		//If exception found 
		System.out.println("Error");
	  }

}
}

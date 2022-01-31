package com.geektrust.backend.services.FileProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.geektrust.backend.exceptions.WaterException;
import com.geektrust.backend.model.Command;
//To get input from CSV file
public class FileProcessor{
    private String FilePath;
    public List<Command>  getCommands() {
        try (Stream<String> lines = Files.lines(Paths.get(this.FilePath)))
        {
            return lines.filter(line->!isEmpty(line)).map(Command::from).collect(Collectors.toList());
        }
        catch(IOException e)
        {
            throw new WaterException("Error");
        }
    }
    // Flagging If the file is empty
    private boolean isEmpty(String l)
    {
        return l.isEmpty() || l.trim().isEmpty();
        
    }
    //Constructor Call
    public FileProcessor(String FilePath)
    {
        this.FilePath = FilePath;
    }
}
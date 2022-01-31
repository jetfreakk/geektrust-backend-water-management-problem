package com.geektrust.backend.exceptions;

//Exception class for the whole program. Her using Runtimexception as it is unchecked
public class WaterException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    public static final String INVALID_COMMAND = "Invalid";
    //Using super to directly refer to Runtimeexception
    public WaterException()
    {
        super();
    }
    public WaterException(final String m)
    {
        super(m);
    }
    
}
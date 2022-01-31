package com.geektrust.backend.services.operationservice;

import java.util.List;

import com.geektrust.backend.exceptions.WaterException;
import com.geektrust.backend.model.CommunityBill;

public class AddGuestsService implements OperationService {
    //Creating instance of AddGuests
 private static final AddGuestsService i = new AddGuestsService();

    private AddGuestsService(){}
    //Method to add guests if not initialized throw error
    @Override
    public String process(List<String> args, CommunityBill c) throws WaterException {
       int guest = Integer.parseInt(args.get(0));
       if(c.isInitialized()==false)
        throw new WaterException("Invalid");

       c.addGuests(guest);
       return null;
    }

    public static AddGuestsService getI() {
        return i;
    }
    
}
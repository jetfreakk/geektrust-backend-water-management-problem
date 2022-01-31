package com.geektrust.backend.services.operationservice;

import java.util.List;

import com.geektrust.backend.enums.ApartmentType;
import com.geektrust.backend.exceptions.WaterException;
import com.geektrust.backend.model.CommunityBill;

public class AllotWaterService implements OperationService {
    //Creating instance of AllotWater
    private static final AllotWaterService i= new AllotWaterService();
    private AllotWaterService(){}
    //Method to allot water as per the Apartment  if not initialized throw error
    @Override
    public String process(List<String> args, CommunityBill c) throws WaterException {
        int rooms = Integer.parseInt(args.get(0));
        String[] s = args.get(1).split(":");
        c.initializeCommunityBill(ApartmentType.NumberRooms(rooms), Integer.parseInt(s[0]),(Integer.parseInt(s[0]) + Integer.parseInt(s[1])));
        return null;
    }

    public static AllotWaterService getI() {
        return i;
    }
    
}
package com.geektrust.backend.services.operationservice;

import java.util.List;

import com.geektrust.backend.exceptions.WaterException;
import com.geektrust.backend.model.CommunityBill;
//Interface for Operations (Allot Water, Add Guests, Bill)
public interface OperationService {
    
    String process(List<String> args, CommunityBill c) throws WaterException;   
    
}
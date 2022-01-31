package com.geektrust.backend.enums;

import java.util.function.Supplier;

import com.geektrust.backend.services.operationservice.AddGuestsService;
import com.geektrust.backend.services.operationservice.AllotWaterService;
import com.geektrust.backend.services.operationservice.BillOpsService;
import com.geektrust.backend.services.operationservice.OperationService;

public enum Operations {
    
    //Since we will only have 3 types of operations to perform, we set them as enums
    // Syntax OPERATION_TYPE(Argument Number, Instance of OPERATION_TYPE)
    ALLOT_WATER(2, AllotWaterService::getI),
    ADD_GUESTS(1, AddGuestsService::getI),
    BILL(0, BillOpsService::getI);

    private Integer nArgs;
    //Here we use supplier as the instance type varies as per the operation
    private Supplier<? extends OperationService> oService;
    //Parametrized constructor call
    Operations(int nArgs, Supplier<? extends OperationService> oService)
    {
        this.nArgs = nArgs;
        this.oService = oService;
    }
    //Getters for the entities. No setters used as this will only be input from the csv file
    public Integer getNumberofArguments() {
        return nArgs;
    }


    public Supplier<? extends OperationService> getOperationService() {
        return oService;
    }

    

    
}
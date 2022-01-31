package com.geektrust.backend.services.billgeneration;

public class TankWaterBill extends BillGenerationService{
    //TankWaterBill
    public TankWaterBill(int people, int litres, int days) {
        super(people, litres, days, 1);
    }
    //Ensuring non-null with varying rate
    
    @Override
    protected void updateMaxBill() {
        getmaxBillRate().put(500,2.0);
        getmaxBillRate().put(1500,3.0);
        getmaxBillRate().put(3000,5.0);
        getmaxBillRate().put(Integer.MAX_VALUE,8.0);
        
    }
    
    
}
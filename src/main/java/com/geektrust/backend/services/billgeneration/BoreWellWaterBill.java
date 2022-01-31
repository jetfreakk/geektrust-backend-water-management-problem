package com.geektrust.backend.services.billgeneration;

public class BoreWellWaterBill extends BillGenerationService{
    //Borewell Bill 
    public BoreWellWaterBill(int people, int litres, int days, double ratio) {
        super(people, litres, days, ratio);
    }
    //Ensuring non-null value and 1.5 flat rate
    
    @Override
    protected void updateMaxBill() {
        getmaxBillRate().put(Integer.MAX_VALUE, 1.5);            
    }
    
}
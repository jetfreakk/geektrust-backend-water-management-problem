package com.geektrust.backend.services.billgeneration;

public class CorporationWaterBill extends BillGenerationService{
    //Corporation Bill
    public CorporationWaterBill(int people, int litres, int days, double ratio) {
        super(people, litres, days, ratio);
    }
    //Ensuring non-null with 1.0 flat rate
    @Override
    protected void updateMaxBill() {
            getmaxBillRate().put(Integer.MAX_VALUE,1.0);
    }
    
}
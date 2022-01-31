package com.geektrust.backend.model;

import com.geektrust.backend.exceptions.WaterException;
//Class for geeksheighscommunity extends the communitybill class
public class GeekHeights extends CommunityBill{

    public GeekHeights(Integer allocatedWater, Integer numberOfDays) {
        super(allocatedWater, numberOfDays);
    }
    //Method to get total number of people
    @Override
    public Integer getTotal_People() {
        if(isInitialized()==false)
            throw new WaterException("Exception");
        return getApartmentType().getnPeople() + getGuest();
        }
    //Method to get total water consumption
    @Override
    public Integer getTotal_Water() {
        if(isInitialized()==false)
            throw new WaterException("Exception");
        return getNumberOfDays()*getTotal_People()*getAllocatedWater();
    }
    
}
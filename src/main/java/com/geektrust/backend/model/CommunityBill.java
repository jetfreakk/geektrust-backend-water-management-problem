package com.geektrust.backend.model;

import java.util.Objects;

import com.geektrust.backend.enums.ApartmentType;
import com.geektrust.backend.exceptions.WaterException;
// An abstract class which can be xtended by any other community. In our case it is GeekHeights but lets say if any aparatment XYZ comes up they can also
//extend this class
public abstract class CommunityBill {
    //AllocatedWaterperperson variable
    private final Integer allocatedWater;
    //NumberofDaystobeConsideredInAMonth(30 in our case)
    private final Integer numberOfDays;
    //TypeofApartment
    private ApartmentType apartmentType;
    //Setter
    public void setapartmentType(ApartmentType apartmentType)
    {
            this.apartmentType =apartmentType;
    }
    //CorporationShare
    private Integer cShare;
    //TotalShare
    private Integer tShare;
    //NumberofGuests
    private int guest;
    //Setter for Guests
    public void setguest(int guest)
    {
        this.guest = guest;
    }
    //Parameterized Constructor call
    public CommunityBill(
      Integer allocatedWater, Integer numberOfDays) {
      this.allocatedWater = allocatedWater;
      this.numberOfDays= numberOfDays;
    }
    //Function to add guests
    public void addGuests(int guest) {
      if (isInitialized()==false) {
        throw new WaterException("Apartment Type Invalid");
      }
      this.guest += guest;
    }
    //Get total people (people in apartment + guest)
    public abstract Integer getTotal_People();
    //Get total water consumption
    public abstract Integer getTotal_Water();
  
    //Prepare bill as per the share
    public void initializeCommunityBill(
        ApartmentType apartmentType,
        Integer cShare,
        Integer tShare) {
      this.tShare = tShare;
      this.cShare = cShare;
      this.apartmentType = apartmentType;
    }

    public boolean isInitialized() {
      return Objects.nonNull(apartmentType)
          && Objects.nonNull(tShare)
          && Objects.nonNull(cShare);
    }
    //Getters and Setters
    public Integer getAllocatedWater() {
        return allocatedWater;
    }

    public Integer getNumberOfDays() {
        return numberOfDays;
    }

    public ApartmentType getApartmentType() {
        return apartmentType;
    }

    public void setApartmentType(ApartmentType apartmentType) {
        this.apartmentType = apartmentType;
    }

    public Integer getcShare() {
        return cShare;
    }

    public void setcShare(Integer cShare) {
        this.cShare = cShare;
    }

    public Integer gettShare() {
        return tShare;
    }

    public void settShare(Integer tShare) {
        this.tShare = tShare;
    }

    public int getGuest() {
        return guest;
    }

    public void setGuest(int guest) {
        this.guest = guest;
    }
    
}
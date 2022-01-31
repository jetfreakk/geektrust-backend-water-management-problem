package com.geektrust.backend.enums;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.geektrust.backend.exceptions.WaterException;
public enum ApartmentType
{
    //Since we will only have 2 types of apartment, we set them as enums
    // Syntax APARTMENT_TYPE(No. of rooms, No. of People)
    TWO_BEDROOM(2,3),
    THREE_BEDROOM(3,5);
    //Storing the same in Hashmap
    private static Map<Integer, ApartmentType> findType = new HashMap<>();
    //Parametrized constructor call
    ApartmentType(int nRooms,int nPeople)
    {
    this.nPeople = nPeople;
    this.nRooms = nRooms;
    }
    
    static {
        findType =
            Arrays.stream(ApartmentType.values())
                .collect(Collectors.toMap(ApartmentType::getnRooms, Function.identity()));
      }

    private Integer nRooms;
    private Integer nPeople;
    //Function to return the ApartmentType based on number of rooms, if none then throw exception
    public static ApartmentType NumberRooms(int rooms) throws WaterException
    {
        return Optional.ofNullable(findType.get(rooms)).orElseThrow(()-> new WaterException(WaterException.INVALID_COMMAND));
    }

    //Getters and Setters for nRooms and nPeople
    public Integer getnRooms() {
        return nRooms;
    }

    public void setnRooms(Integer nRooms) {
        this.nRooms = nRooms;
    }

    public Integer getnPeople() {
        return nPeople;
    }

    public void setnPeople(Integer nPeople) {
        this.nPeople = nPeople;
    }
    

}

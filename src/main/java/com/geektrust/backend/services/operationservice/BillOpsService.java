package com.geektrust.backend.services.operationservice;

import java.util.List;
import java.util.StringJoiner;

import com.geektrust.backend.exceptions.WaterException;
import com.geektrust.backend.model.CommunityBill;
import com.geektrust.backend.services.billgeneration.BoreWellWaterBill;
import com.geektrust.backend.services.billgeneration.CorporationWaterBill;
import com.geektrust.backend.services.billgeneration.TankWaterBill;
//Generate Bill
public class BillOpsService implements OperationService {
    //Creating instance of BillOps
    private static final BillOpsService i = new BillOpsService();

     private BillOpsService() {}
    
     @Override
    public String process(List<String> args, CommunityBill c) throws WaterException {
        StringJoiner final_bill = new StringJoiner(" ");
        final_bill.add(Integer.toString(c.getTotal_Water()));
        double totalbill = 0.0;
//Total Bill =Corp Bill + Borewell Bill + Tank Bill
        totalbill +=
        new CorporationWaterBill(
                c.getApartmentType().getnPeople(),
                c.getAllocatedWater(),
                c.getNumberOfDays(),
                1.0 * c.getcShare() / c.gettShare())
            .generateBill()
+
        new BoreWellWaterBill(
                c.getApartmentType().getnPeople(),
                c.getAllocatedWater(),
                c.getNumberOfDays(),
                1.0
                    * (c.gettShare() - c.getcShare())
                    / c.gettShare())
            .generateBill()
+
        new TankWaterBill(
                c.getGuest(),
                c.getAllocatedWater(),
                c.getNumberOfDays()).generateBill();
    final_bill.add(Integer.toString((int) Math.ceil(totalbill)));
    return final_bill.toString();
  }
  //Get instance method
  public static BillOpsService getI() {
      return i;
  }
    }
    

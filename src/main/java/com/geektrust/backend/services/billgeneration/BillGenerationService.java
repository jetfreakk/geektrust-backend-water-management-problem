package com.geektrust.backend.services.billgeneration;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public abstract class BillGenerationService {
    private final Map<Integer, Double> maxBillRate;
    public Map<Integer,Double> getmaxBillRate() {
        return maxBillRate;
    }
    
    private final int people;
    private final int litres;
    private final int days;
    private final double ratio;
  
    public BillGenerationService(int people, int litres, int days, double ratio) {
      this.maxBillRate = new HashMap<>();
      this.people = people;
      this.litres = litres;
      this.days = days;
      this.ratio = ratio;
      updateMaxBill();
    }
    //Ensuring non-null value
    protected abstract void updateMaxBill();
    //Bill generation as per the ask
    //1. Corporation Water - Flat rate of Rs. 1 per litre
    //2. Borewell Water - Flat rate of Rs. 1.5 per litre
    /*3. Tanker Water - Slab rate:

  • 0 to 500L - Rs. 2 per litre
  • 501L to 1500L - Rs. 3 per litre
  • 1501 to 3000L - Rs. 5 per litre
  • 3001L+ - Rs. 8 per litre*/
    public double generateBill() {
  
      double tConsumption = litres * days * ratio * people;
      double tbill = 0;
      List<Integer> slabs = maxBillRate.keySet().stream().sorted().collect(Collectors.toList());
      int pslablimit = 0;
      for (int slab : slabs) {
        int slabDiff = slab - pslablimit;
        double slabRate = maxBillRate.get(slab);
        if (tConsumption > slabDiff) {
          tConsumption -= slabDiff;
          tbill = tbill + slabDiff * slabRate;
        } else {
          tbill = tbill + tConsumption * slabRate;
          tConsumption = 0;
        }
        pslablimit = slab;
      }
      if (tConsumption > 0) {
        tbill = tbill + tConsumption * maxBillRate.get(Integer.MAX_VALUE);
        tConsumption = 0;
      }
  
      return tbill;
    }
  }
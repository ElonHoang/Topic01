package com.fis.model;

import java.util.ArrayList;
import java.util.List;

public class PhieuTongKet {
    public List<Phieuxedap> xd = new ArrayList<>();
    public List<Phieuxemay> xm = new ArrayList<>();
    public void fakeData(){
        Phieuxedap xd0 = new Phieuxedap(57);
        Phieuxedap xd1 = new Phieuxedap(58);

        Phieuxemay xm0 = new Phieuxemay(11,"3334");
        Phieuxemay xm1 = new Phieuxemay(12,"888");

        xd.add(xd0);
        xd.add(xd1);
        xm.add(xm0);
        xm.add(xm1);
    }
    public  long countSumAllBikeMotoBike(){
        return countSumBike() + countSumMotoBike();
    }
    public  long countSumBike(){
        //
        return xd.stream().count();
    }
    public  long countSumMotoBike(){

        return xm.stream().count();
    }
    public  long countSumPriceCar(){
        return(countSumMotoBike() * 1000) + (countSumBike() * 500);
    }
    public  long countSumTax(){
        return countSumPriceCar() * 10 / 100;
    }
    public  long countSumLaborCosts(){
        return 100 * countSumBike();
    }
    public  long countInterest(){
        return countSumPriceCar() - (countSumTax() + countSumLaborCosts());
    }
}

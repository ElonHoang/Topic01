package com.fis.model;

import java.util.ArrayList;
import java.util.List;

public class MainApplication {
    public static void main(String[] args) {
//        List<Phieuxedap> list = new ArrayList<>();
//        List<Phieuxemay> xm = new ArrayList<>();
//        Phieuxedap xd0 = new Phieuxedap(57);
//        Phieuxedap xd1 = new Phieuxedap(58);
//
//        Phieuxemay xm0 = new Phieuxemay(11,"3334");
//        Phieuxemay xm1 = new Phieuxemay(12,"888");
//
//        list.add(xd0);
//        list.add(xd1);
//        xm.add(xm0);
//        xm.add(xm1);
        //Phieuxemay xm = new Phieuxemay("38F11G",11,44,55,10);
        PhieuTongKet p = new PhieuTongKet();
//        p.xd = list;
//        p.xm =xm;
        p.fakeData();
       // System.out.println(list.stream().count());
        System.out.println(p.countInterest());

    }
}

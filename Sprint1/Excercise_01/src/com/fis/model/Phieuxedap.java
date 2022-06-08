package com.fis.model;

public class Phieuxedap extends Baigiuxe {

    public Phieuxedap(){
        super(0,500,100,10);
    }
    public Phieuxedap(int soPhieu){
        super(soPhieu);
    }
    public Phieuxedap(int soPhieu, int gia, int chiphi, int thue){
        super(soPhieu,gia,chiphi,thue);
    }



}

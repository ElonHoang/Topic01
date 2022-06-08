package com.example;

import java.io.Serializable;
import java.util.Objects;

public class Diem implements Comparable<Diem>, Serializable {
    private MonHoc mon;
    private int diem;
    public Diem(MonHoc mon, int diem) {
        this.mon = mon;
        this.diem = diem;
    }

    public MonHoc getMon() {
        return this.mon;
    }

    public void setMon(MonHoc mon) {
        this.mon = mon;
    }

    public int getDiem() {
        return this.diem;
    }

    public void setDiem(int diem) {
        this.diem = diem;
    }

    @Override
    public int compareTo(Diem o) {
        if (this.getDiem() > o.getDiem()) {
            return 1;
        } else if (this.getDiem() < o.getDiem()){
            return -1;
        }else
            return 0;
}
    public  double getSum(){
        return this.getDiem() * (this.getMon().getTcLT() + this.mon.getTcTH());
    }
    public double getSumTc(){
        return this.mon.getTcLT() + this.mon.getTcTH();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Diem)) return false;
        Diem diem1 = (Diem) o;
        return diem == diem1.diem && mon.equals(diem1.mon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mon, diem);
    }

    @Override
    public Diem clone() {
        Diem diem  = new Diem(this.mon,this.diem);
        return diem;
    }

    @Override
    public String toString() {
        return "Diem{" +
                "mon=" + mon +
                ", diem=" + diem +
                '}';
    }
}

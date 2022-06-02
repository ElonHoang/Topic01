package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;

public class MonHoc {
    private String ten;
    private int tcLT;
    private int tcTH;
    private List<MonHoc> monHocList = new ArrayList<>();
    public MonHoc(String ten, int tcLT, int tcTH) {
        this.ten = ten;
        this.tcLT = tcLT;
        this.tcTH = tcTH;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public int getTcLT() {
        return tcLT;
    }

    public void setTcLT(int tcLT) {
        this.tcLT = tcLT;
    }

    public int getTcTH() {
        return tcTH;
    }

    public void setTcTH(int tcTH) {
        this.tcTH = tcTH;
    }

    public boolean equals(Object that) {
        //Hai mon duoc goi la bang nhau neu cung ten mon
        if (that instanceof MonHoc) {
            return ((MonHoc) that).ten.equals(this.ten);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ten, tcLT, tcTH, monHocList);
    }

    @Override
    public String toString() {
        return "MonHoc{" +
                "ten='" + ten + '\'' +
                ", tcLT=" + tcLT +
                ", tcTH=" + tcTH +
                ", monHocList=" + monHocList +
                '}';
    }
}

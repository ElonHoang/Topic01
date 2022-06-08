package com.example;

import java.util.*;

public class SinhVien {
    private String mssv;
    private String ten;

    private Set<Diem> monDaHoc = new HashSet<>();
    private List<MonHoc> monHocList = new ArrayList<>();
    public SinhVien(String mssv, String ten) {
        this.mssv = mssv;
        this.ten = ten;
    }

    public String getMssv() {
        return mssv;
    }

    public void setMssv(String mssv) {
        this.mssv = mssv;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SinhVien)) return false;
        SinhVien sinhVien = (SinhVien) o;
        return mssv.equals(sinhVien.mssv) && ten.equals(sinhVien.ten) && monDaHoc.equals(sinhVien.monDaHoc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mssv, ten, monDaHoc);
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "mssv='" + mssv + '\'' +
                ", ten='" + ten + '\'' +
                ", monDaHoc=" + monDaHoc +
                '}';
    }

    public boolean themDiem(Diem diemMoi) {
        return this.monDaHoc.add(diemMoi);
    }

    //TODO Cau 1
    public double tinhDiemTrungBinh() {
        //Giong nhu cach tinh hien tai cua truong

        //...
//        OptionalDouble cal  ;
//        cal = monDaHoc.stream()
//                            .mapToDouble(t->t.getDiem())
//                            .average();
//        return cal.isPresent() ? cal.getAsDouble() : 0.0;
        OptionalDouble calSum ;
        calSum = OptionalDouble.of(monDaHoc.stream()
                .mapToDouble(t->t.getSum())
                .sum());
        OptionalDouble calSumtc;
        calSumtc = OptionalDouble.of(monDaHoc.stream()
                .mapToDouble(t->t.getSumTc())
                .sum());
        return calSum.isPresent() && calSumtc.isPresent() ? calSum.getAsDouble() / calSumtc.getAsDouble() : 0.0;
    }


    //TODO Cau 2
    public String bangDiem() {
    /*
     MSSV : 0203044
     Ten  : Nguyen Van A
     Danh Sach Diem
     STT  Ten Mon             Diem       So Tin Chi
     1    Cau Truc Du Lieu 1  8          3
     2    Cau Truc Du Lieu 2  8          3
     Diem Trung Binh   8.0
    */
        //...
        //StringBuilder

        int count = 1;
        StringBuilder sbd = new StringBuilder();
        sbd.append(String.format("MSSV : %-4s \n", getMssv()));
        sbd.append(String.format("Ten  : %-4s \n", getTen()));
        sbd.append(String.format("%-4s","Danh sach diem \n"));
        sbd.append(String.format("%-4s  %-20s  %-4s  %-4s \n", "STT","Ten Mon","Diem","So Tin Chi"));
        for(Diem d: monDaHoc) {
            sbd.append(String.format(" %-3s  %-20s  %-3s  %-4s \n", count,d.getMon().getTen(),d.getDiem(),(int)d.getSumTc()));
            count++;
        }
        sbd.append(String.format( "Diem trung binh : %5s \n",Math.ceil(tinhDiemTrungBinh()*100.0)/100.0));
        return sbd.toString();
    }


    //TODO Cau 3
    public String xepLoai() {
    /*
    Quy tac xep loai nhu sau
        DiemTB < 5 -> YEU
        DiemTB >= 5 va DiemTB < 6 -> TB
        DiemTB >= 6 va DiemTB < 7 -> TB-KHA
        DiemTB >= 7 va DiemTB < 8 -> KHA
        DiemTB >= 8 -> GIOI
    */
        double check = tinhDiemTrungBinh();
        return check < 5 ? "YEU" : check >= 5
                && check < 6 ? "TB" : check >= 6
                && check < 7 ? "TB_KHA" : check >= 7
                && check < 8 ? "KHA" : check >= 8 ? "GIOI" : "Error";
    }


}

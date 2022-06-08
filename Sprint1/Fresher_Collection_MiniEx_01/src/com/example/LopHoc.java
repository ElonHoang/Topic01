package com.example;

import java.util.*;
import java.util.stream.Collectors;

public class LopHoc {
    private String ten;
    private String giaoVien;
    private List<SinhVien> dsLop = new ArrayList<SinhVien>();

    public LopHoc(String ten, String giaoVien) {
        this.ten = ten;
        this.giaoVien = giaoVien;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getGiaoVien() {
        return giaoVien;
    }

    public void setGiaoVien(String giaoVien) {
        this.giaoVien = giaoVien;
    }

    public List<SinhVien> getDsLop() {
        return dsLop;
    }

    public void setDsLop(List<SinhVien> dsLop) {
        this.dsLop = dsLop;
    }



    public boolean them(SinhVien svMoi) {
        return dsLop.add(svMoi);
    }

    //TODO Cau 4
    public String inDiem() {
    /*
    Danh Sach Diem Lop : ten
    Giao Vien Chu Nhiem : giaoVien
    STT      MSSV        Ten              Diem TB   XepLoai
    1        123456      Nguyen Van A     8.4       GIOI
    2        678919      Nguyen Van B     6         TB-KHA
    3        112456      Nguyen Van C     7         KHA
    */
        //...
        int count = 1;
        StringBuilder sbd = new StringBuilder();
        sbd.append(String.format("Danh Sach Diem Lop : %-4s \n", getTen()));
        sbd.append(String.format("Giao Vien Chu Nhiem  : %-4s \n", getGiaoVien()));
        sbd.append(String.format("%-4s  %-20s  %-14s  %-4s  %-4s \n", "STT","MSSV","Ten","Diem TB","XepLoai"));
        for(SinhVien d: dsLop) {
            sbd.append(String.format(" %-3s  %-20s  %-14s  %-6s  %-5s \n", count,d.getMssv(),d.getTen(),d.tinhDiemTrungBinh(),d.xepLoai()));
            count++;
        }
        return sbd.toString();
    }

    //TODO Cau 5
    public List<SinhVien> top10() {
        //Tra ve danh sach 10 sinh vien co diem trung binh lon nhat lop
        //...

        Comparator<SinhVien> maxcomparator = Comparator.comparingDouble(t->t.tinhDiemTrungBinh());
        List<SinhVien> rs = dsLop.stream()
                .sorted(maxcomparator.reversed())
                .limit(10)
                .collect(Collectors.toList())
                ;
        return rs;
    }

    //TODO Cau 6
    public List<SinhVien> sinhVienYeu() {
        //Tra ve danh sach vien vien xep loai YEU
        //...
        List<SinhVien> list = dsLop.stream()
                .filter(t->t.xepLoai().equalsIgnoreCase("YEU"))
                .collect(Collectors.toList());
        return list;
    }

    @Override
    public String toString() {
        return "LopHoc{" +
                "ten='" + ten + '\'' +
                ", giaoVien='" + giaoVien + '\'' +
                ", dsLop=" + dsLop +
                '}';
    }
}

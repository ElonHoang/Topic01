package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SinhVienTest {

    @Test
    void themDiem() {
        SinhVien s = new SinhVien("hoang","h");
        s.themDiem(new Diem(new MonHoc("hh",1,1),5));

    }

    @Test
    void tinhDiemTrungBinh() {

        MonHoc m = new MonHoc("qq",2,1);
        MonHoc m1 = new MonHoc("qq",2,1);

        Diem d = new Diem(m,8);
        Diem e = new Diem(m1,8);
        SinhVien s = new SinhVien("qq1","Hoang");
        s.themDiem(d);
        s.themDiem(e);
        assertEquals(8.0,s.tinhDiemTrungBinh(),0.000000001);
    }

    @Test
    void bangDiem() {
        MonHoc m = new MonHoc("qq",2,1);
        MonHoc m1 = new MonHoc("q",1,2);
        Diem d = new Diem(m,8);
        Diem e = new Diem(m1,8);
        SinhVien s = new SinhVien("qq1","Hoang");
        s.themDiem(d);
        s.themDiem(e);
        System.out.println(s.bangDiem());
    }

    @Test
    void xepLoai() {
        MonHoc m = new MonHoc("qq",1,1);
        Diem d = new Diem(m,10);
        Diem e = new Diem(m,10);
        SinhVien s = new SinhVien("qq1","Hoang");
        s.themDiem(d);
        s.themDiem(e);

        System.out.println(s.xepLoai());
    }
}
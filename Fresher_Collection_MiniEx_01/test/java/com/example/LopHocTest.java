package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LopHocTest {

    @Test
    void inDiem() {
        MonHoc m = new MonHoc("qq",2,1);
        MonHoc m1 = new MonHoc("qq",2,1);

        Diem d = new Diem(m,8);
        Diem e = new Diem(m1,8);
        SinhVien s = new SinhVien("qq1","Hoang");
        s.themDiem(d);
        s.themDiem(e);

        s.tinhDiemTrungBinh();
        s.xepLoai();


        LopHoc l = new LopHoc("C2009G1","HoangGG");
        l.them(s);
        System.out.println(l.inDiem());
    }

    @Test
    void top10() {
        MonHoc m = new MonHoc("qq",2,1);
        MonHoc m1 = new MonHoc("qq",2,1);

        Diem d = new Diem(m,1);
        Diem e = new Diem(m1,7);
        Diem e2 = new Diem(m1,8);
        SinhVien s = new SinhVien("qq1","Hoang");
        SinhVien a1 = new SinhVien("112", "Nhu2");
        SinhVien a2 = new SinhVien("113", "Nhu3");
        SinhVien a3 = new SinhVien("114", "Nhu4");
        s.themDiem(d);
        s.themDiem(e2);
        a1.themDiem(e);

        s.tinhDiemTrungBinh();
        s.xepLoai();

        LopHoc l = new LopHoc("C2009G1","HoangGG");
        l.them(s);
        l.them(a1);
        l.them(a2);
        l.them(a3);

        System.out.println(l.top10());
    }

    @Test
    void sinhVienYeu() {
        MonHoc m = new MonHoc("qq",2,1);
        MonHoc m1 = new MonHoc("qq",2,1);

        Diem d = new Diem(m,1);
        Diem e = new Diem(m1,1);
        SinhVien s = new SinhVien("qq1","Hoang");
        s.themDiem(d);
        s.themDiem(e);

        s.tinhDiemTrungBinh();
        s.xepLoai();


        LopHoc l = new LopHoc("C2009G1","HoangGG");
        l.them(s);
        System.out.println(l.sinhVienYeu());
    }
}
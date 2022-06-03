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
        Diem e2 = new Diem(m1,2);
        Diem e3 = new Diem(m1,3);
        Diem e4 = new Diem(m1,4);
        Diem e5 = new Diem(m1,5);
        Diem e6 = new Diem(m1,6);
        Diem e7 = new Diem(m1,10);
        Diem e8 = new Diem(m1,8);
        Diem e9 = new Diem(m1,9);

        SinhVien s = new SinhVien("qq1","Hoang");
        SinhVien a1 = new SinhVien("112", "Nheru2");
        SinhVien a2 = new SinhVien("113", "Nheru3");
        SinhVien a3 = new SinhVien("114", "Nhuer4");
        SinhVien ss = new SinhVien("qq1","Hoag");
        SinhVien a11 = new SinhVien("118", "Nhu3452");
        SinhVien a22 = new SinhVien("133", "Nhreu3");
        SinhVien a33 = new SinhVien("614", "Nhreu4");
        SinhVien s4 = new SinhVien("q31","Horw45ang");
        SinhVien a15 = new SinhVien("11r2", "Nhuwe2");
        SinhVien a26 = new SinhVien("1s3", "Nhu343");
        SinhVien a37 = new SinhVien("11w4", "Nh23u4");
        s.themDiem(d);
        a2.themDiem(e2);
        a1.themDiem(e);
        a3.themDiem(e3);
        ss.themDiem(e4);
        a11.themDiem(e5);
        a22.themDiem(e6);
        a33.themDiem(e7);a1.themDiem(e8);
        s4.themDiem(e9);

        s.tinhDiemTrungBinh();
        s.xepLoai();

        LopHoc l = new LopHoc("C2009G1","HoangGG");
        l.them(s);
        l.them(a1);
        l.them(a2);
        l.them(a3);
        l.them(ss);
        l.them(a11);
        l.them(a22);
        l.them(a33);
        l.them(s4);
        l.them(a15);
        l.them(a26);
        l.them(a37);

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
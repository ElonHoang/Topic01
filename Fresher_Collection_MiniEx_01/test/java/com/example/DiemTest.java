package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiemTest {

    @Test
    void getMon() {
        MonHoc m = new MonHoc("h",2,2);
        assertNotNull(true,m.getTen());
    }

    @Test
    void getDiem() {
        MonHoc e = new MonHoc(null, 3,5);
        assertNull(null,e.getTen());
    }
    @Test
    void compareTo() {
        MonHoc m = new MonHoc("Hoang",4,4);
        Diem d = new Diem(m,6);
        Diem e = new Diem(m, 7);
        assertEquals(-1,d.compareTo(e));
    }
}
package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonHocTest {

    @Test
    void getTen() {
        MonHoc m = new MonHoc("Hoang", 1, 1);
        assertEquals("Hoang",m.getTen());
    }

    @Test
    void getTcLT() {
    }

    @Test
    void getTcTH() {
    }
}
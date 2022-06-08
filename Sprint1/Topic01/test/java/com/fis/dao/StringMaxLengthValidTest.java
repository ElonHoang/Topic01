package com.fis.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringMaxLengthValidTest {

    @Test
    void validate() {
        StringMaxLengthValid s = new StringMaxLengthValid();
        boolean s1 = s.validate("la taosss ne Hoang");
        assertTrue(s1);
        System.out.println(s.getLength());
    }
}
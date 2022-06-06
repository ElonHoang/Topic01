package com.fis.dao;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DateValidTest {

    @Test
    void validate() {
        DateValid d = new DateValid();

        assertTrue( d.validate("06/04/2002"));

    }
}
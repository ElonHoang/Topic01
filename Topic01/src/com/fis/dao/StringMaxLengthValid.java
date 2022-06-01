package com.fis.dao;

public class StringMaxLengthValid implements IValidation {
    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean validate(String data) {
        return false;
    }
}

package com.fis.dao;

public class DecimalValid implements IValidation {
    @Override
    public boolean validate(String data) {
        String check = data.trim();
        if( check.matches("^\\d+\\.\\d+") )
            return false;
        else
            return true;
    }
}

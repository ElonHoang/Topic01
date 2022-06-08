package com.fis.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateValid implements IValidation {
    @Override
    public boolean validate(String data) {
        String check = data.trim();
        SimpleDateFormat sp = new SimpleDateFormat("dd/MM/yyyy");
        sp.setLenient(false);
        try {
            Date d = sp.parse(check);
            return true;
        } catch (ParseException e) {
            System.out.println("Date not valid");
            return false;
        }
    }
}

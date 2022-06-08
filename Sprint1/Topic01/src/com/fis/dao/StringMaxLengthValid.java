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
        int max = 0;
        String[] rs = data.trim().split(" ");
        for(String s : rs){
            if(max < s.length()){
                max = s.length();
            }
        }
        if(max > 0){
            setLength(max);
            return true;
        }
        return false;
    }
}

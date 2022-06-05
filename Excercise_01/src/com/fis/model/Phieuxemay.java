package com.fis.model;

import java.util.Objects;

public class Phieuxemay extends Baigiuxe {
    private String soXe;

    public Phieuxemay(){
        super(0,1000,100,10);
    }
    public Phieuxemay(int soPhieu, String soXe){
        super(soPhieu);
        this.soXe = soXe;
    }
    public Phieuxemay(String soXe,int soPhieu,int gia, int chiphi, int thue) {
        super(soPhieu,gia,chiphi,thue);
        this.soXe = soXe;
    }

    public String getSoXe() {
        return soXe;
    }

    public void setSoXe(String soXe) {
        this.soXe = soXe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phieuxemay)) return false;
        if (!super.equals(o)) return false;
        Phieuxemay that = (Phieuxemay) o;
        return soXe.equals(that.soXe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), soXe);
    }
}

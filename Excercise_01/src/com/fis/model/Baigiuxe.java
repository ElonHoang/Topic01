package com.fis.model;

import java.util.Objects;

public class Baigiuxe {
    private int soPhieu;
    private int giaGiuXe;
    private int chiPhiNhanCong;
    private int thue;

    public Baigiuxe() {
    }

    public Baigiuxe(int soPhieu) {
        this.soPhieu = soPhieu;
    }

    public Baigiuxe(int soPhieu, int giaGiuXe, int chiPhiNhanCong, int thue) {
        this.soPhieu = soPhieu;
        this.giaGiuXe = giaGiuXe;
        this.chiPhiNhanCong = chiPhiNhanCong;
        this.thue = thue;
    }

    public int getSoPhieu() {
        return soPhieu;
    }

    public void setSoPhieu(int soPhieu) {
        this.soPhieu = soPhieu;
    }

    public int getGiaGiuXe() {
        return giaGiuXe;
    }

    public void setGiaGiuXe(int giaGiuXe) {
        this.giaGiuXe = giaGiuXe;
    }

    public int getChiPhiNhanCong() {
        return chiPhiNhanCong;
    }

    public void setChiPhiNhanCong(int chiPhiNhanCong) {
        this.chiPhiNhanCong = chiPhiNhanCong;
    }

    public int getThue() {
        return thue;
    }

    public void setThue(int thue) {
        this.thue = thue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Baigiuxe)) return false;
        Baigiuxe baigiuxe = (Baigiuxe) o;
        return soPhieu == baigiuxe.soPhieu && giaGiuXe == baigiuxe.giaGiuXe && chiPhiNhanCong == baigiuxe.chiPhiNhanCong && thue == baigiuxe.thue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(soPhieu, giaGiuXe, chiPhiNhanCong, thue);
    }
}

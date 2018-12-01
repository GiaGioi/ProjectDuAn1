package com.developer.giagioi.projectduan1.model;

public class Vaccin {
    private String tenVatNuoi;
    private String loaiThucAn;
    private int soLuong;


    public Vaccin(){

    }
    public Vaccin(String tenVatNuoi, String loaiThucAn, int soLuong) {
        this.tenVatNuoi = tenVatNuoi;
        this.loaiThucAn = loaiThucAn;
        this.soLuong = soLuong;

    }


    public String getTenVatNuoi() {
        return tenVatNuoi;
    }

    public void setTenVatNuoi(String tenVatNuoi) {
        this.tenVatNuoi = tenVatNuoi;
    }

    public String getLoaiThucAn() {
        return loaiThucAn;
    }

    public void setLoaiThucAn(String loaiThucAn) {
        this.loaiThucAn = loaiThucAn;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    @Override
    public String toString() {
        return "Vaccin{" +
                "tenVatNuoi='" + tenVatNuoi + '\'' +
                ", loaiThucAn='" + loaiThucAn + '\'' +
                ", soLuong=" + soLuong +
                '}';
    }
}

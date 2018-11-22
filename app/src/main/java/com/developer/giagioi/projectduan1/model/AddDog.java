package com.developer.giagioi.projectduan1.model;

public class AddDog {
    private String IDPet;
    private String NamePet;
    private int SoLuong;
    private String GioiTinh;
    private String TinhTrang;

    public AddDog(String IDPet, String namePet, int soLuong, String gioiTinh, String tinhTrang) {
        this.IDPet = IDPet;
        NamePet = namePet;
        SoLuong = soLuong;
        GioiTinh = gioiTinh;
        TinhTrang = tinhTrang;
    }
    public AddDog(){}


    public String getIDPet() {
        return IDPet;
    }

    public void setIDPet(String IDPet) {
        this.IDPet = IDPet;
    }

    public String getNamePet() {
        return NamePet;
    }

    public void setNamePet(String namePet) {
        NamePet = namePet;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        GioiTinh = gioiTinh;
    }

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        TinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "AddDog{" +
                "IDPet='" + IDPet + '\'' +
                ", NamePet='" + NamePet + '\'' +
                ", SoLuong='" + SoLuong + '\'' +
                ", GioiTinh='" + GioiTinh + '\'' +
                ", TinhTrang='" + TinhTrang + '\'' +
                '}';
    }
}

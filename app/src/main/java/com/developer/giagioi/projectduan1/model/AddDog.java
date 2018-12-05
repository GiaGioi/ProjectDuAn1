package com.developer.giagioi.projectduan1.model;

public class AddDog {
    private String NamePet;
    private String ChungLoai;
    private int SoLuong;
    private String GioiTinh;
    private String TinhTrang;

    public AddDog(String namePet,String chungLoai, int soLuong, String gioiTinh, String tinhTrang) {

        NamePet = namePet;
        ChungLoai = chungLoai;
        SoLuong = soLuong;
        GioiTinh = gioiTinh;
        TinhTrang = tinhTrang;
    }
    public AddDog(){}



    public String getNamePet() {
        return NamePet;
    }

    public void setNamePet(String namePet) {
        NamePet = namePet;
    }

    @Override
    public String toString() {
        return "AddDog{" +
                ", NamePet='" + NamePet + '\'' +
                ", ChungLoai='" + ChungLoai + '\'' +
                ", SoLuong=" + SoLuong +
                ", GioiTinh='" + GioiTinh + '\'' +
                ", TinhTrang='" + TinhTrang + '\'' +
                '}';
    }

    public String getChungLoai() {
        return ChungLoai;
    }

    public void setChungLoai(String chungLoai) {
        ChungLoai = chungLoai;
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

}

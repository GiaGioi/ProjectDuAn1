package com.developer.giagioi.projectduan1.model;

public class Health {
    private String idPet;
    private String NamePet;
    private String ChungLoai;
    private int SoLuong;
    private String TinhTrang;

    public Health(){}
    public Health(String idPet,String namePet, String chungLoai, int soLuong, String tinhTrang) {
        this.idPet=idPet;
        NamePet = namePet;
        ChungLoai = chungLoai;
        SoLuong = soLuong;
        TinhTrang = tinhTrang;
    }


    public String getIdPet() {
        return idPet;
    }

    public void setIdPet(String idPet) {
        this.idPet = idPet;
    }

    public String getNamePet() {
        return NamePet;
    }

    public void setNamePet(String namePet) {
        NamePet = namePet;
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

    public String getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        TinhTrang = tinhTrang;
    }

    @Override
    public String toString() {
        return "AddDog{" +
                ", NamePet='" + NamePet + '\'' +
                ", ChungLoai='" + ChungLoai + '\'' +
                ", SoLuong='" + SoLuong + '\'' +
                ", TinhTrang='" + TinhTrang + '\'' +
                '}';
    }
}

package com.example.project_app_thu_cung;

public class danhgiamodel {
    String iddanhgia, ten, thoigian, noidung;
    int sao;

    public danhgiamodel() {

    }

    public danhgiamodel(String iddanhgia, String ten, String thoigian, String noidung, int sao) {
        this.iddanhgia = iddanhgia;
        this.ten = ten;
        this.thoigian = thoigian;
        this.noidung = noidung;
        this.sao = sao;
    }

    public String getIddanhgia() {
        return iddanhgia;
    }

    public void setIddanhgia(String iddanhgia) {
        this.iddanhgia = iddanhgia;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getThoigian() {
        return thoigian;
    }

    public void setThoigian(String thoigian) {
        this.thoigian = thoigian;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public int getSao() {
        return sao;
    }

    public void setSao(int sao) {
        this.sao = sao;
    }
}

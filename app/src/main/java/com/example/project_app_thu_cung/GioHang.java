package com.example.project_app_thu_cung;

public class GioHang {
    String  ten, phanloai, soluong,hinhanh, tongtien;
    String id;


    public GioHang(String ten, String phanloai, String soluong, String hinhanh, String tongtien, String id) {
        this.ten = ten;
        this.phanloai = phanloai;
        this.soluong = soluong;
        this.hinhanh = hinhanh;
        this.tongtien = tongtien;
        this.id = id;
    }

    public GioHang() {
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getPhanloai() {
        return phanloai;
    }

    public void setPhanloai(String phanloai) {
        this.phanloai = phanloai;
    }

    public String getSoluong() {
        return soluong;
    }

    public void setSoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getHinhanh() {
        return hinhanh;
    }

    public void setHinhanh(String hinhanh) {
        this.hinhanh = hinhanh;
    }

    public String getTongtien() {
        return tongtien;
    }

    public void setTongtien(String tongtien) {
        this.tongtien = tongtien;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

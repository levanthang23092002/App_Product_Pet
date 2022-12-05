package com.example.project_app_thu_cung;

public class SanPham {
    private String hinh, gia, tensp, mota, id;

    public SanPham(String hinh, String gia, String tensp, String mota, String id) {
        this.hinh = hinh;
        this.gia = gia;
        this.tensp = tensp;
        this.mota = mota;
        this.id = id;
    }

    public SanPham() {
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getTensp() {
        return tensp;
    }

    public void setTensp(String tensp) {
        this.tensp = tensp;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

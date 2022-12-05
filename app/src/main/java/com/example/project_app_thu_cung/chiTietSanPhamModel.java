package com.example.project_app_thu_cung;

public class chiTietSanPhamModel {
    public String hinh, gia, tensp, mota, sizes, sizem, sizel, sizexl, sosao, id;

    public chiTietSanPhamModel(String hinh, String gia, String tensp, String mota, String sizes, String sizem, String sizel, String sizexl, String sosao, String id) {
        this.hinh = hinh;
        this.gia = gia;
        this.tensp = tensp;
        this.mota = mota;
        this.sizes = sizes;
        this.sizem = sizem;
        this.sizel = sizel;
        this.sizexl = sizexl;
        this.sosao = sosao;
        this.id = id;
    }

    public chiTietSanPhamModel() {
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

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes;
    }

    public String getSizem() {
        return sizem;
    }

    public void setSizem(String sizem) {
        this.sizem = sizem;
    }

    public String getSizel() {
        return sizel;
    }

    public void setSizel(String sizel) {
        this.sizel = sizel;
    }

    public String getSizexl() {
        return sizexl;
    }

    public void setSizexl(String sizexl) {
        this.sizexl = sizexl;
    }

    public String getSosao() {
        return sosao;
    }

    public void setSosao(String sosao) {
        this.sosao = sosao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

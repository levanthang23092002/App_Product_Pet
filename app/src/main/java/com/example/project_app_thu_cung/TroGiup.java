package com.example.project_app_thu_cung;

public class TroGiup {
    String  chitiet;
    int buoc;

    public TroGiup(String chitiet, int buoc) {
        this.chitiet = chitiet;
        this.buoc = buoc;
    }

    public String getChitiet() {
        return chitiet;
    }

    public void setChitiet(String chitiet) {
        this.chitiet = chitiet;
    }

    public int getBuoc() {
        return buoc;
    }

    public void setBuoc(int buoc) {
        this.buoc = buoc;
    }
}

package com.example.project_app_thu_cung;

public class vi_them {
    String stk, bank,mapin;

    public vi_them() {
    }

    public vi_them(String stk, String bank, String mapin) {
        this.stk = stk;
        this.bank = bank;
        this.mapin = mapin;
    }

    public String getStk() {
        return stk;
    }

    public void setStk(String stk) {
        this.stk = stk;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getMapin() {
        return mapin;
    }

    public void setMapin(String mapin) {
        this.mapin = mapin;
    }
}

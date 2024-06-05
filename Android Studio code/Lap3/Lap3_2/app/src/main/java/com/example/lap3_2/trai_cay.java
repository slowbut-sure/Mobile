package com.example.lap3_2;

public class trai_cay {
    private String Ten;
    private String Mota;
    private  int Hinh;
    public trai_cay(String ten, String mota, int hinh) {
        Ten = ten;
        Mota = mota;
        Hinh = hinh;

    }
    public String getTen() {
        return Ten;

    }
    public void setTen(String ten) {
        Ten = ten;

    }
    public String getMota() {
        return Mota;

    }
    public void setMota(String mota) {
        Mota = mota;

    }
    public int qetHinh() {
        return Hinh;
    }
    public void setHinh(int hinh) {
        Hinh = hinh;
    }
}

package com.example.quanli;

import java.io.Serializable;

public class DoiTuong implements Serializable {
    int iddangki;
    String hoten;
    String sodienthoai;
    String mapin;
    String nhaplaimapin;
    String sodu;
    String thungay;
    String chingay;

    public DoiTuong(){ }
    public DoiTuong(int iddangki,String hoten,String sodienthoai,String mapin,
                    String nhaplaimapin, String sodu ,String chingay,String thungay){
        this.iddangki=iddangki;
        this.hoten=hoten;
        this.sodienthoai=sodienthoai;
        this.mapin=mapin;
        this.nhaplaimapin=nhaplaimapin;
        this.sodu=sodu;
        this.thungay=thungay;
        this.chingay=chingay;

    }
    public void setThungay(String thungay) {
        this.thungay = thungay;
    }
    public void setChingay(String chingay) {
        this.chingay = chingay;
    }
    public String getThungay() {
        return thungay;
    }
    public String getChingay() {
        return chingay;
    }
    public String getSodu() {
        return sodu;
    }
    public void setSodu(String sodu) {
        this.sodu = sodu;
    }
    public int getIddangki(){
        return iddangki;
    }
    public void setIddangki(int iddangki){
        this.iddangki=iddangki;
    }
    public String getHoten(){
        return hoten;
    }
    public String getSodienthoai(){
        return sodienthoai;
    }
    public String getMapin(){
        return mapin;
    }
    public String getNhaplaimapin(){
        return nhaplaimapin;
    }
    public void setHoten(String hoten){
        this.hoten=hoten;
    }
    public void setSodienthoai(String sodienthoai)
    {
        this.sodienthoai=sodienthoai;
    }
    public void setMapin(String mapin){
        this.mapin=mapin;
    }
    public void setNhaplaimapin(String nhaplaimapin){
        this.nhaplaimapin=nhaplaimapin;
    }
    @Override
    public String toString(){
        return this.hoten;
    }

}

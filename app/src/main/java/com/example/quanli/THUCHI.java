package com.example.quanli;

import androidx.annotation.NonNull;

import java.io.Serializable;

public class THUCHI implements Serializable {
    int idthuchi;
    String NgayThang;
    String SoTien;
    String PhanLoai;
    String KhoanThuChi;
    String GhiChu;
    public THUCHI(){}
    public THUCHI(int idthuchi, String ngayThang ,String soTien , String phanLoai , String khoanThuChi ,String GhiChu){
        this.idthuchi=idthuchi;
        this.SoTien=soTien;
        this.NgayThang=ngayThang;
        this.PhanLoai=phanLoai;
        this.KhoanThuChi=khoanThuChi;
        this.GhiChu=GhiChu;
    }

    public int getIdthuchi() {
        return idthuchi;
    }

    public String getNgayThang() {
        return NgayThang;
    }

    public String getSoTien() {
        return SoTien;
    }

    public String getKhoanThuChi() {
        return KhoanThuChi;
    }

    public String getPhanLoai() {
        return PhanLoai;
    }

    public String getGhiChu() {
        return GhiChu;
    }

    public void setIdthuchi(int idthuchi) {
        this.idthuchi = idthuchi;
    }

    public void setGhiChu(String ghiChu) {
        GhiChu = ghiChu;
    }

    public void setNgayThang(String ngayThang) {
        NgayThang = ngayThang;
    }

    public void setKhoanThuChi(String khoanThuChi) {
        KhoanThuChi = khoanThuChi;
    }

    public void setPhanLoai(String phanLoai) {
        PhanLoai = phanLoai;
    }

    public void setSoTien(String soTien) {
        SoTien = soTien;
    }

    @NonNull
    @Override
    public String toString() {
        return super.toString();
    }
}

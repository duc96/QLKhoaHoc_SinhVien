package com.example.asm.model;

public class SinhVien {
    public String maSV;
    public String tenSV;
    public String khoaHoc;
    public int namSinh;
    public String hocKi;

    public SinhVien(String maSV, String tenSV, String khoaHoc, int namSinh, String hocKi) {
        this.maSV = maSV;
        this.tenSV = tenSV;
        this.khoaHoc = khoaHoc;
        this.namSinh = namSinh;
        this.hocKi = hocKi;
    }

    @Override
    public String toString() {
        return "SinhVien{" +
                "maSV='" + maSV + '\'' +
                ", tenSV='" + tenSV + '\'' +
                ", khoaHoc='" + khoaHoc + '\'' +
                ", namSinh=" + namSinh +
                ", hocKi=" + hocKi +
                '}';
    }
}

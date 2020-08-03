package com.example.asm.model;

public class KhoaHoc {
    public String tenKhoaHoc;
    public String maKhoaHoc;
    public String ngayBatDau;
    public String ngayKetThuc;

    public KhoaHoc(){

    }

    public KhoaHoc(String tenKhoaHoc, String maKhoaHoc, String ngayBatDau, String ngayKetThuc) {
        this.tenKhoaHoc = tenKhoaHoc;
        this.maKhoaHoc = maKhoaHoc;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    public KhoaHoc(String tenKhoaHoc) {
        this.tenKhoaHoc = tenKhoaHoc;
    }

    public KhoaHoc(String tenKhoaHoc, String ngayBatDau, String ngayKetThuc) {
        this.tenKhoaHoc = tenKhoaHoc;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
    }

    @Override
    public String toString() {
        return "KhoaHoc{" +
                "tenKhoaHoc='" + tenKhoaHoc + '\'' +
                ", maKhoaHoc='" + maKhoaHoc + '\'' +
                ", ngayBatDau='" + ngayBatDau + '\'' +
                ", ngayKetThuc='" + ngayKetThuc + '\'' +
                '}';
    }
}

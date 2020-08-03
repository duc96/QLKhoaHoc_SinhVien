package com.example.asm.model;

import java.io.Serializable;

public class HocKi implements Serializable {
    public String tenHocKi;
    public String tgHoc;
    public String tgBatDau;

    public HocKi(String tenHocKi, String tgHoc, String tgBatDau) {
        this.tenHocKi = tenHocKi;
        this.tgHoc = tgHoc;
        this.tgBatDau = tgBatDau;
    }

    @Override
    public String toString() {
        return "HocKi{" +
                "tenHocKi='" + tenHocKi + '\'' +
                ", tgHoc=" + tgHoc +
                ", tgBatDau=" + tgBatDau +
                '}';
    }
}

package com.example.asm.dao;

import android.database.sqlite.SQLiteDatabase;

public class SinhVienDAO {

    private SQLiteDatabase db;
    public static final String TABLE_NAME = "bang_sinh_vien";
    public static final String MA_SV = "ma_sv";
    public static final String TEN_SV = "ten_sv";
    public static final String KHOA_HOC = "khoa_hoc";
    public static final String NAM_SINH = "nam_sinh";
    public static final String HOC_KI = "hoc_ki";

    public static final String CREATE_TABLE = "CREATE TABLE " +
            TABLE_NAME + " ( " +
            MA_SV + " VARCHAR PRIMARY KEY , " +
            TEN_SV + " VARCHAR NOT NULL, " +
            KHOA_HOC + " VARCHAR NOT NULL, " +
            NAM_SINH + " INTEGER NOT NULL, " +
            HOC_KI + " VARCHAR" +
            " );";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public SinhVienDAO(SQLiteDatabase db) {
        this.db = db;
    }
}

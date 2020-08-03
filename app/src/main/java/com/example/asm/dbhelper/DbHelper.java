package com.example.asm.dbhelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.asm.dao.HocKiDAO;
import com.example.asm.dao.KhoaHocDAO;
import com.example.asm.dao.SinhVienDAO;

public class DbHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "Quan_ly_khoa_hoc";
    public static final int DB_VERSION = 10;

    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(KhoaHocDAO.CREATE_TABLE);
        db.execSQL(HocKiDAO.CREATE_TABLE);
        db.execSQL(SinhVienDAO.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(KhoaHocDAO.THEM5);
        db.execSQL(KhoaHocDAO.THEM6);
        db.execSQL(KhoaHocDAO.THEM7);
        db.execSQL(KhoaHocDAO.THEM8);
    }
}

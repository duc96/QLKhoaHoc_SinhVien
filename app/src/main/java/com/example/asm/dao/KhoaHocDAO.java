package com.example.asm.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.asm.model.KhoaHoc;

import java.util.ArrayList;
import java.util.List;

public class KhoaHocDAO {

    private SQLiteDatabase db;
    private static final String TABLE_NAME = "bang_khoa_hoc";
    private static final String MA_KH = "ma_kh";
    private static final String TEN_KH = "ten_kh";
    private static final String NGAY_BAT_DAU = "ngay_bat_dau";
    private static final String NGAY_KET_THUC = "ngay_ket_thuc";

    public static final String CREATE_TABLE = "CREATE TABLE " +
            TABLE_NAME + " (" +
            MA_KH + " VARCHAR PRIMARY KEY NOT NULL, " +
            TEN_KH + " VARCHAR NOT NULL, " +
            NGAY_BAT_DAU + " VARCHAR NOT NULL, " +
            NGAY_KET_THUC + " VARCHAR NOT NULL" +
            " );";

    public static final String THEM = "INSERT INTO " + TABLE_NAME + " VALUES ('kh01','Kỹ Năng Code','12/01/2020','12/04/2020');";
    public static final String THEM1 = "INSERT INTO " + TABLE_NAME + " VALUES ('kh02','Lập Trình Cơ Bản','02/02/2020','16/06/2020');";
    public static final String THEM2 = "INSERT INTO " + TABLE_NAME + " VALUES ('kh03','Lập Trình Nâng Cao','12/01/2020','28/05/2020');";
    public static final String THEM3= "INSERT INTO " + TABLE_NAME + " VALUES ('kh04','Dự Án Mẫu','10/01/2020','24/04/2020');";
    public static final String THEM4 = "INSERT INTO " + TABLE_NAME + " VALUES ('kh05','Thiết Kế Giao Diện','12/01/2020','12/05/2020');";

    public static final String THEM5= "INSERT INTO " + TABLE_NAME + " VALUES ('kh06','Thiết Kế Web','91/04/2020','28/09/2020');";
    public static final String THEM6 = "INSERT INTO " + TABLE_NAME + " VALUES ('kh07','Quản Lý Database','17/03/2020','24/07/2020');";
    public static final String THEM7= "INSERT INTO " + TABLE_NAME + " VALUES ('kh08','Java 1','25/10/2020','28/12/2020');";
    public static final String THEM8 = "INSERT INTO " + TABLE_NAME + " VALUES ('kh09','Java2','03/08/2020','12/09/2020');";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public KhoaHocDAO(SQLiteDatabase db) {
        this.db = db;
    }

    public List readTenKhoaHoc(){
        List listKhoaHoc = new ArrayList();
        String[] columns = {TEN_KH};

        Cursor cursor = db.query(TABLE_NAME,columns,null,null,null,null,null);

        while (cursor.moveToNext()){
            String tenKH = cursor.getString(cursor.getColumnIndex(TEN_KH));
            listKhoaHoc.add(tenKH);
        }
        return  listKhoaHoc;
    }

    public List readKhoaHoc(){
        List listKhoaHoc = new ArrayList();
        String[] columns = {TEN_KH,NGAY_BAT_DAU,NGAY_KET_THUC};

        Cursor cursor = db.query(TABLE_NAME,columns,null,null,null,null,null);

        while (cursor.moveToNext()){
            listKhoaHoc.add(new KhoaHoc(cursor.getString(cursor.getColumnIndex(TEN_KH)),
                    cursor.getString(cursor.getColumnIndex(NGAY_BAT_DAU)),
                    cursor.getString(cursor.getColumnIndex(NGAY_KET_THUC))));
        }
        return listKhoaHoc;
    }
}

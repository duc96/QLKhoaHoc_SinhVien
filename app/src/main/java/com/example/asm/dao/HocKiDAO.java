package com.example.asm.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class HocKiDAO {
    private SQLiteDatabase db;
    public static final String TABLE_NAME = "bang_hoc_ki";
    public static final String TEN_HOC_KI = "ten_hoc_ki";
    public static final String TG_HOC_KI = "tg_hoc_ki";
    public static final String TG_BAT_DAU = "tg_bat_dau";

    public static final String CREATE_TABLE = "CREATE TABLE " +
            TABLE_NAME + " ( " +
            TEN_HOC_KI + " VARCHAR PRIMARY KEY NOT NULL, " +
            TG_HOC_KI + " VARCHAR, " +
            TG_BAT_DAU + " VARCHAR" +
            " );";

    public static final String THEM = "INSERT INTO " + TABLE_NAME + " VALUES ('SPRING 2018','4 Tháng','12/01/2018');";
    public static final String THEM1 = "INSERT INTO " + TABLE_NAME + " VALUES ('SUM 2018','4 Tháng','20/05/2018');";
    public static final String THEM2 = "INSERT INTO " + TABLE_NAME + " VALUES ('FAL 2018','4 Tháng','25/09/2018');";
    public static final String THEM3= "INSERT INTO " + TABLE_NAME + " VALUES ('SPRING 2019','4 Tháng','12/01/2019');";
    public static final String THEM4 = "INSERT INTO " + TABLE_NAME + " VALUES ('SUM 2019','4 Tháng','20/05/2019');";
    public static final String THEM5 = "INSERT INTO " + TABLE_NAME + " VALUES ('FAL 2019','4 Tháng','25/09/2019');";
    public static final String THEM6 = "INSERT INTO " + TABLE_NAME + " VALUES ('SPRING 2020','4 Tháng','12/01/2020');";

    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;

    public HocKiDAO(SQLiteDatabase db){
        this.db = db;
    }

    public List readTenHocKi(){
        List listHocKi = new ArrayList();
        String[] columns = {TEN_HOC_KI};

        Cursor cursor = db.query(TABLE_NAME,columns,null,null,null,null,null);

        while(cursor.moveToNext()){
            String tenHK = cursor.getString(cursor.getColumnIndex(TEN_HOC_KI));
            listHocKi.add(tenHK);

        }
        return  listHocKi;
    }
}

package com.example.moneymanagement.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.moneymanagement.database.DatabaseHelper;
import com.example.moneymanagement.model.LoaiChi;


public class LoaiChiDAO {
    private SQLiteDatabase sqliteDB;
    private DatabaseHelper dbHelper;
    private Context context;
    public LoaiChiDAO(Context context){
        this.context = context;
        dbHelper = new DatabaseHelper(context);
        sqliteDB = dbHelper.getWritableDatabase();
    }
    public boolean insertLoaiChi(LoaiChi objloaiChi){
        try {
            ContentValues values = new ContentValues();
            values.put("maLC", objloaiChi.getMaLoaiChi());
            values.put("tenLC", objloaiChi.getTenLoaiChi());
            long numInsert = sqliteDB.insert("LoaiChi",null,values);
            if(numInsert<=0)
                return false;
        }catch (Exception ex){
            ex.printStackTrace();
            return false;
        }

        return true;
    }
}

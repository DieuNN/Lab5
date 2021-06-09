package com.example.lab5.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "QLBanHang";
    public static final String TABLE_PRODUCT = "Product";
    public static final int DATABASE_VERSION = 1;

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_PRODUCT + "(" +
                "id text primary key," +
                "name text," +
                "price real," +
                "image integer)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion < newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_PRODUCT);
        }
        onCreate(db);
    }


}

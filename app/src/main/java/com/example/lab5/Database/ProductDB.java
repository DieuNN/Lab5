package com.example.lab5.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class ProductDB {
    DBHandler handler;
    SQLiteDatabase database;

    public ProductDB(DBHandler handler) {
        this.handler = handler;
    }

}

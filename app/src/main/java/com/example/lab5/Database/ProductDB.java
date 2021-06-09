package com.example.lab5.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.lab5.Model.Product;

import java.util.ArrayList;

public class ProductDB {
    DBHandler handler;
    SQLiteDatabase database;


    public ProductDB(DBHandler handler) {
        this.handler = handler;
    }

    public boolean delete(String id) {
        database = handler.getWritableDatabase();

        if(database.delete(handler.TABLE_PRODUCT, "id = ?",  new String[]{id}) >=0) {
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Product> getAllProduct() {
        ArrayList<Product> list = new ArrayList<>();
        database = handler.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + DBHandler.TABLE_PRODUCT, null);

        if(cursor.getCount() > 0 ){
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                Product p = new Product();
                p.setId(cursor.getString(0));
                p.setName(cursor.getString(1));
                p.setPrice(cursor.getDouble(2));
                p.setImage(cursor.getInt(3));

                list.add(p);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return list;
    }

    public boolean insertProduct(Product product) {
        ContentValues values = new ContentValues();
        database = handler.getWritableDatabase();

        values.put("id", product.getId());
        values.put("name", product.getName());
        values.put("price", product.getPrice());
        values.put("image", product.getImage());

        if(database.insert(handler.TABLE_PRODUCT,null, values) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean editProduct(String newName, String newPrice, int newImage, String currentID) {
        ContentValues values = new ContentValues();
        database = handler.getWritableDatabase();

        values.put("name", newName);
        values.put("price", newPrice);
        values.put("image", newImage);

        if(database.update(handler.TABLE_PRODUCT, values, "id = ?", new String[]{currentID}) >=0) {
            return true;
        } else {
            return false;
        }
    }

}

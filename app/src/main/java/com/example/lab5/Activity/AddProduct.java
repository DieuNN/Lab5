package com.example.lab5.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lab5.Database.DBHandler;
import com.example.lab5.Database.ProductDB;
import com.example.lab5.Model.Product;
import com.example.lab5.R;

public class AddProduct extends AppCompatActivity {
    TextView id, name, price;
    Button add;
    ProductDB productDB = new ProductDB(new DBHandler(this));
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);
        mapping();
        
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Double.parseDouble(price.getText().toString());
                } catch (Exception e) {
                    Toast.makeText(AddProduct.this, "Giá phải là số!", Toast.LENGTH_SHORT).show();
                }
                
                if(!isEmpty()) {
                    Toast.makeText(AddProduct.this, "Bạn không được bỏ trống các trường!", Toast.LENGTH_SHORT).show();
                    return;
                }
                
                
                
                if(productDB.insertProduct(new Product(id.getText().toString(), name.getText().toString(), Double.parseDouble(price.getText().toString()), R.color.black))) {
                    Toast.makeText(AddProduct.this, "Thêm thành công!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(AddProduct.this, "Thêm thất bại!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
    
    private void mapping() {
        id = findViewById(R.id.txtId);
        name = findViewById(R.id.txtName);
        price = findViewById(R.id.txtPrice);
        add = findViewById(R.id.btnAddProduct);
    }
    
    private boolean isEmpty() {
        if(name.getText().equals("")||id.getText().equals("")||price.getText().equals("")) {
            return false;
        }
        return true;
    }
    
    
}
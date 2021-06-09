package com.example.lab5.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab5.Adapter.ProductAdapter;
import com.example.lab5.Database.DBHandler;
import com.example.lab5.Database.ProductDB;
import com.example.lab5.Model.Product;
import com.example.lab5.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ProductAdapter adapter;
    ProductDB productDB = new ProductDB(new DBHandler(this));
    TextView isProductExist;
    Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();

        ArrayList<Product> products = productDB.getAllProduct();
        ProductAdapter adapter = new ProductAdapter(this, R.layout.product_row, products);
        listView.setAdapter(adapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, String.valueOf(position), Toast.LENGTH_SHORT).show();
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("Thông báo")
                        .setMessage("Bạn muốn xóa?")
                        .setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        })
                        .setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                ArrayList<Product> list = productDB.getAllProduct();
                                if(productDB.delete(list.get(position).getId())) {
                                    Toast.makeText(MainActivity.this, "Xóa thành công!", Toast.LENGTH_SHORT).show();
                                    onResume();
                                } else {
                                    Toast.makeText(MainActivity.this, "Xóa thất bại!", Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .create().show();
                return false;
            }
        });


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddProduct.class);
                startActivity(intent);
            }
        });

    }

    private void mapping() {
        listView = findViewById(R.id.listViewProduct);
        isProductExist = findViewById(R.id.isProductExist);
        add = findViewById(R.id.btnAdd);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<Product> products = productDB.getAllProduct();
        ProductAdapter adapter = new ProductAdapter(this, R.layout.product_row, products);
        listView.setAdapter(adapter);
    }
}
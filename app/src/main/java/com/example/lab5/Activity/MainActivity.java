package com.example.lab5.Activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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


        ArrayList<Product> list = productDB.getAllProduct();
        ProductAdapter adapter = new ProductAdapter(MainActivity.this, R.layout.product_row, list);
        if (list.size() == 0) {
            isProductExist.setVisibility(View.VISIBLE);
            listView.setVisibility(View.INVISIBLE);
        } else {
            listView.setVisibility(View.VISIBLE);
            listView.setAdapter(adapter);
            isProductExist.setVisibility(View.INVISIBLE);
        }


        listView.setOnItemLongClickListener((parent, view, position, id) -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setTitle("Thông báo")
                    .setMessage("Bạn có muốn xóa sản phẩm?")
                    .setPositiveButton("Xóa", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    try {
                                        if(productDB.delete(list.get(position).getId())) {
                                            Toast.makeText(MainActivity.this, "Xóa thành công!", Toast.LENGTH_SHORT).show();
                                        } else {
                                            Toast.makeText(MainActivity.this, "Xóa thất bại", Toast.LENGTH_SHORT).show();
                                        }
                                        adapter.notifyDataSetChanged();
                                        listView.setAdapter(new ProductAdapter(MainActivity.this, R.layout.product_row, productDB.getAllProduct()));

                                    } catch (Exception e) {
                                        Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                    ).setNegativeButton("Hủy", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                }
            }).create().show();
            return false;
        });

        listView.setAdapter(adapter);

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
        if (productDB.getAllProduct().size() == 0) {
            isProductExist.setVisibility(View.INVISIBLE);
        }
        listView.setAdapter(new ProductAdapter(MainActivity.this, R.layout.product_row, productDB.getAllProduct()));
    }
}
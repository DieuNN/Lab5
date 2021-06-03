package com.example.lab5.Activity;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab5.Adapter.ProductAdapter;
import com.example.lab5.Model.Product;
import com.example.lab5.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ProductAdapter adapter;
    ArrayList<Product> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();

        list.add(new Product("Táo", "T", 40000, R.drawable.ic_launcher_background));
        list.add(new Product("Dưa chuột", "DC", 40000, R.color.design_default_color_error));
        list.add(new Product("Bưởi", "B", 40000, R.color.black));
        list.add(new Product("Đào", "D", 40000, R.color.purple_200));
        list.add(new Product("Vải", "V", 40000, R.color.design_default_color_secondary));
        list.add(new Product("Táo", "T", 40000, R.drawable.ic_launcher_background));
        list.add(new Product("Dưa chuột", "DC", 40000, R.color.design_default_color_error));
        list.add(new Product("Bưởi", "B", 40000, R.color.black));
        list.add(new Product("Đào", "D", 40000, R.color.purple_200));
        list.add(new Product("Vải", "V", 40000, R.color.design_default_color_secondary));
        list.add(new Product("Táo", "T", 40000, R.drawable.ic_launcher_background));
        list.add(new Product("Dưa chuột", "DC", 40000, R.color.design_default_color_error));
        list.add(new Product("Bưởi", "B", 40000, R.color.black));
        list.add(new Product("Đào", "D", 40000, R.color.purple_200));
        list.add(new Product("Vải", "V", 40000, R.color.design_default_color_secondary));
        list.add(new Product("Táo", "T", 40000, R.drawable.ic_launcher_background));
        list.add(new Product("Dưa chuột", "DC", 40000, R.color.design_default_color_error));
        list.add(new Product("Bưởi", "B", 40000, R.color.black));
        list.add(new Product("Đào", "D", 40000, R.color.purple_200));
        list.add(new Product("Vải", "V", 40000, R.color.design_default_color_secondary));

        listView.setAdapter(new ProductAdapter(MainActivity.this, R.layout.product_row, list));

    }

    private void mapping() {
        listView = findViewById(R.id.listViewProduct);

    }
}
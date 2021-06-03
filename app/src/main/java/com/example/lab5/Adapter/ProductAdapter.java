package com.example.lab5.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lab5.Model.Product;
import com.example.lab5.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ProductAdapter extends ArrayAdapter<Product> {
    public ProductAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Product> list) {
        super(context, resource, list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        convertView = inflater.inflate(R.layout.product_row, parent, false);

        ImageView image = convertView.findViewById(R.id.imageView);
        TextView name = convertView.findViewById(R.id.txtProductName);
        TextView id = convertView.findViewById(R.id.txtProductId);
        TextView price = convertView.findViewById(R.id.txtProductPrice);

        image.setImageResource(getItem(position).getImage());
        name.setText(getItem(position).getName());
        id.setText(getItem(position).getId());
        price.setText(String.valueOf(getItem(position).getPrice()));
        return convertView;
    }
}

package com.example.flap.ui.DrawerSection.merchants;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.flap.R;

import java.util.Objects;

public class ProductListingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_listing);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Product Listing");

    }
}
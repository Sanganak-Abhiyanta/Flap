package com.example.flap.ui.DrawerSection.YourOrder;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.flap.R;

import java.util.Objects;

public class YourOrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_your_order);
        Objects.requireNonNull(getSupportActionBar()).setTitle("My Order");


    }
}
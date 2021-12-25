package com.example.flap.ui.home.HelpBox;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.flap.R;

import java.util.Objects;

public class HelpMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_me);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Help Me");
    }
}
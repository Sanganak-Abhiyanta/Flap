package com.example.flap.ui.DrawerSection.LegalAndAbout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.flap.R;

public class LegalAndAboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_legal_and_about);
        getSupportActionBar().setTitle("Legal & About");
    }
}
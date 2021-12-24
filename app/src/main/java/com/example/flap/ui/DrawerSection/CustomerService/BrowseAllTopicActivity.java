package com.example.flap.ui.DrawerSection.CustomerService;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.flap.R;

import java.util.Objects;

public class BrowseAllTopicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse_all_topic);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Help Topics");
    }
}
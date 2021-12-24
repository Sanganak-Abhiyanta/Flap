package com.example.flap.ui.DrawerSection.CustomerService;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.flap.R;
import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class CustomerServiceActivity extends AppCompatActivity {
    private MaterialButton helpTopic,contactUs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_service);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Customer Service");

//        finding ids
        helpTopic=findViewById(R.id.helpTopic);
        contactUs=findViewById(R.id.contactUs);


        helpTopic.setOnClickListener(v -> {
            startActivity(new Intent(CustomerServiceActivity.this,BrowseAllTopicActivity.class));
            Toast.makeText(CustomerServiceActivity.this, "All Help Topics", Toast.LENGTH_SHORT).show();
        });

        contactUs.setOnClickListener(v -> {
            startActivity(new Intent(CustomerServiceActivity.this,RequestCallActivity.class));
            Toast.makeText(CustomerServiceActivity.this, "Contact Us", Toast.LENGTH_SHORT).show();
        });


    }
}
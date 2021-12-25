package com.example.flap.ui.DrawerSection.merchants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.flap.R;
import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class ProductListingActivity extends AppCompatActivity {
    private MaterialButton submitDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_listing);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Product Listing");

        submitDetails=findViewById(R.id.submit_detailsForProduct);



        submitDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),UploadingDetailsActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });

    }
}
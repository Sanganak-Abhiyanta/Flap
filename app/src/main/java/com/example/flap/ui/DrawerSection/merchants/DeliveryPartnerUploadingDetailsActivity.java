package com.example.flap.ui.DrawerSection.merchants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.flap.R;
import com.example.flap.ui.DrawerSection.merchants.banking.BankingDetailsForAllActivity;

import java.util.Objects;

public class DeliveryPartnerUploadingDetailsActivity extends AppCompatActivity {

    private CardView personalDetails,bankDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_partner_uploading_details);

//        setting title for personal details
        Objects.requireNonNull(getSupportActionBar()).setTitle("Upload Details");

//        getting Ids for card View
        personalDetails=findViewById(R.id.personalDetails);
        bankDetails=findViewById(R.id.bankDetails);

//        setOnclickListener on cardView
        personalDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DeliveryPartnerUploadingDetailsActivity.this, PersonalDetailsForDeliveryPartnerActivity.class));
            }
        });

        bankDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DeliveryPartnerUploadingDetailsActivity.this, BankingDetailsForAllActivity.class));
            }
        });


    }
}
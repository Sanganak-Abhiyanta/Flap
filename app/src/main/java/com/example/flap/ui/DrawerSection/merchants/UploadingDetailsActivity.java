package com.example.flap.ui.DrawerSection.merchants;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.flap.MainActivity;
import com.example.flap.R;
import com.example.flap.ui.DrawerSection.merchants.banking.BankingDetailsForAllActivity;
import com.example.flap.ui.DrawerSection.merchants.businessDetails.BusinessDetailsForAmbulanceActivity;
import com.example.flap.ui.DrawerSection.merchants.businessDetails.BusinessDetailsForDoctorActivity;
import com.example.flap.ui.DrawerSection.merchants.businessDetails.BusinessDetailsForMedicineAndEssentialsActivity;
import com.example.flap.ui.DrawerSection.merchants.documentDetails.DocumentDetailsForAmbulanceServicesActivity;
import com.example.flap.ui.DrawerSection.merchants.documentDetails.DocumentDetailsForDoctorActivity;
import com.example.flap.ui.DrawerSection.merchants.documentDetails.DocumentDetailsForMedicineActivity;
import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class UploadingDetailsActivity extends AppCompatActivity {

    private CardView businessDetails, documentation, bankDetails, productListing;
    private MaterialButton saveAndExit;
    private ImageView businessDetailsImg, documentationImg, bankDetailsImg, productListingImg;
    private String serviceType, doneBusinessDetails, doneDocumentation, doneBankingDetails, doneProductListing;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uploading_details);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Upload Details");

//        finding Ids
        businessDetails = findViewById(R.id.businessDetails);
        documentation = findViewById(R.id.documentation);
        bankDetails = findViewById(R.id.bankDetails);
        productListing = findViewById(R.id.productListing);
        saveAndExit = findViewById(R.id.save_and_exit);

        businessDetailsImg = findViewById(R.id.businessDetailsImg);
        documentationImg = findViewById(R.id.documentationImg);
        bankDetailsImg = findViewById(R.id.bankDetailsImg);
        productListingImg = findViewById(R.id.productListingImg);

        serviceType = getIntent().getStringExtra("serviceType");

        doneBusinessDetails = getIntent().getStringExtra("doneBusiness");
        doneDocumentation = getIntent().getStringExtra("doneDocument");
        doneBankingDetails = getIntent().getStringExtra("doneBank");
        doneProductListing = getIntent().getStringExtra("doneProducts");


//        if (doneBusinessDetails.equals("doneBusiness"))
//            businessDetailsImg.setBackground(getDrawable(R.drawable.circle_green));
//        if (doneBusinessDetails.equals("doneBusiness") && doneDocumentation.equals("doneDocument")) {
//            businessDetailsImg.setBackground(getDrawable(R.drawable.circle_green));
//            documentationImg.setBackground(getDrawable(R.drawable.circle_green));
//        }
//        if (doneBusinessDetails.equals("doneBusiness") && doneDocumentation.equals("doneDocument") && doneBankingDetails.equals("doneBank")) {
//            businessDetailsImg.setBackground(getDrawable(R.drawable.circle_green));
//            documentationImg.setBackground(getDrawable(R.drawable.circle_green));
//            bankDetailsImg.setBackground(getDrawable(R.drawable.circle_green));
//        }
//        if (doneBusinessDetails.equals("doneBusiness") && doneDocumentation.equals("doneDocument") && doneBankingDetails.equals("doneBank") && doneProductListing.equals("doneProducts")) {
//            businessDetailsImg.setBackground(getDrawable(R.drawable.circle_green));
//            documentationImg.setBackground(getDrawable(R.drawable.circle_green));
//            bankDetailsImg.setBackground(getDrawable(R.drawable.circle_green));
//            productListingImg.setBackground(getDrawable(R.drawable.circle_green));
//        }

        businessDetails.setOnClickListener(v -> {

            switch (serviceType) {

                case "Ambulance":
                    intent = new Intent(getApplicationContext(), BusinessDetailsForAmbulanceActivity.class);
                    intent.putExtra("serviceType", serviceType);
                    startActivity(intent);
                    break;
                case "Doctor":
                    intent = new Intent(getApplicationContext(), BusinessDetailsForDoctorActivity.class);
                    intent.putExtra("serviceType", serviceType);
                    startActivity(intent);
                    break;
                case "Medicine and Essentials":
                    intent = new Intent(getApplicationContext(), BusinessDetailsForMedicineAndEssentialsActivity.class);
                    intent.putExtra("serviceType", serviceType);
                    startActivity(intent);
                    break;
            }

        });

        documentation.setOnClickListener(v -> {

            switch (serviceType) {

                case "Ambulance":
                    intent = new Intent(getApplicationContext(), DocumentDetailsForAmbulanceServicesActivity.class);
                    intent.putExtra("serviceType", serviceType);
                    startActivity(intent);
                    break;
                case "Doctor":
                    intent = new Intent(getApplicationContext(), DocumentDetailsForDoctorActivity.class);
                    intent.putExtra("serviceType", serviceType);
                    startActivity(intent);
                    break;
                case "Medicine and Essentials":
                    intent = new Intent(getApplicationContext(), DocumentDetailsForMedicineActivity.class);
                    intent.putExtra("serviceType", serviceType);
                    startActivity(intent);
                    break;
            }

        });

        bankDetails.setOnClickListener(v ->
                startActivity(new Intent(UploadingDetailsActivity.this, BankingDetailsForAllActivity.class).putExtra("serviceType", serviceType))
        );

        productListing.setOnClickListener(v -> startActivity(new Intent(getApplicationContext(), ProductListingActivity.class).putExtra("serviceType", serviceType)));


        saveAndExit.setOnClickListener(v -> {
            if (doneBusinessDetails.equals("doneBusiness") && doneDocumentation.equals("doneDocument") && doneBankingDetails.equals("doneBank") && doneProductListing.equals("doneProducts"))
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
            else if (doneBusinessDetails.equals("doneBusiness") && doneDocumentation.equals("doneDocument") && doneBankingDetails.equals("doneBank"))
                Toast.makeText(getApplicationContext(), "Product Listing is not Completed!", Toast.LENGTH_SHORT).show();
            else if (doneBusinessDetails.equals("doneBusiness") && doneDocumentation.equals("doneDocument"))
                Toast.makeText(getApplicationContext(), "Product Listing and Bank Details are not Completed!", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(getApplicationContext(), "Only Business Details are completed!", Toast.LENGTH_SHORT).show();
        });

    }
}
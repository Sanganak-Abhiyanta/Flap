package com.example.flap.ui.DrawerSection.merchants.documentDetails;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.flap.R;
import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class DocumentDetailsForAmbulanceServicesActivity extends AppCompatActivity {

    private MaterialButton addressProofAmbulance, gstNumberAmbulance, agencyLicense, agencyPhoto, agencyOwnerPhoto, agencyOwnerSignature;
    private ImageView addressProofAmbulancePreview, gstNumberAmbulancePreview, agencyLicensePreview, agencyPhotoPreview, agencyOwnerPhotoPreview, agencyOwnerSignaturePreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_details_for_ambulance_services);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Upload Ambulance's Document");

//        getting Ids for buttons
        addressProofAmbulance = findViewById(R.id.addressProofAmbulance);
        gstNumberAmbulance = findViewById(R.id.gstNumberAmbulance);
        agencyLicense = findViewById(R.id.agencyLicense);
        agencyPhoto = findViewById(R.id.agencyPhoto);
        agencyOwnerPhoto = findViewById(R.id.agencyOwnerPhoto);
        agencyOwnerSignature = findViewById(R.id.agencyOwnerSignature);

//        getting ids for ImageView
        addressProofAmbulancePreview = findViewById(R.id.addressProofAmbulancePreview);
        gstNumberAmbulancePreview = findViewById(R.id.gstNumberAmbulancePreview);
        agencyLicensePreview = findViewById(R.id.agencyLicensePreview);
        agencyPhotoPreview = findViewById(R.id.agencyPhotoPreview);
        agencyOwnerPhotoPreview = findViewById(R.id.agencyOwnerPhotoPreview);
        agencyOwnerSignaturePreview = findViewById(R.id.agencyOwnerSignaturePreview);

//        setOnclickListener on Buttons
        addressProofAmbulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 10);
            }
        });
        gstNumberAmbulance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 20);

            }
        });
        agencyLicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(Intent.createChooser(new Intent().setType("image/*").setAction(Intent.ACTION_GET_CONTENT), "Select Picture"), 30);
            }
        });
        agencyPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(Intent.createChooser(new Intent().setType("image/*").setAction(Intent.ACTION_GET_CONTENT), "Select Picture"), 40);
            }
        });
        agencyOwnerPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(Intent.createChooser(new Intent().setType("image/*").setAction(Intent.ACTION_GET_CONTENT), "Select Picture"), 50);
            }
        });
        agencyOwnerSignature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(Intent.createChooser(new Intent().setType("image/*").setAction(Intent.ACTION_GET_CONTENT), "Select Picture"), 60);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // compare the resultCode with the
            // SELECT_PICTURE constant

            // Get the url of the image from data
            assert data != null;
            Uri selectedImageUri = data.getData();
//            try {
//                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            if (null != selectedImageUri) {

                switch (requestCode) {
                    case 10:
                        addressProofAmbulancePreview.setImageURI(selectedImageUri);
                        addressProofAmbulancePreview.setVisibility(View.VISIBLE);

                        break;
                    case 20:
                        gstNumberAmbulancePreview.setImageURI(selectedImageUri);
                        gstNumberAmbulancePreview.setVisibility(View.VISIBLE);
                        break;
                    case 30:
                        agencyLicensePreview.setImageURI(selectedImageUri);
                        agencyLicensePreview.setVisibility(View.VISIBLE);
                        break;
                    case 40:
                        agencyPhotoPreview.setImageURI(selectedImageUri);
                        agencyPhotoPreview.setVisibility(View.VISIBLE);
                        break;
                    case 50:
                        agencyOwnerPhotoPreview.setImageURI(selectedImageUri);
                        agencyOwnerPhotoPreview.setVisibility(View.VISIBLE);
                        break;

                    case 60:
                        agencyOwnerSignaturePreview.setImageURI(selectedImageUri);
                        agencyOwnerSignaturePreview.setVisibility(View.VISIBLE);
                        break;

                }


            }

        }


    }
}
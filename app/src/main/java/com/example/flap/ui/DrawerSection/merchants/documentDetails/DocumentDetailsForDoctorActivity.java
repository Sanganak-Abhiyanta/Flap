package com.example.flap.ui.DrawerSection.merchants.documentDetails;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;

import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.flap.R;

import com.google.android.material.button.MaterialButton;

import java.util.Objects;


public class DocumentDetailsForDoctorActivity extends AppCompatActivity {

//    private ProgressDialog progressDialog;

    //    private final int REQ = 1;
//    private Bitmap bitmap;
//    String downloadUrl = "";
    private MaterialButton addressProof, gstNumber, doctorPhoto, clinicPhoto, clinicLicense, signature, medicalCertificate;
    private ImageView addressProofPreview, gstNumberPreview, doctorPhotoPreview, clinicPhotoPreview, clinicLicensePreview, signaturePreview, medicalCertificatePreview;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_details_for_doctor);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Upload Doctor's Documents");

//        getting id for button
        addressProof = findViewById(R.id.addressProof);
        gstNumber = findViewById(R.id.gstinNumber);
        doctorPhoto = findViewById(R.id.doctorsPhoto);
        clinicLicense = findViewById(R.id.clinicLicense);
        clinicPhoto = findViewById(R.id.clinicPhoto);
        signature = findViewById(R.id.doctorsSignature);
        medicalCertificate = findViewById(R.id.medical_certificate);

        submitButton = findViewById(R.id.saveDocument);

//        getting Id for ImageView


        addressProofPreview = findViewById(R.id.addressProofPreview);
        gstNumberPreview = findViewById(R.id.gstinNumberPreview);
        doctorPhotoPreview = findViewById(R.id.doctorsPhotoPreview);
        clinicLicensePreview = findViewById(R.id.clinicLicensePreview);
        clinicPhotoPreview = findViewById(R.id.clinicPhotoPreview);
        signaturePreview = findViewById(R.id.doctorsSignaturePreview);
        medicalCertificatePreview = findViewById(R.id.medical_certificatePreview);


        addressProof.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 10);


            }
        });

        gstNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 20);
            }
        });

        doctorPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 30);
            }
        });

        clinicLicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 40);
            }
        });

        clinicPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 50);
            }
        });

        signature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 60);
            }
        });

        medicalCertificate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 70);
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(DocumentDetailsForDoctorActivity.this, "Document Submitted", Toast.LENGTH_SHORT).show();
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
                        addressProofPreview.setImageURI(selectedImageUri);
                        addressProofPreview.setVisibility(View.VISIBLE);

                        break;
                    case 20:
                        gstNumberPreview.setImageURI(selectedImageUri);
                        gstNumberPreview.setVisibility(View.VISIBLE);
                        break;
                    case 30:
                        doctorPhotoPreview.setImageURI(selectedImageUri);
                        doctorPhotoPreview.setVisibility(View.VISIBLE);
                        break;
                    case 40:
                        clinicLicensePreview.setImageURI(selectedImageUri);
                        clinicLicensePreview.setVisibility(View.VISIBLE);
                        break;
                    case 50:
                        clinicPhotoPreview.setImageURI(selectedImageUri);
                        clinicPhotoPreview.setVisibility(View.VISIBLE);
                        break;

                    case 60:
                        signaturePreview.setImageURI(selectedImageUri);
                        signaturePreview.setVisibility(View.VISIBLE);
                        break;
                    case 70:
                        medicalCertificatePreview.setImageURI(selectedImageUri);
                        medicalCertificatePreview.setVisibility(View.VISIBLE);
                        break;

                }


            }

        }


    }
}
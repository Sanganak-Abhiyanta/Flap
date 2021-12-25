package com.example.flap.ui.DrawerSection.merchants.documentDetails;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;


import android.Manifest;
import android.content.Context;
import android.content.Intent;

import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import android.os.health.PackageHealthStats;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.flap.R;

import com.example.flap.ui.DrawerSection.merchants.UploadingDetailsActivity;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.Objects;


public class DocumentDetailsForDoctorActivity extends AppCompatActivity {

    private MaterialButton addressProof, gstNumber, doctorPhoto, clinicPhoto, clinicLicense, signature, medicalCertificate;
    private ImageView addressProofPreview, gstNumberPreview, doctorPhotoPreview, clinicPhotoPreview, clinicLicensePreview, signaturePreview, medicalCertificatePreview;
    private Button submitButton;
    private ArrayList imageList;
    private FirebaseStorage storage;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_details_for_doctor);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Upload Doctor's Documents");

        storage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();

//        getting id for button
        addressProof = findViewById(R.id.addressProof);
        gstNumber = findViewById(R.id.gstinNumber);
        doctorPhoto = findViewById(R.id.doctorsPhoto);
        clinicLicense = findViewById(R.id.clinicLicense);
        clinicPhoto = findViewById(R.id.clinicPhoto);
        signature = findViewById(R.id.doctorsSignature);
        medicalCertificate = findViewById(R.id.medical_certificate);

        submitButton = findViewById(R.id.saveDocument);

        imageList = new ArrayList<>();

//        getting Id for ImageView


        addressProofPreview = findViewById(R.id.addressProofPreview);
        gstNumberPreview = findViewById(R.id.gstinNumberPreview);
        doctorPhotoPreview = findViewById(R.id.doctorsPhotoPreview);
        clinicLicensePreview = findViewById(R.id.clinicLicensePreview);
        clinicPhotoPreview = findViewById(R.id.clinicPhotoPreview);
        signaturePreview = findViewById(R.id.doctorsSignaturePreview);
        medicalCertificatePreview = findViewById(R.id.medical_certificatePreview);


        addressProof.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 10);


        });

        gstNumber.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 20);
        });

        doctorPhoto.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 30);
        });

        clinicLicense.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 40);
        });

        clinicPhoto.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 50);
        });

        signature.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 60);
        });

        medicalCertificate.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Picture"), 70);
        });

        submitButton.setOnClickListener(v -> {
//            uploadImages();
            Toast.makeText(DocumentDetailsForDoctorActivity.this, "Document Submitted", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(), UploadingDetailsActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
        });


    }

//    private void uploadImages() { }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {

            // Get the url of the image from data
            assert data != null;
            Uri selectedImageUri = data.getData();

            if (selectedImageUri != null) {

                switch (requestCode) {
                    case 10:
                        addressProofPreview.setImageURI(selectedImageUri);
                        addressProofPreview.setVisibility(View.VISIBLE);
                        imageList.add(0, selectedImageUri);
                        break;
                    case 20:
                        gstNumberPreview.setImageURI(selectedImageUri);
                        gstNumberPreview.setVisibility(View.VISIBLE);
                        imageList.add(1, selectedImageUri);
                        break;
                    case 30:
                        doctorPhotoPreview.setImageURI(selectedImageUri);
                        doctorPhotoPreview.setVisibility(View.VISIBLE);
                        imageList.add(2, selectedImageUri);
                        break;
                    case 40:
                        clinicLicensePreview.setImageURI(selectedImageUri);
                        clinicLicensePreview.setVisibility(View.VISIBLE);
                        imageList.add(3, selectedImageUri);
                        break;
                    case 50:
                        clinicPhotoPreview.setImageURI(selectedImageUri);
                        clinicPhotoPreview.setVisibility(View.VISIBLE);
                        imageList.add(4, selectedImageUri);
                        break;

                    case 60:
                        signaturePreview.setImageURI(selectedImageUri);
                        signaturePreview.setVisibility(View.VISIBLE);
                        imageList.add(5, selectedImageUri);
                        break;
                    case 70:
                        medicalCertificatePreview.setImageURI(selectedImageUri);
                        medicalCertificatePreview.setVisibility(View.VISIBLE);
                        imageList.add(6, selectedImageUri);
                        break;
                }
            }
        }
    }
}
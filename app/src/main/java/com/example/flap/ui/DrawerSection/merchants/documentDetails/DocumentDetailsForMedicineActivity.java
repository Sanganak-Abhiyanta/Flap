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
import com.example.flap.ui.DrawerSection.merchants.UploadingDetailsActivity;
import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class DocumentDetailsForMedicineActivity extends AppCompatActivity {

    private MaterialButton addressProofShop, gstNumberShop, shopLicense, shopOwnerPhoto, shopOwnerSignature, shopPhoto;
    private Button submitDocumentForShop;
    private ImageView addressProofShopPreview, gstNumberShopPreview, shopLicensePreview, shopOwnerPhotoPreview, shopOwnerSignaturePreview, shopPhotoPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_document_details_for_medicine);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Upload Medical's Documents");

//        getting Ids for buttons
        addressProofShop = findViewById(R.id.addressProofShop);
        gstNumberShop = findViewById(R.id.gstShopNumber);
        shopLicense = findViewById(R.id.shopLicense);
        shopOwnerPhoto = findViewById(R.id.shopOwnerPhoto);
        shopOwnerSignature = findViewById(R.id.shopOwnerSignature);
        shopPhoto = findViewById(R.id.shopPhoto);
        submitDocumentForShop = findViewById(R.id.saveDocumentForShop);

//        getting id for Image
        addressProofShopPreview = findViewById(R.id.addressProofShopPreview);
        gstNumberShopPreview = findViewById(R.id.gstShopNumberPreview);
        shopLicensePreview = findViewById(R.id.shopLicensePreview);
        shopOwnerPhotoPreview = findViewById(R.id.shopOwnerPhotoPreview);
        shopOwnerSignaturePreview = findViewById(R.id.shopOwnerSignaturePreview);
        shopPhotoPreview = findViewById(R.id.shopPhotoPreview);

//      setOnclickListener

        addressProofShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 10);
            }
        });
        gstNumberShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 20);
            }
        });
        shopLicense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 30);
            }
        });
        shopOwnerPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 40);
            }
        });
        shopOwnerSignature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 50);

            }
        });
        shopPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 60);
            }
        });

        submitDocumentForShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), UploadingDetailsActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK));
                Toast.makeText(DocumentDetailsForMedicineActivity.this, "Document Submitted", Toast.LENGTH_SHORT).show();
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
                        addressProofShopPreview.setImageURI(selectedImageUri);
                        addressProofShopPreview.setVisibility(View.VISIBLE);

                        break;
                    case 20:
                        gstNumberShopPreview.setImageURI(selectedImageUri);
                        gstNumberShopPreview.setVisibility(View.VISIBLE);
                        break;
                    case 30:
                        shopLicensePreview.setImageURI(selectedImageUri);
                        shopLicensePreview.setVisibility(View.VISIBLE);
                        break;
                    case 40:
                        shopOwnerPhotoPreview.setImageURI(selectedImageUri);
                        shopOwnerPhotoPreview.setVisibility(View.VISIBLE);
                        break;
                    case 50:
                        shopOwnerSignaturePreview.setImageURI(selectedImageUri);
                        shopOwnerSignaturePreview.setVisibility(View.VISIBLE);
                        break;

                    case 60:
                        shopPhotoPreview.setImageURI(selectedImageUri);
                        shopPhotoPreview.setVisibility(View.VISIBLE);
                        break;

                }


            }

        }


    }
}
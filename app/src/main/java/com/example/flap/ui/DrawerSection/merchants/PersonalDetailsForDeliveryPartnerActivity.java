package com.example.flap.ui.DrawerSection.merchants;

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

public class PersonalDetailsForDeliveryPartnerActivity extends AppCompatActivity {

    private MaterialButton addressProof_btn,photo_btn;
    private ImageView addressProofPreview,photoPreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_details_for_delivery_partner);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Personal Details");

//        getting Ids
        addressProof_btn=findViewById(R.id.delivery_partnerAddressProof);
        photo_btn=findViewById(R.id.delivery_partnerPhoto);

//        getting ids imageView
        addressProofPreview=findViewById(R.id.delivery_partnerAddressProofPreview);
        photoPreview=findViewById(R.id.delivery_partnerPhotoPreview);

//        setOnclickListener
        addressProof_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(Intent.createChooser(new Intent().setType("image/*").setAction(Intent.ACTION_GET_CONTENT), "Select Picture"), 10);
            }
        });

        photo_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(Intent.createChooser(new Intent().setType("image/*").setAction(Intent.ACTION_GET_CONTENT), "Select Picture"), 20);
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
                        photoPreview.setImageURI(selectedImageUri);
                        photoPreview.setVisibility(View.VISIBLE);
                        break;

                }


            }

        }


    }
}
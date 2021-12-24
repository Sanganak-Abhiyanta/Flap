package com.example.flap.ui.DrawerSection.merchants.banking;

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

public class BankingDetailsForAllActivity extends AppCompatActivity {

    private MaterialButton panCard, cancelledCheque;
    private ImageView panCardPreview, cancelledChequePreview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banking_details_for_all);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Upload Banking Details");

//        getting Ids for Button
        panCard = findViewById(R.id.panCard);
        cancelledCheque = findViewById(R.id.cancelledCheque);

//        getting ids for ImageView
        panCardPreview = findViewById(R.id.panCardPreview);
        cancelledChequePreview = findViewById(R.id.cancelledChequePreview);

//        setOnclickListener
        panCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(Intent.createChooser(new Intent().setType("image/*").setAction(Intent.ACTION_GET_CONTENT), "Select Picture"), 10);
            }
        });
        cancelledCheque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(Intent.createChooser(new Intent().setType("image/*").setAction(Intent.ACTION_GET_CONTENT), "Select Picture"), 20);
            }
        });
    }

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
                        panCardPreview.setImageURI(selectedImageUri);
                        panCardPreview.setVisibility(View.VISIBLE);

                        break;
                    case 20:
                        cancelledChequePreview.setImageURI(selectedImageUri);
                        cancelledChequePreview.setVisibility(View.VISIBLE);
                        break;

                }


            }

        }


    }
}
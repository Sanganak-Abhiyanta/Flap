package com.example.flap.ui.Medicine_and_Essentials;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.flap.R;
import com.example.flap.ui.Cart.CartActivity;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MedicineListActivity extends AppCompatActivity {
    private static final int PICK_IMAGE = 1;
    private Bitmap bitmap = null;
    private ImageView prescriptionImage;
    private MaterialButton submitPrescription, uploadPrescription, goToCart;
    private LinearLayout medicineNoData;
    private RecyclerView medicineRV;
    private List<MedicineData> medicineList;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine_list);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Medicine And Essential");

        prescriptionImage = findViewById(R.id.prescriptionImage);
        submitPrescription = findViewById(R.id.submitPrescription);
        uploadPrescription = findViewById(R.id.uploadPrescription);
        goToCart = findViewById(R.id.goToCart);
        medicineNoData = findViewById(R.id.medicineListNoData);
        medicineRV = findViewById(R.id.medicineListRV);

        uploadPrescription.setOnClickListener(v -> openGallery());
        goToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), CartActivity.class));
            }
        });

        medicineAndEssentials();
    }

    private void medicineAndEssentials() {

        databaseReference = FirebaseDatabase.getInstance().getReference().child("Medicine And Essentials");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                medicineList = new ArrayList<>();
                if (!snapshot.exists()) {
                    medicineNoData.setVisibility(View.VISIBLE);
                    medicineRV.setVisibility(View.GONE);
                } else {
                    medicineNoData.setVisibility(View.GONE);
                    medicineRV.setVisibility(View.VISIBLE);

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        MedicineData medicineData = dataSnapshot.getValue(MedicineData.class);
                        medicineList.add(medicineData);
                    }
                    medicineRV.setHasFixedSize(true);
                    medicineRV.setLayoutManager(new LinearLayoutManager(MedicineListActivity.this));

                    MedicineAdapter medicineAdapter = new MedicineAdapter(medicineList, MedicineListActivity.this, "Medicine And Essentials");
                    medicineRV.setAdapter(medicineAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(MedicineListActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void openGallery() {
        Intent getIntent = new Intent(Intent.ACTION_GET_CONTENT);
        getIntent.setType("image/*");

        Intent pickIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        pickIntent.setType("image/*");

        Intent chooserIntent = Intent.createChooser(getIntent, "Select Image");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, new Intent[]{pickIntent});

        startActivityForResult(chooserIntent, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            // Get the url of the image from data
            assert data != null;
            Uri selectedImageUri = data.getData();
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImageUri);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (null != selectedImageUri) {
                // update the preview image in the layout
                prescriptionImage.setImageURI(selectedImageUri);
                prescriptionImage.setVisibility(View.VISIBLE);
                submitPrescription.setVisibility(View.VISIBLE);
                medicineRV.setVisibility(View.GONE);
                medicineNoData.setVisibility(View.GONE);

            }
        }
    }
}
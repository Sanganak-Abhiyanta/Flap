package com.example.flap.ui.DrawerSection.merchants.businessDetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.flap.R;
import com.example.flap.ui.DrawerSection.merchants.UploadingDetailsActivity;
import com.example.flap.ui.DrawerSection.merchants.authentic.Users;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class BusinessDetailsForMedicineAndEssentialsActivity extends AppCompatActivity {
    private TextInputEditText firmName, areaPin, addressLine1, addressLine2, city, state;
    private MaterialButton submitDetails;
    private String id, serviceType;
    private ProgressDialog dialog;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_details_for_medicine_and_essentials);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Upload Medical's Business Details");



//        progress dialog
        dialog = new ProgressDialog(getApplicationContext());
        dialog.setTitle("Data Uploading....");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setProgress(0);
        dialog.setMax(100);

        serviceType = getIntent().getStringExtra("serviceType");

        firmName = findViewById(R.id.med_firm_name);
        areaPin = findViewById(R.id.med_area_pin);
        addressLine1 = findViewById(R.id.med_addressLine1);
        addressLine2 = findViewById(R.id.med_addressLine2);
        city = findViewById(R.id.med_city);
        state = findViewById(R.id.med_state);
        submitDetails = findViewById(R.id.submitBusinessDetailsForMedicine);


        submitDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.show();
                if (firmName.getText().toString().isEmpty()) {
                    firmName.setError("Empty!");
                    firmName.requestFocus();
                    dialog.dismiss();
                } else if (areaPin.getText().toString().isEmpty()) {
                    areaPin.setError("Empty!");
                    areaPin.requestFocus();
                    dialog.dismiss();
                } else if (addressLine1.getText().toString().isEmpty()) {
                    addressLine1.setError("Empty!");
                    addressLine1.requestFocus();
                    dialog.dismiss();
                } else if (addressLine2.getText().toString().isEmpty()) {
                    addressLine2.setError("Empty!");
                    addressLine2.requestFocus();
                    dialog.dismiss();
                } else if (city.getText().toString().isEmpty()) {
                    city.setError("Empty!");
                    city.requestFocus();
                    dialog.dismiss();
                } else if (state.getText().toString().isEmpty()) {
                    state.setError("Empty!");
                    state.requestFocus();
                    dialog.dismiss();
                } else {
                    databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");

                    databaseReference.addValueEventListener(new ValueEventListener() {

                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {


                            for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                                Users users = dataSnapshot.getValue(Users.class);
                                assert users != null;
                                id = users.getUserId();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });

                    Users users = new Users(firmName.getText().toString(), areaPin.getText().toString(), addressLine1.getText().toString(), addressLine2.getText().toString(), city.getText().toString(), state.getText().toString(), serviceType, id);

                    databaseReference.child(id).setValue(users);
                    dialog.dismiss();

                    Intent intent = new Intent(getApplicationContext(), UploadingDetailsActivity.class);
                    intent.putExtra("doneBusiness", "doneBusiness");
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                    dialog.dismiss();
                }

            }
        });
    }
}
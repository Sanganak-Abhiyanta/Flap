package com.example.flap.ui.DrawerSection.merchants.businessDetails;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.flap.MainActivity;
import com.example.flap.R;
import com.example.flap.ui.DrawerSection.merchants.UploadingDetailsActivity;
import com.example.flap.ui.DrawerSection.merchants.authentic.SignUpActivity;
import com.example.flap.ui.DrawerSection.merchants.authentic.Users;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class BusinessDetailsForDoctorActivity extends AppCompatActivity {

    private TextInputEditText doctorClinicName, experience, consultationFee, areaPin, addressLine1, addressLine2, city, state, timing, dailyAvailableSeats;
    private MaterialButton submitDetails;
    private String id, serviceType;
    private ProgressDialog dialog;

    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_business_details_for_doctor);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Upload Doctor's Business Details");

        doctorClinicName = findViewById(R.id.doctor_clinic_name);
        experience = findViewById(R.id.experience);
        consultationFee = findViewById(R.id.consultation_fee);
        areaPin = findViewById(R.id.area_pin);
        addressLine1 = findViewById(R.id.addressLine1);
        addressLine2 = findViewById(R.id.addressLine2);
        city = findViewById(R.id.city);
        state = findViewById(R.id.state);
        timing = findViewById(R.id.timing);
        dailyAvailableSeats = findViewById(R.id.daily_available_seat);
        submitDetails = findViewById(R.id.submitB_DetailsForDoctor);

        serviceType = getIntent().getStringExtra("serviceType");

//        progress dialog
        dialog = new ProgressDialog(getApplicationContext());
        dialog.setTitle("Data Uploading....");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setProgress(0);
        dialog.setMax(100);


//        setOnClickListener
        submitDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.show();
                if (doctorClinicName.getText().toString().isEmpty()) {
                    doctorClinicName.setError("Empty!");
                    doctorClinicName.requestFocus();
                    dialog.dismiss();
                } else if (experience.getText().toString().isEmpty()) {
                    experience.setError("Empty!");
                    experience.requestFocus();
                    dialog.dismiss();
                } else if (consultationFee.getText().toString().isEmpty()) {
                    consultationFee.setError("Empty!");
                    consultationFee.requestFocus();
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
                } else if (timing.getText().toString().isEmpty()) {
                    timing.setError("Empty!");
                    timing.requestFocus();
                    dialog.dismiss();
                } else if (dailyAvailableSeats.getText().toString().isEmpty()) {
                    dailyAvailableSeats.setError("Empty!");
                    dailyAvailableSeats.requestFocus();
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

                    Users users = new Users(doctorClinicName.getText().toString(), experience.getText().toString(), consultationFee.getText().toString(), areaPin.getText().toString(), addressLine1.getText().toString(), addressLine2.getText().toString(), city.getText().toString(), state.getText().toString(), timing.getText().toString(), dailyAvailableSeats.getText().toString(), serviceType, id);

                    databaseReference.child(id).setValue(users);
                    dialog.dismiss();

                    Intent intent = new Intent(getApplicationContext(), UploadingDetailsActivity.class);
                    intent.putExtra("doneBusiness", "doneBusiness");
                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }

            }
        });

    }
}
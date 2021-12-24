package com.example.flap.ui.DrawerSection.merchants.authentic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.flap.MainActivity;
import com.example.flap.R;
import com.example.flap.ui.DrawerSection.merchants.ServiceTypeActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.FirebaseDatabase;


import java.util.Objects;

public class ManageOtpActivity extends AppCompatActivity {
    //    private TextInputEditText emailET, nameET, phoneNumberET, passwordET, confirmPasswordET;
    private TextInputEditText otp;
    private MaterialButton submitOtp;
    private String phoneNumber, email, password, name, confirmPassword;
    private FirebaseAuth mAuth;
    private String verificationId;
    private FirebaseDatabase database;
    private ProgressBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_otp);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Submit OTP");

        phoneNumber = getIntent().getStringExtra("mobile").toString();
        email = getIntent().getStringExtra("email").toString();
        name = getIntent().getStringExtra("name").toString();
        password = getIntent().getStringExtra("password").toString();
        verificationId = getIntent().getStringExtra("verificationId");
        confirmPassword = getIntent().getStringExtra("confirmPassword");

        otp = findViewById(R.id.submitOtpEditText);
        submitOtp = findViewById(R.id.verifyOtpBtn);
        bar = findViewById(R.id.progressBar);
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();

//        createOTP();

        submitOtp.setOnClickListener(v -> {
            bar.setVisibility(View.VISIBLE);
            otp.setVisibility(View.GONE);
            submitOtp.setVisibility(View.GONE);
            if (otp.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Blank OTP field, Please Enter", Toast.LENGTH_SHORT).show();
                otp.setError("Empty");
                otp.requestFocus();
                bar.setVisibility(View.GONE);
            } else if (otp.getText().toString().length() != 6) {
                Toast.makeText(getApplicationContext(), "Less Than 6 character", Toast.LENGTH_SHORT).show();
                otp.setError("Invalid OTP");
                otp.requestFocus();
                bar.setVisibility(View.GONE);

            } else {
                if (verificationId != null) {
                    String code = otp.getText().toString();
                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
                    mAuth.signInWithCredential(credential).addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            startActivity(new Intent(getApplicationContext(), MainActivity.class)
                                    .setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));


                            Users users = new Users(name, email, password, phoneNumber, confirmPassword);
                            String id = task.getResult().getUser().getUid();
                            database.getReference().child("Users").child(id).setValue(users);
                            otp.setVisibility(View.GONE);
                            submitOtp.setVisibility(View.GONE);

                            Toast.makeText(getApplicationContext(), "User Created Successfully", Toast.LENGTH_SHORT).show();

                            startActivity(new Intent(ManageOtpActivity.this, ServiceTypeActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
                        } else {
                            Toast.makeText(getApplicationContext(), "Invalid OTP!", Toast.LENGTH_SHORT).show();
                            otp.setError("Invalid OTP");
                            otp.requestFocus();
                            bar.setVisibility(View.GONE);
                            otp.setVisibility(View.VISIBLE);
                            submitOtp.setVisibility(View.VISIBLE);
                        }
                    });
                }

            }

        });


    }

}
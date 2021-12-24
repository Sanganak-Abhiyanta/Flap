package com.example.flap.ui.DrawerSection.merchants.authentic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.flap.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class SignUpActivity extends AppCompatActivity {

    private TextView alreadyMember;
    private FirebaseAuth mAuth;

    private MaterialButton signUpButton;
    private ProgressDialog progressDialog;
    private TextInputEditText emailET, nameET, phoneNumberET, passwordET, confirmPasswordET;
//    private CountryCodePicker ccp;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBacks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
//      for full screen mode
        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        alreadyMember = findViewById(R.id.alreadyMember);
        signUpButton = findViewById(R.id.sign_up);
        emailET = findViewById(R.id.email);
        nameET = findViewById(R.id.name);
        phoneNumberET = findViewById(R.id.phone_number);
        passwordET = findViewById(R.id.password);
        confirmPasswordET = findViewById(R.id.confirm_password);
//        ccp = findViewById(R.id.ccp);

        progressDialog = new ProgressDialog(SignUpActivity.this);
        progressDialog.setTitle("Creating Account.......");
        progressDialog.setMessage("We are creating your account. Please Wait!");


        mAuth = FirebaseAuth.getInstance();

//        ccp.registerCarrierNumberEditText(phoneNumberET);

        alreadyMember.setOnClickListener(v -> startActivity(new Intent(SignUpActivity.this, LoginActivity.class)));


        signUpButton.setOnClickListener(v -> {
            progressDialog.show();

            if (phoneNumberET.getText().toString().isEmpty()) {
                Toast.makeText(getApplicationContext(), "Empty!", Toast.LENGTH_SHORT).show();
                phoneNumberET.requestFocus();
                phoneNumberET.setError("Empty!!");
                progressDialog.dismiss();
            } else if (phoneNumberET.getText().toString().length() != 10) {
                Toast.makeText(getApplicationContext(), "Invalid Phone Number!", Toast.LENGTH_SHORT).show();
                phoneNumberET.requestFocus();
                phoneNumberET.setError("Invalid Phone Number");
                progressDialog.dismiss();
            } else {
                if(passwordET.getText().toString().equals(confirmPasswordET.getText().toString()))
                otpSend();
                else{
                    Toast.makeText(getApplicationContext(), "Confirm Password is different!", Toast.LENGTH_SHORT).show();
                    confirmPasswordET.setError("Password Doesn't match!");
                    confirmPasswordET.requestFocus();
                    progressDialog.dismiss();
                }
            }

        });

    }

    private void otpSend() {

        mCallBacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

            @Override
            public void onVerificationCompleted(PhoneAuthCredential credential) {
//                signInWithPhoneAuthCredential(credential);
            }

            @Override
            public void onVerificationFailed(FirebaseException e) {
                Toast.makeText(getApplicationContext(), e.getMessage().toString(), Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }

            @Override
            public void onCodeSent(@NonNull String verificationId,
                                   @NonNull PhoneAuthProvider.ForceResendingToken token) {
                progressDialog.dismiss();
                Intent intent = new Intent(getApplicationContext(), ManageOtpActivity.class);
                intent.putExtra("mobile",phoneNumberET.getText().toString().replace(" ", ""));
                intent.putExtra("verificationId",verificationId);
                intent.putExtra("email", emailET.getText().toString());
                intent.putExtra("name", nameET.getText().toString());
                intent.putExtra("password",passwordET.getText().toString());
                intent.putExtra("confirmPassword",confirmPasswordET.getText().toString());
                startActivity(intent);

            }
        };
        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+91"+phoneNumberET.getText().toString().replace(" ", ""))       // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallBacks)          // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);
    }
//    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
//        mAuth.signInWithCredential(credential)
//                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//
//                            progressDialog.dismiss();
//                            Intent intent = new Intent(getApplicationContext(), ManageOtpActivity.class);
//                            intent.putExtra("mobile",phoneNumberET.getText().toString().replace(" ", ""));
//                            intent.putExtra("email", emailET.getText().toString());
//                            intent.putExtra("name", nameET.getText().toString());
//                            intent.putExtra("password",passwordET.getText().toString());
//                            intent.putExtra("confirmPassword",confirmPasswordET.getText().toString());
//                            startActivity(intent);
//
//                            // Update UI
//                        } else {
//                            if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
//                                // The verification code entered was invalid
//                            }
//                        }
//                    }
//                });
//    }
}
package com.example.flap.ui.home.HelpBox;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.flap.MainActivity;
import com.example.flap.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class HelpMeActivity extends AppCompatActivity {
    private TextInputEditText nameEt, emailAddressEt, phoneNumberEt, messageEt;
    private MaterialButton submitQuery;
    //    private FirebaseDatabase database;
    private DatabaseReference reference, databaseReference;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_me);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Help Me");

        nameEt = findViewById(R.id.helpMeName);
        emailAddressEt = findViewById(R.id.helpMeEmail);
        phoneNumberEt = findViewById(R.id.helpMePhoneNumber);
        messageEt = findViewById(R.id.helpMeMessage);

        submitQuery = findViewById(R.id.submitHelpMe);

        databaseReference = FirebaseDatabase.getInstance().getReference().child("HelpMe");

        progressDialog = new ProgressDialog(getApplicationContext());
        progressDialog.setTitle("Sending Message to Our Team!");
        progressDialog.setMessage("Please Wait While Sending Data :)");

        submitQuery.setOnClickListener(v -> {
            if (nameEt.getText().toString().isEmpty()) {
//                Toast.makeText(getApplicationContext(), "Name Can't be Empty!", Toast.LENGTH_SHORT).show();
                nameEt.setError("Empty");
                nameEt.requestFocus();
            } else if (emailAddressEt.getText().toString().isEmpty()) {
//                Toast.makeText(getApplicationContext(), "Email Can't be Empty!", Toast.LENGTH_SHORT).show();
                emailAddressEt.setError("Empty");
                emailAddressEt.requestFocus();
            } else if (phoneNumberEt.getText().toString().isEmpty()) {
//                Toast.makeText(getApplicationContext(), "Phone Number Can't be Empty!", Toast.LENGTH_SHORT).show();
                phoneNumberEt.setError("Empty");
                phoneNumberEt.requestFocus();
            } else if (messageEt.getText().toString().isEmpty()) {
//                Toast.makeText(getApplicationContext(), "Message Can't be Empty!", Toast.LENGTH_SHORT).show();
                messageEt.setError("Empty");
                messageEt.requestFocus();
            } else {
                progressDialog.show();
                insertData();
            }
        });

    }

    private void insertData() {

        final String uniqueKey = reference.push().getKey();
        reference = databaseReference.child(uniqueKey);
//        DoctorsData doctorsData = new DoctorsData(name, experience, address, timing, rating, downloadUrl, uniqueKey, fee);
        HelpModel helpModel=new HelpModel(nameEt.getText().toString(),emailAddressEt.getText().toString(),phoneNumberEt.getText().toString(),messageEt.getText().toString(),uniqueKey);
        reference.child(uniqueKey).setValue(helpModel).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {
                progressDialog.dismiss();
                emailAddressEt.setText("");
                nameEt.setText("");
                phoneNumberEt.setText("");
                messageEt.setText("");
                Toast.makeText(getApplicationContext(), "Query Submitted!", Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Something went wrong!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
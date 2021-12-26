package com.example.flap.ui.home.HelpBox;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.flap.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class HelpMeActivity extends AppCompatActivity {
    private TextInputEditText name, emailAddress, phoneNumber, message;
    private MaterialButton submitQuery;
    //    private FirebaseDatabase database;
    private DatabaseReference reference, databaseReference;
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_me);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Help Me");

        name = findViewById(R.id.helpMeName);
        emailAddress = findViewById(R.id.helpMeEmail);
        phoneNumber = findViewById(R.id.helpMePhoneNumber);
        message = findViewById(R.id.helpMeMessage);

        submitQuery = findViewById(R.id.submitHelpMe);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Help Me");

        submitQuery.setOnClickListener(v -> validateForm());
        progressDialog = new ProgressDialog(getApplicationContext());
        progressDialog.setTitle("Sending Message to Our Team!");
        progressDialog.setMessage("Please Wait While Sending Data :)");
    }

    private void validateForm() {
        if (Objects.requireNonNull(name.getText()).toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Name Can't be Empty!", Toast.LENGTH_SHORT).show();
            name.setError("Empty");
            name.requestFocus();
        } else if (Objects.requireNonNull(emailAddress.getText()).toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Email Can't be Empty!", Toast.LENGTH_SHORT).show();
            emailAddress.setError("Empty");
            emailAddress.requestFocus();
        } else if (Objects.requireNonNull(phoneNumber.getText()).toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Phone Number Can't be Empty!", Toast.LENGTH_SHORT).show();
            phoneNumber.setError("Empty");
            phoneNumber.requestFocus();
        } else if (Objects.requireNonNull(message.getText()).toString().isEmpty()) {
            Toast.makeText(getApplicationContext(), "Message Can't be Empty!", Toast.LENGTH_SHORT).show();
            message.setError("Empty");
            message.requestFocus();
        } else {
            progressDialog.show();
            final String uniqueKey = databaseReference.push().getKey();
            assert uniqueKey != null;
            reference = databaseReference.child(uniqueKey);
            HelpModel helpModel = new HelpModel(name.getText().toString(), emailAddress.getText().toString(),
                    phoneNumber.getText().toString(), message.getText().toString(), uniqueKey);

            reference.setValue(helpModel).addOnCompleteListener(task -> {
                progressDialog.dismiss();
                name.setText("");
                emailAddress.setText("");
                phoneNumber.setText("");
                message.setText("");
//                    startActivity(new Intent(getApplicationContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
            }).addOnFailureListener(e -> {
                progressDialog.dismiss();
                Toast.makeText(getApplicationContext(), "Something went wrong!", Toast.LENGTH_SHORT).show();
            });
        }

    }
}
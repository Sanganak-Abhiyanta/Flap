package com.example.flap.ui.DrawerSection.merchants.authentic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.example.flap.MainActivity;
import com.example.flap.R;
import com.example.flap.ui.Medicine_and_Essentials.MedicineData;
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

public class LoginActivity extends AppCompatActivity {
    private TextView forgotPassword, newUser;
    private TextInputEditText userName, password;
    private MaterialButton signInBtn;
    private FirebaseAuth auth;
    private FirebaseUser currentUser;
    private String user, pass;
    private DatabaseReference databaseReference;


    @Override
    protected void onStart() {
        super.onStart();
        if (currentUser != null) {
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Objects.requireNonNull(getSupportActionBar()).hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        forgotPassword = findViewById(R.id.forgot_password);
        newUser = findViewById(R.id.alreadyMember);
        userName = findViewById(R.id.username);
        password = findViewById(R.id.password);
        signInBtn = findViewById(R.id.sign_in);

        auth = FirebaseAuth.getInstance();
        currentUser = auth.getCurrentUser();

        newUser.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, SignUpActivity.class)));
        forgotPassword.setOnClickListener(v -> startActivity(new Intent(LoginActivity.this, ForgotPasswordActivity.class)));
        signInBtn.setOnClickListener(v -> {

            databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");
            databaseReference.addValueEventListener(new ValueEventListener() {

                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {

                    if (!snapshot.exists()) {
                        startActivity(new Intent(getApplicationContext(), SignUpActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
                    } else {
                        for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                            Users users = dataSnapshot.getValue(Users.class);
                            assert users != null;
                            user = users.getMail().toString();
                            pass = users.getPassword().toString();
                            if (userName.getText().toString().isEmpty()) {
                                Toast.makeText(getApplicationContext(), "Username cannot be blank!", Toast.LENGTH_SHORT).show();
                                userName.requestFocus();
                                userName.setError("Blank");
                            } else if (userName.getText().toString().equals(user)) {
                                if (password.getText().toString().isEmpty()) {
                                    Toast.makeText(getApplicationContext(), "Password cannot be Empty!", Toast.LENGTH_SHORT).show();
                                    password.requestFocus();
                                    password.setError("Blank");
                                } else if (password.getText().toString().equals(pass)) {
                                    startActivity(new Intent(getApplicationContext(), MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK));
                                } else {
                                    Toast.makeText(getApplicationContext(), "Password doesn't match!", Toast.LENGTH_SHORT).show();
                                    password.requestFocus();
                                    password.setError("Doesn't match!");
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Username doesn't exist!", Toast.LENGTH_SHORT).show();
                                userName.requestFocus();
                                userName.setError("Doesn't Exist!");
                            }
                        }

                    }

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });


        });


    }


}
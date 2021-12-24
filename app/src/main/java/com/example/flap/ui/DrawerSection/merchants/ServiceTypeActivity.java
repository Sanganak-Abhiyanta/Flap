package com.example.flap.ui.DrawerSection.merchants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.flap.R;
import com.google.android.material.button.MaterialButton;

import java.util.Objects;

public class ServiceTypeActivity extends AppCompatActivity {
    private String category;
    private Spinner serviceType;
    private MaterialButton continueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_type);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Select Service Type");

        serviceType = findViewById(R.id.service_type);
        continueButton = findViewById(R.id.continueBtn);
//        this following code for spinner
        String[] items = new String[]{"Select Service Type!", "Ambulance", "Doctor", "Medicine and Essentials", "Delivery Partner"};
        serviceType.setAdapter(new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, items));
//        setOnItemSelectedListener on category
        serviceType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                category = serviceType.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (category.equals("Select Service Type!")) {
                    Toast.makeText(getApplicationContext(), "Please Select Service Type!", Toast.LENGTH_SHORT).show();
                } else if (category.equals("Delivery Partner")) {
                    Intent intent = new Intent(getApplicationContext(), DeliveryPartnerUploadingDetailsActivity.class);
                    intent.putExtra("serviceType", category);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(), UploadingDetailsActivity.class);
                    intent.putExtra("serviceType", category);
                    startActivity(intent);
                }

            }
        });
    }
}
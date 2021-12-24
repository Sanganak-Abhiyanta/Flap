package com.example.flap.ui.Ambulance;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.flap.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.Objects;

public class AmbulanceActivity extends AppCompatActivity {
    private ImageView swapText;
    private String ambulanceType;
    private TextInputEditText from, to;
    private Spinner spinner;
    private String fromPlace, toPlace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ambulance);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Ambulance");

        swapText = findViewById(R.id.swapTextImageView);
        from = findViewById(R.id.from);
        to = findViewById(R.id.to);

        spinner = findViewById(R.id.ambulanceType);
//        this following code for spinner
        String[] items = new String[]{"Select Ambulance Type", "Advance Life Support", "Basic Life Support", "Patient Transport", " Mortuary"};
        spinner.setAdapter(new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item, items));

//        setOnItemSelectedListener on category
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ambulanceType = spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


//        setOnclickListener on swapTextImage
        swapText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fromPlace = from.getText().toString();
                toPlace = to.getText().toString();
                from.setText(toPlace);
                to.setText(fromPlace);
            }
        });
    }
}
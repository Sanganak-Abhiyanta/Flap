package com.example.flap.ui.DrawerSection.CustomerService;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.flap.R;

import java.util.Objects;

public class RequestCallActivity extends AppCompatActivity {

    private Spinner spinner;
    private String language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_call);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Request A Call");

        spinner=findViewById(R.id.language);


//        this following code for spinner
        String[] items = new String[]{"Select Language","Hindi" ,"English","Bhojpuri"," Magahi"};
        spinner.setAdapter(new ArrayAdapter<String>(this,
                R.layout.support_simple_spinner_dropdown_item,items));

//        setOnItemSelectedListener on category
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                language=spinner.getSelectedItem().toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}
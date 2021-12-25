package com.example.flap.ui.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.flap.R;
import com.example.flap.ui.Ambulance.AmbulanceActivity;
import com.example.flap.ui.Medicine_and_Essentials.MedicineListActivity;
import com.example.flap.ui.doctors.DoctorsCategoriesActivity;
import com.example.flap.ui.home.HelpBox.HelpMeActivity;


public class HomeFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_home, container, false);// Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        TextView doctorText, medicineText, ambulanceText;
        ImageView helpMe, doctorsImg, medicinesImg;
        ConstraintLayout ambulance;

//        getting Ids
        doctorsImg = view.findViewById(R.id.doctor_img);
        medicinesImg = view.findViewById(R.id.medicine_img);
        ambulance = view.findViewById(R.id.ambulance);
        doctorText = view.findViewById(R.id.doctor_text);
        medicineText = view.findViewById(R.id.medicine_text);
        ambulanceText = view.findViewById(R.id.ambulance_text);
        helpMe = view.findViewById(R.id.helpMe);

        doctorsImg.setOnClickListener(v -> {
            Intent intent = new Intent(getActivity(), DoctorsCategoriesActivity.class);
            startActivity(intent);
        });
        doctorText.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), DoctorsCategoriesActivity.class));
        });

        medicinesImg.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), MedicineListActivity.class));
        });
        medicineText.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), MedicineListActivity.class));
        });

        ambulance.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), AmbulanceActivity.class));
        });
        ambulanceText.setOnClickListener(v -> {
            startActivity(new Intent(getActivity(), AmbulanceActivity.class));
        });

        helpMe.setOnClickListener(v -> startActivity(new Intent(getActivity(), HelpMeActivity.class)));

        return view;
    }

}
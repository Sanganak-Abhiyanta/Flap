package com.example.flap.ui.doctors.allFragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.flap.R;
import com.example.flap.ui.doctors.DoctorsAdapter;
import com.example.flap.ui.doctors.DoctorsData;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EyeDoctorsFragment extends Fragment {


    private RecyclerView eyeDoctorRV;
    private LinearLayout eyeDoctorNoData;
    private List<DoctorsData> eyeDoctorList;

    private DatabaseReference databaseReference, reference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_eye_doctors, container, false);


//        dataBaseReference
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Doctor");
        //        finding ids for recyclerView
        eyeDoctorRV = view.findViewById(R.id.eyeDoctorRV);
        eyeDoctorNoData = view.findViewById(R.id.eyeDoctorNoData);

        reference = databaseReference.child("Eye");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                eyeDoctorList = new ArrayList<>();
                if (!snapshot.exists()) {
                    eyeDoctorNoData.setVisibility(View.VISIBLE);
                    eyeDoctorRV.setVisibility(View.GONE);
                } else {
                    eyeDoctorNoData.setVisibility(View.GONE);
                    eyeDoctorRV.setVisibility(View.VISIBLE);

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        DoctorsData doctorsData = dataSnapshot.getValue(DoctorsData.class);
                        eyeDoctorList.add(doctorsData);
                    }
                    eyeDoctorRV.setHasFixedSize(true);
                    eyeDoctorRV.setLayoutManager(new LinearLayoutManager(getActivity()));

                    DoctorsAdapter doctorsAdapter = new DoctorsAdapter(eyeDoctorList, getActivity(), "Eye");
                    eyeDoctorRV.setAdapter(doctorsAdapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getActivity(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }





}
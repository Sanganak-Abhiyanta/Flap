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

public class AyurvedaDoctorFragment extends Fragment {

    private RecyclerView ayurvedaRV;
    private LinearLayout ayurvedaNoData;
    private List<DoctorsData> ayurvedaList;

    private DatabaseReference databaseReference, reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_ayurveda_doctor, container, false);


//        dataBaseReference
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Doctor");
        //        finding ids for recyclerView
        ayurvedaRV = view.findViewById(R.id.ayurvedaDoctorRV);
        ayurvedaNoData = view.findViewById(R.id.ayurvedaNodData);

        reference = databaseReference.child("Ayurveda");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                ayurvedaList = new ArrayList<>();
                if (!snapshot.exists()) {
                    ayurvedaNoData.setVisibility(View.VISIBLE);
                    ayurvedaRV.setVisibility(View.GONE);
                } else {
                    ayurvedaNoData.setVisibility(View.GONE);
                    ayurvedaRV.setVisibility(View.VISIBLE);

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        DoctorsData doctorsData = dataSnapshot.getValue(DoctorsData.class);
                        ayurvedaList.add(doctorsData);
                    }
                    ayurvedaRV.setHasFixedSize(true);
                    ayurvedaRV.setLayoutManager(new LinearLayoutManager(getActivity()));

                    DoctorsAdapter doctorsAdapter = new DoctorsAdapter(ayurvedaList, getActivity(), "Ayurveda");
                    ayurvedaRV.setAdapter(doctorsAdapter);
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
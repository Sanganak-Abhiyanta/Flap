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

public class DermatologistDoctorFragment extends Fragment {

    private RecyclerView dermatologistRV;
    private LinearLayout dermatologistNoData;
    private List<DoctorsData> dermatologistList;

    private DatabaseReference databaseReference, reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dermatologist_doctor, container, false);


//        dataBaseReference
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Doctor");
        //        finding ids for recyclerView
        dermatologistRV = view.findViewById(R.id.dermatologistDoctorRV);
        dermatologistNoData = view.findViewById(R.id.dermatologistNodData);

        reference = databaseReference.child("Dermatologist");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dermatologistList = new ArrayList<>();
                if (!snapshot.exists()) {
                    dermatologistNoData.setVisibility(View.VISIBLE);
                    dermatologistRV.setVisibility(View.GONE);
                } else {
                    dermatologistNoData.setVisibility(View.GONE);
                    dermatologistRV.setVisibility(View.VISIBLE);

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        DoctorsData doctorsData = dataSnapshot.getValue(DoctorsData.class);
                        dermatologistList.add(doctorsData);
                    }
                    dermatologistRV.setHasFixedSize(true);
                    dermatologistRV.setLayoutManager(new LinearLayoutManager(getActivity()));

                    DoctorsAdapter doctorsAdapter = new DoctorsAdapter(dermatologistList, getActivity(), "Dermatologist");
                    dermatologistRV.setAdapter(doctorsAdapter);
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
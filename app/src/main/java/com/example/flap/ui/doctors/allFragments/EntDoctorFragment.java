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

public class EntDoctorFragment extends Fragment {
    private RecyclerView entRV;
    private LinearLayout entNoData;
    private List<DoctorsData> entList;

    private DatabaseReference databaseReference, reference;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_ent_doctor, container, false);


//        dataBaseReference
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Doctor");
        //        finding ids for recyclerView
        entRV = view.findViewById(R.id.entDoctorRV);
        entNoData = view.findViewById(R.id.entNodData);

        reference = databaseReference.child("Ear,Nose,Throat");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                entList = new ArrayList<>();
                if (!snapshot.exists()) {
                    entNoData.setVisibility(View.VISIBLE);
                    entRV.setVisibility(View.GONE);
                } else {
                    entNoData.setVisibility(View.GONE);
                    entRV.setVisibility(View.VISIBLE);

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        DoctorsData doctorsData = dataSnapshot.getValue(DoctorsData.class);
                        entList.add(doctorsData);
                    }
                    entRV.setHasFixedSize(true);
                    entRV.setLayoutManager(new LinearLayoutManager(getActivity()));

                    DoctorsAdapter doctorsAdapter = new DoctorsAdapter(entList, getActivity(), "Ear,Nose,Throat");
                    entRV.setAdapter(doctorsAdapter);
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
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

public class PhysiotherapyDoctorFragment extends Fragment {
    private RecyclerView physiotherapyRV;
    private LinearLayout physiotherapyNoData;
    private List<DoctorsData> physiotherapyList;

    private DatabaseReference databaseReference, reference;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_physiotherapy_doctor, container, false);




//        dataBaseReference
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Doctor");
        //        finding ids for recyclerView
        physiotherapyRV = view.findViewById(R.id.physiotherapyDoctorRV);
        physiotherapyNoData = view.findViewById(R.id.physiotherapyNodData);

        reference = databaseReference.child("Physiotherapy");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                physiotherapyList = new ArrayList<>();
                if (!snapshot.exists()) {
                    physiotherapyNoData.setVisibility(View.VISIBLE);
                    physiotherapyRV.setVisibility(View.GONE);
                } else {
                    physiotherapyNoData.setVisibility(View.GONE);
                    physiotherapyRV.setVisibility(View.VISIBLE);

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        DoctorsData doctorsData = dataSnapshot.getValue(DoctorsData.class);
                        physiotherapyList.add(doctorsData);
                    }
                    physiotherapyRV.setHasFixedSize(true);
                    physiotherapyRV.setLayoutManager(new LinearLayoutManager(getActivity()));

                    DoctorsAdapter doctorsAdapter = new DoctorsAdapter(physiotherapyList, getActivity(), "Physiotherapy");
                    physiotherapyRV.setAdapter(doctorsAdapter);
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
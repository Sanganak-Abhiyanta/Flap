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

public class DentistDoctorFragment extends Fragment {


    private RecyclerView dentistRV;
    private LinearLayout dentistNoData;
    private List<DoctorsData> dentistList;

    private DatabaseReference databaseReference, reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_dentist_dcotor, container, false);


//        dataBaseReference
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Doctor");
        //        finding ids for recyclerView
        dentistRV = view.findViewById(R.id.dentistDoctorRV);
        dentistNoData = view.findViewById(R.id.dentistNodData);

        reference = databaseReference.child("Dentist");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                dentistList = new ArrayList<>();
                if (!snapshot.exists()) {
                    dentistNoData.setVisibility(View.VISIBLE);
                    dentistRV.setVisibility(View.GONE);
                } else {
                    dentistNoData.setVisibility(View.GONE);
                    dentistRV.setVisibility(View.VISIBLE);

                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        DoctorsData doctorsData = dataSnapshot.getValue(DoctorsData.class);
                        dentistList.add(doctorsData);
                    }
                    dentistRV.setHasFixedSize(true);
                    dentistRV.setLayoutManager(new LinearLayoutManager(getActivity()));

                    DoctorsAdapter doctorsAdapter = new DoctorsAdapter(dentistList, getActivity(), "Dentist");
                    dentistRV.setAdapter(doctorsAdapter);
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
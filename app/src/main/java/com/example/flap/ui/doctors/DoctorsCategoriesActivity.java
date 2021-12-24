package com.example.flap.ui.doctors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

import com.example.flap.R;
import com.example.flap.ui.doctors.allFragments.AyurvedaDoctorFragment;
import com.example.flap.ui.doctors.allFragments.CancerDoctorFragment;
import com.example.flap.ui.doctors.allFragments.CardiologistDoctorFragment;
import com.example.flap.ui.doctors.allFragments.DentistDoctorFragment;
import com.example.flap.ui.doctors.allFragments.DermatologistDoctorFragment;
import com.example.flap.ui.doctors.allFragments.EntDoctorFragment;
import com.example.flap.ui.doctors.allFragments.EyeDoctorsFragment;
import com.example.flap.ui.doctors.allFragments.GeneralDoctorFragment;
import com.example.flap.ui.doctors.allFragments.GynecologistDoctorFragment;
import com.example.flap.ui.doctors.allFragments.HomeopathyDoctorFragment;
import com.example.flap.ui.doctors.allFragments.NeurologistDoctorFragment;
import com.example.flap.ui.doctors.allFragments.OrthopedicDoctorFragment;
import com.example.flap.ui.doctors.allFragments.PediatricsDoctorFragment;
import com.example.flap.ui.doctors.allFragments.PhysiotherapyDoctorFragment;
import com.example.flap.ui.doctors.allFragments.SexologistDoctorFragment;
import com.example.flap.ui.doctors.allFragments.VeterinaryDoctorFragment;

import java.util.Objects;

public class DoctorsCategoriesActivity extends AppCompatActivity {
    private CardView eye, ent, general, gynecologist, dermatologist, neurologist, cardiologist, homeopathy, cancer, sexologist, dentist,
            pediatrics, orthopedic, ayurveda, physiotherapy, veterinary;
    private ScrollView doctorsCategoriesScrollView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors_categories);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Doctors Categories");




        doctorsCategoriesScrollView = findViewById(R.id.doctorsCategoriesScrollView);
        doctorsCategoriesScrollView.setVerticalScrollBarEnabled(false);
        doctorsCategoriesScrollView.setHorizontalScrollBarEnabled(false);

        eye = findViewById(R.id.eye);
        ent = findViewById(R.id.ent);
        general = findViewById(R.id.general_physician);
        gynecologist = findViewById(R.id.gynecologist);
        dermatologist = findViewById(R.id.dermatologist);
        neurologist = findViewById(R.id.neurologist);
        cardiologist = findViewById(R.id.cardiologist);
        homeopathy = findViewById(R.id.homeopathy);
        cancer = findViewById(R.id.cancer);
        sexologist = findViewById(R.id.sexologist);
        dentist = findViewById(R.id.dentist);
        pediatrics = findViewById(R.id.pediatrics);
        orthopedic = findViewById(R.id.orthopedic);
        ayurveda = findViewById(R.id.ayurveda);
        physiotherapy = findViewById(R.id.physiotherapy);
        veterinary = findViewById(R.id.veterinary);



        eye.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.doctorsCategoriesFrameLayout, new EyeDoctorsFragment()).commit();
            eye.setVisibility(View.GONE);
            ent.setVisibility(View.GONE);
            general.setVisibility(View.GONE);
            gynecologist.setVisibility(View.GONE);
            dermatologist.setVisibility(View.GONE);
            neurologist.setVisibility(View.GONE);
            cardiologist.setVisibility(View.GONE);
            homeopathy.setVisibility(View.GONE);
            cancer.setVisibility(View.GONE);
            sexologist.setVisibility(View.GONE);
            dentist.setVisibility(View.GONE);
            pediatrics.setVisibility(View.GONE);
            orthopedic.setVisibility(View.GONE);
            ayurveda.setVisibility(View.GONE);
            physiotherapy.setVisibility(View.GONE);
            veterinary.setVisibility(View.GONE);
            Objects.requireNonNull(getSupportActionBar()).setTitle("Eye Doctor List");


        });
        ent.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.doctorsCategoriesFrameLayout, new EntDoctorFragment()).commit();
            eye.setVisibility(View.GONE);
            ent.setVisibility(View.GONE);
            general.setVisibility(View.GONE);
            gynecologist.setVisibility(View.GONE);
            dermatologist.setVisibility(View.GONE);
            neurologist.setVisibility(View.GONE);
            cardiologist.setVisibility(View.GONE);
            homeopathy.setVisibility(View.GONE);
            cancer.setVisibility(View.GONE);
            sexologist.setVisibility(View.GONE);
            dentist.setVisibility(View.GONE);
            pediatrics.setVisibility(View.GONE);
            orthopedic.setVisibility(View.GONE);
            ayurveda.setVisibility(View.GONE);
            physiotherapy.setVisibility(View.GONE);
            veterinary.setVisibility(View.GONE);
            Objects.requireNonNull(getSupportActionBar()).setTitle("ENT Doctor List");
        });
        general.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.doctorsCategoriesFrameLayout, new GeneralDoctorFragment()).commit();
            eye.setVisibility(View.GONE);
            ent.setVisibility(View.GONE);
            general.setVisibility(View.GONE);
            gynecologist.setVisibility(View.GONE);
            dermatologist.setVisibility(View.GONE);
            neurologist.setVisibility(View.GONE);
            cardiologist.setVisibility(View.GONE);
            homeopathy.setVisibility(View.GONE);
            cancer.setVisibility(View.GONE);
            sexologist.setVisibility(View.GONE);
            dentist.setVisibility(View.GONE);
            pediatrics.setVisibility(View.GONE);
            orthopedic.setVisibility(View.GONE);
            ayurveda.setVisibility(View.GONE);
            physiotherapy.setVisibility(View.GONE);
            veterinary.setVisibility(View.GONE);
            Objects.requireNonNull(getSupportActionBar()).setTitle("General Physician Doctor List");
        });
        gynecologist.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.doctorsCategoriesFrameLayout, new GynecologistDoctorFragment()).commit();
            eye.setVisibility(View.GONE);
            ent.setVisibility(View.GONE);
            general.setVisibility(View.GONE);
            gynecologist.setVisibility(View.GONE);
            dermatologist.setVisibility(View.GONE);
            neurologist.setVisibility(View.GONE);
            cardiologist.setVisibility(View.GONE);
            homeopathy.setVisibility(View.GONE);
            cancer.setVisibility(View.GONE);
            sexologist.setVisibility(View.GONE);
            dentist.setVisibility(View.GONE);
            pediatrics.setVisibility(View.GONE);
            orthopedic.setVisibility(View.GONE);
            ayurveda.setVisibility(View.GONE);
            physiotherapy.setVisibility(View.GONE);
            veterinary.setVisibility(View.GONE);
            Objects.requireNonNull(getSupportActionBar()).setTitle("Gynecologist Doctor List");
        });
        dermatologist.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.doctorsCategoriesFrameLayout, new DermatologistDoctorFragment()).commit();
            eye.setVisibility(View.GONE);
            ent.setVisibility(View.GONE);
            general.setVisibility(View.GONE);
            gynecologist.setVisibility(View.GONE);
            dermatologist.setVisibility(View.GONE);
            neurologist.setVisibility(View.GONE);
            cardiologist.setVisibility(View.GONE);
            homeopathy.setVisibility(View.GONE);
            cancer.setVisibility(View.GONE);
            sexologist.setVisibility(View.GONE);
            dentist.setVisibility(View.GONE);
            pediatrics.setVisibility(View.GONE);
            orthopedic.setVisibility(View.GONE);
            ayurveda.setVisibility(View.GONE);
            physiotherapy.setVisibility(View.GONE);
            veterinary.setVisibility(View.GONE);
            Objects.requireNonNull(getSupportActionBar()).setTitle("Dermatologist Doctor List");
        });
        neurologist.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.doctorsCategoriesFrameLayout, new NeurologistDoctorFragment()).commit();
            eye.setVisibility(View.GONE);
            ent.setVisibility(View.GONE);
            general.setVisibility(View.GONE);
            gynecologist.setVisibility(View.GONE);
            dermatologist.setVisibility(View.GONE);
            neurologist.setVisibility(View.GONE);
            cardiologist.setVisibility(View.GONE);
            homeopathy.setVisibility(View.GONE);
            cancer.setVisibility(View.GONE);
            sexologist.setVisibility(View.GONE);
            dentist.setVisibility(View.GONE);
            pediatrics.setVisibility(View.GONE);
            orthopedic.setVisibility(View.GONE);
            ayurveda.setVisibility(View.GONE);
            physiotherapy.setVisibility(View.GONE);
            veterinary.setVisibility(View.GONE);
            Objects.requireNonNull(getSupportActionBar()).setTitle("Neurologist Doctor List");
        });
        cardiologist.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.doctorsCategoriesFrameLayout, new CardiologistDoctorFragment()).commit();
            eye.setVisibility(View.GONE);
            ent.setVisibility(View.GONE);
            general.setVisibility(View.GONE);
            gynecologist.setVisibility(View.GONE);
            dermatologist.setVisibility(View.GONE);
            neurologist.setVisibility(View.GONE);
            cardiologist.setVisibility(View.GONE);
            homeopathy.setVisibility(View.GONE);
            cancer.setVisibility(View.GONE);
            sexologist.setVisibility(View.GONE);
            dentist.setVisibility(View.GONE);
            pediatrics.setVisibility(View.GONE);
            orthopedic.setVisibility(View.GONE);
            ayurveda.setVisibility(View.GONE);
            physiotherapy.setVisibility(View.GONE);
            veterinary.setVisibility(View.GONE);
            Objects.requireNonNull(getSupportActionBar()).setTitle("Cardiologist Doctor List");
        });
        homeopathy.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.doctorsCategoriesFrameLayout, new HomeopathyDoctorFragment()).commit();
            eye.setVisibility(View.GONE);
            ent.setVisibility(View.GONE);
            general.setVisibility(View.GONE);
            gynecologist.setVisibility(View.GONE);
            dermatologist.setVisibility(View.GONE);
            neurologist.setVisibility(View.GONE);
            cardiologist.setVisibility(View.GONE);
            homeopathy.setVisibility(View.GONE);
            cancer.setVisibility(View.GONE);
            sexologist.setVisibility(View.GONE);
            dentist.setVisibility(View.GONE);
            pediatrics.setVisibility(View.GONE);
            orthopedic.setVisibility(View.GONE);
            ayurveda.setVisibility(View.GONE);
            physiotherapy.setVisibility(View.GONE);
            veterinary.setVisibility(View.GONE);
            Objects.requireNonNull(getSupportActionBar()).setTitle("Homeopathy Doctor List");
        });
        cancer.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.doctorsCategoriesFrameLayout, new CancerDoctorFragment()).commit();
            eye.setVisibility(View.GONE);
            ent.setVisibility(View.GONE);
            general.setVisibility(View.GONE);
            gynecologist.setVisibility(View.GONE);
            dermatologist.setVisibility(View.GONE);
            neurologist.setVisibility(View.GONE);
            cardiologist.setVisibility(View.GONE);
            homeopathy.setVisibility(View.GONE);
            cancer.setVisibility(View.GONE);
            sexologist.setVisibility(View.GONE);
            dentist.setVisibility(View.GONE);
            pediatrics.setVisibility(View.GONE);
            orthopedic.setVisibility(View.GONE);
            ayurveda.setVisibility(View.GONE);
            physiotherapy.setVisibility(View.GONE);
            veterinary.setVisibility(View.GONE);
            Objects.requireNonNull(getSupportActionBar()).setTitle("Cancer Doctor List");
        });
        sexologist.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.doctorsCategoriesFrameLayout, new SexologistDoctorFragment()).commit();
            eye.setVisibility(View.GONE);
            ent.setVisibility(View.GONE);
            general.setVisibility(View.GONE);
            gynecologist.setVisibility(View.GONE);
            dermatologist.setVisibility(View.GONE);
            neurologist.setVisibility(View.GONE);
            cardiologist.setVisibility(View.GONE);
            homeopathy.setVisibility(View.GONE);
            cancer.setVisibility(View.GONE);
            sexologist.setVisibility(View.GONE);
            dentist.setVisibility(View.GONE);
            pediatrics.setVisibility(View.GONE);
            orthopedic.setVisibility(View.GONE);
            ayurveda.setVisibility(View.GONE);
            physiotherapy.setVisibility(View.GONE);
            veterinary.setVisibility(View.GONE);
            Objects.requireNonNull(getSupportActionBar()).setTitle("Sexologist Doctor List");
        });
        dentist.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.doctorsCategoriesFrameLayout, new DentistDoctorFragment()).commit();
            eye.setVisibility(View.GONE);
            ent.setVisibility(View.GONE);
            general.setVisibility(View.GONE);
            gynecologist.setVisibility(View.GONE);
            dermatologist.setVisibility(View.GONE);
            neurologist.setVisibility(View.GONE);
            cardiologist.setVisibility(View.GONE);
            homeopathy.setVisibility(View.GONE);
            cancer.setVisibility(View.GONE);
            sexologist.setVisibility(View.GONE);
            dentist.setVisibility(View.GONE);
            pediatrics.setVisibility(View.GONE);
            orthopedic.setVisibility(View.GONE);
            ayurveda.setVisibility(View.GONE);
            physiotherapy.setVisibility(View.GONE);
            veterinary.setVisibility(View.GONE);
            Objects.requireNonNull(getSupportActionBar()).setTitle("Dentist Doctor List");
        });
        pediatrics.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.doctorsCategoriesFrameLayout, new PediatricsDoctorFragment()).commit();
            eye.setVisibility(View.GONE);
            ent.setVisibility(View.GONE);
            general.setVisibility(View.GONE);
            gynecologist.setVisibility(View.GONE);
            dermatologist.setVisibility(View.GONE);
            neurologist.setVisibility(View.GONE);
            cardiologist.setVisibility(View.GONE);
            homeopathy.setVisibility(View.GONE);
            cancer.setVisibility(View.GONE);
            sexologist.setVisibility(View.GONE);
            dentist.setVisibility(View.GONE);
            pediatrics.setVisibility(View.GONE);
            orthopedic.setVisibility(View.GONE);
            ayurveda.setVisibility(View.GONE);
            physiotherapy.setVisibility(View.GONE);
            veterinary.setVisibility(View.GONE);
            Objects.requireNonNull(getSupportActionBar()).setTitle("Pediatrics Doctor List");
        });
        orthopedic.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.doctorsCategoriesFrameLayout, new OrthopedicDoctorFragment()).commit();
            eye.setVisibility(View.GONE);
            ent.setVisibility(View.GONE);
            general.setVisibility(View.GONE);
            gynecologist.setVisibility(View.GONE);
            dermatologist.setVisibility(View.GONE);
            neurologist.setVisibility(View.GONE);
            cardiologist.setVisibility(View.GONE);
            homeopathy.setVisibility(View.GONE);
            cancer.setVisibility(View.GONE);
            sexologist.setVisibility(View.GONE);
            dentist.setVisibility(View.GONE);
            pediatrics.setVisibility(View.GONE);
            orthopedic.setVisibility(View.GONE);
            ayurveda.setVisibility(View.GONE);
            physiotherapy.setVisibility(View.GONE);
            veterinary.setVisibility(View.GONE);
            Objects.requireNonNull(getSupportActionBar()).setTitle("Orthopedic Doctor List");
        });
        ayurveda.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.doctorsCategoriesFrameLayout, new AyurvedaDoctorFragment()).commit();
            eye.setVisibility(View.GONE);
            ent.setVisibility(View.GONE);
            general.setVisibility(View.GONE);
            gynecologist.setVisibility(View.GONE);
            dermatologist.setVisibility(View.GONE);
            neurologist.setVisibility(View.GONE);
            cardiologist.setVisibility(View.GONE);
            homeopathy.setVisibility(View.GONE);
            cancer.setVisibility(View.GONE);
            sexologist.setVisibility(View.GONE);
            dentist.setVisibility(View.GONE);
            pediatrics.setVisibility(View.GONE);
            orthopedic.setVisibility(View.GONE);
            ayurveda.setVisibility(View.GONE);
            physiotherapy.setVisibility(View.GONE);
            veterinary.setVisibility(View.GONE);
            getSupportActionBar().setTitle("Ayurveda Doctor List");
        });
        physiotherapy.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.doctorsCategoriesFrameLayout, new PhysiotherapyDoctorFragment()).commit();
            eye.setVisibility(View.GONE);
            ent.setVisibility(View.GONE);
            general.setVisibility(View.GONE);
            gynecologist.setVisibility(View.GONE);
            dermatologist.setVisibility(View.GONE);
            neurologist.setVisibility(View.GONE);
            cardiologist.setVisibility(View.GONE);
            homeopathy.setVisibility(View.GONE);
            cancer.setVisibility(View.GONE);
            sexologist.setVisibility(View.GONE);
            dentist.setVisibility(View.GONE);
            pediatrics.setVisibility(View.GONE);
            orthopedic.setVisibility(View.GONE);
            ayurveda.setVisibility(View.GONE);
            physiotherapy.setVisibility(View.GONE);
            veterinary.setVisibility(View.GONE);
            Objects.requireNonNull(getSupportActionBar()).setTitle("Physiotherapy Doctor List");
        });
        veterinary.setOnClickListener(v -> {
            getSupportFragmentManager().beginTransaction().replace(R.id.doctorsCategoriesFrameLayout, new VeterinaryDoctorFragment()).commit();
            eye.setVisibility(View.GONE);
            ent.setVisibility(View.GONE);
            general.setVisibility(View.GONE);
            gynecologist.setVisibility(View.GONE);
            dermatologist.setVisibility(View.GONE);
            neurologist.setVisibility(View.GONE);
            cardiologist.setVisibility(View.GONE);
            homeopathy.setVisibility(View.GONE);
            cancer.setVisibility(View.GONE);
            sexologist.setVisibility(View.GONE);
            dentist.setVisibility(View.GONE);
            pediatrics.setVisibility(View.GONE);
            orthopedic.setVisibility(View.GONE);
            ayurveda.setVisibility(View.GONE);
            physiotherapy.setVisibility(View.GONE);
            veterinary.setVisibility(View.GONE);
            getSupportActionBar().setTitle("Veterinary Doctor List");
        });
    }
}
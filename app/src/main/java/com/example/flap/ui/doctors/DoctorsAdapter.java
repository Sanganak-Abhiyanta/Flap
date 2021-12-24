package com.example.flap.ui.doctors;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flap.R;
import com.google.android.material.button.MaterialButton;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DoctorsAdapter extends RecyclerView.Adapter<DoctorsAdapter.DoctorsViewAdapter> {

    private List<DoctorsData> list;
    private Context context;
    private String category;

    public DoctorsAdapter(List<DoctorsData> list, Context context, String category) {
        this.list = list;
        this.context = context;
        this.category = category;
    }

    @NonNull
    @Override
    public DoctorsViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.doctors_item_layout, parent, false);

        return new DoctorsViewAdapter(view);

    }

    @Override
    public void onBindViewHolder(@NonNull DoctorsViewAdapter holder, int position) {
        DoctorsData data = list.get(position);
        holder.name.setText(data.getDoctorName());
        holder.experience.setText(data.getDoctorExperience());
        holder.address.setText(data.getDoctorAddress());
        holder.rating.setText(data.getDoctorRating());
        holder.timing.setText(data.getDoctorTiming());
        holder.feeBtn.setText("Fee: " + data.getDoctorConsultationFee());
        holder.bookAppointment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class DoctorsViewAdapter extends RecyclerView.ViewHolder {
        private CircleImageView imageView;
        private TextView name, experience, address, rating, timing;
        private MaterialButton feeBtn, bookAppointment;

        public DoctorsViewAdapter(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.doctorImage);
            name = itemView.findViewById(R.id.doctorName);
            experience = itemView.findViewById(R.id.doctorExperience);
            address = itemView.findViewById(R.id.doctorAddress);
            rating = itemView.findViewById(R.id.doctorRating);
            timing = itemView.findViewById(R.id.doctorsTiming);
            feeBtn = itemView.findViewById(R.id.doctorsFee);
            bookAppointment = itemView.findViewById(R.id.bookAppointment);
        }
    }
}

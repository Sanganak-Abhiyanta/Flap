package com.example.flap.ui.Medicine_and_Essentials;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.flap.R;
import com.google.android.material.button.MaterialButton;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MedicineAdapter extends RecyclerView.Adapter<MedicineAdapter.MedicineViewAdapter> {
    private List<MedicineData> list;
    private Context context;
    private String category;

    public MedicineAdapter(List<MedicineData> list, Context context, String category) {
        this.list = list;
        this.context = context;
        this.category = category;
    }

    @NonNull
    @Override
    public MedicineViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.medicine_item_layout, parent, false);

        return new MedicineViewAdapter(view);


    }

    @Override
    public void onBindViewHolder(@NonNull MedicineViewAdapter holder, int position) {
        MedicineData data = list.get(position);

        holder.name.setText(data.getMedicineName());
        holder.price.setText(data.getMedicinePrice());
        holder.addToCart.setOnClickListener(v -> Toast.makeText(context, "Add to Cart Clicked", Toast.LENGTH_SHORT).show());

        if (data.getMedicineImage().isEmpty()) {
            Picasso.get().load(R.drawable.ic_medicine).into(holder.imageView);
        } else {
            Picasso.get().load(data.getMedicineImage()).into(holder.imageView);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MedicineViewAdapter extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView name, price;
        private MaterialButton addToCart;


        public MedicineViewAdapter(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.medicineImg);
            name = itemView.findViewById(R.id.medicineName);
            price = itemView.findViewById(R.id.medicinePrice);
            addToCart = itemView.findViewById(R.id.addToCart);
        }
    }
}

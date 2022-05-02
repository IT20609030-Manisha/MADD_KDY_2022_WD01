package com.example.navidrawer.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navidrawer.R;

import java.util.ArrayList;

public class VacancyAdapter extends RecyclerView.Adapter<VacancyAdapter.VacancyViewHolder> {

    Context context;

    ArrayList<Vacancy> list;

    public VacancyAdapter(Context context, ArrayList<Vacancy> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public VacancyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.vacancy,parent,false);
        return new VacancyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull VacancyViewHolder holder, int position) {
        Vacancy vacancy = list.get(position);
        holder.Location.setText(vacancy.getLocation());
        holder.VehicleType.setText(vacancy.getVehicleType());
       // holder.Availability.setText(vacancy.getAvailability());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class VacancyViewHolder extends RecyclerView.ViewHolder{

        TextView VacancyType, Location, VehicleType, Availability;

        public VacancyViewHolder(@NonNull View itemView) {
            super(itemView);

            VacancyType = itemView.findViewById(R.id.tvVacancyType);
            Location = itemView.findViewById(R.id.tvlocation);
            VehicleType = itemView.findViewById(R.id.tvVehicleType);
            //Availability = itemView.findViewById(R.id.tvAvailability);
        }
    }
}

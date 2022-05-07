package com.example.navidrawer.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navidrawer.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class VacancyAdapterUser extends FirebaseRecyclerAdapter<Vacancy,VacancyAdapterUser.ViewHolder2> {

    private Context context;

    public VacancyAdapterUser(@NonNull FirebaseRecyclerOptions<Vacancy> options, Context context) {
        super(options);

        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder2 holder, int position, @NonNull Vacancy model) {
        holder.Location.setText(model.getLocation());
        holder.VehicleType.setText(model.getVehicleType());
    }

    @NonNull
    @Override
    public ViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vacancy_user,parent,false);

        return new ViewHolder2(view);
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView Location, VehicleType;

        public ViewHolder2(@NonNull View itemView) {
            super(itemView);

            Location = itemView.findViewById(R.id.tvlocation);
            VehicleType = itemView.findViewById(R.id.tvVehicleType);
        }
    }
}

package com.example.navidrawer.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navidrawer.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;

import java.util.HashMap;
import java.util.Map;

public class VacancyAdapter extends FirebaseRecyclerAdapter<Vacancy,VacancyAdapter.ViewHolder> {

    private Context context;
    public VacancyAdapter(@NonNull FirebaseRecyclerOptions<Vacancy> options, Context context) {
        super(options);

        this.context = context;
    }

    @Override
    public void onBindViewHolder(@NonNull VacancyAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position, @NonNull Vacancy model) {
        holder.Location.setText(model.getLocation());
        holder.VehicleType.setText(model.getVehicleType());

        //delete -- Vacancy
        holder.btndeletev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseDatabase.getInstance().getReference().child("Vacancy")
                        .child(getRef(position).getKey())
                        .removeValue()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(context, "Deleted Successfully", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

        //update -- vacancy
        holder.btnUpdatev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DialogPlus dialog = DialogPlus.newDialog(context)
                        .setGravity(Gravity.CENTER)
                        .setMargin(50, 0, 50, 0)
                        .setContentHolder(new com.orhanobut.dialogplus.ViewHolder(R.layout.content))
                        .setExpanded(false)  // This will enable the expand feature, (similar to android L share dialog)
                        .create();

                View holderView = dialog.getHolderView();

                EditText loc = holderView.findViewById(R.id.update_vacancy_location);
                EditText vehicle = holderView.findViewById(R.id.update_vacancy_vehicle);

                Button btnUpdate = holderView.findViewById(R.id.update_btn_Vacancy);

                loc.setText(model.getLocation());
                vehicle.setText(model.getVehicleType());

                btnUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Map<String, Object> map = new HashMap<>();
                        map.put("location", loc.getText().toString());
                        map.put("vehicleType", vehicle.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("Vacancy")
                                .child(getRef(position).getKey())
                                .updateChildren(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                dialog.dismiss();
                                Toast.makeText(context, "Updated Successfully..", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }

                });
                dialog.show();
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.vacancy,parent,false);

        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView Location, VehicleType;
        Button btnUpdatev, btndeletev;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

          //  VacancyType = itemView.findViewById(R.id.tvVacancyType);
            Location = itemView.findViewById(R.id.tvlocation);
            VehicleType = itemView.findViewById(R.id.tvVehicleType);

            btnUpdatev = itemView.findViewById(R.id.update_btn_Vacancy);
            btndeletev = itemView.findViewById(R.id.delete_btn_Vacancy);
        }
    }
/*
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

 */
}

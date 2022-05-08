package com.example.navidrawer.model;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

import java.util.ArrayList;

public class NeederAdapter extends FirebaseRecyclerAdapter<Needer,NeederAdapter.ViewHolder3> {

    private Context context;
    public NeederAdapter(FirebaseRecyclerOptions<Needer> options) {
        super(options);

        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder3 holder, @SuppressLint("RecyclerView") int position, @NonNull Needer model) {
        holder.registrationNumber.setText(model.getRegistrationNumber());
        holder.organizationName.setText(model.getOrganizationName());
        holder.email.setText(model.getEmail());
        holder.contactNumber.setText(model.getContactNumber());
        holder.address.setText(model.getAddress());

        //delete -- needer
        holder.btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                FirebaseDatabase.getInstance().getReference().child("Needer")
                        .child(getRef(position).getKey())
                        .removeValue()
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(context, "Removed Successfully", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });
    }

    @NonNull
    @Override
    public ViewHolder3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.needer,parent,false);

        return new ViewHolder3(view);
    }

    public class ViewHolder3 extends RecyclerView.ViewHolder {

        TextView registrationNumber, organizationName, email, contactNumber, address;
        Button btnAccept;

        public ViewHolder3(@NonNull View itemView) {
            super(itemView);

            registrationNumber = itemView.findViewById(R.id.tvNOregnum);
            organizationName = itemView.findViewById(R.id.tvNOrgName);
            email = itemView.findViewById(R.id.tvNOemail);
            contactNumber = itemView.findViewById(R.id.tvNOtelNum);
            address = itemView.findViewById(R.id.tvNOaddress);

            btnAccept = itemView.findViewById(R.id.btnDecline);
        }
    }

    /*

    private Context context;
    private ArrayList<Needer> neederList;
    private int lastPos = -1;
    private VacancyClickInterface vacancyClickInterface;
    private Button btnAccept;

    public NeederAdapter(ArrayList<Needer> neederList, Context context, VacancyClickInterface vacancyClickInterface) {
        this.context = context;
        this.neederList = neederList;
        this.vacancyClickInterface = vacancyClickInterface;
    }

    public NeederAdapter(Context context, ArrayList<Needer> neederList) {
        this.context = context;
        this.neederList = neederList;
    }


    @NonNull
    @Override
    public NeederAdapter.NeederViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.needer,parent,false);
        return new NeederAdapter.NeederViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NeederViewHolder holder, int position) {
        Needer needer = neederList.get(position);
        holder.registrationNumber.setText(needer.getRegistrationNumber());
        holder.organizationName.setText(needer.getOrganizationName());
        holder.email.setText(needer.getEmail());
        //holder.contactNumber.setText(needer.getContactNumber());
        holder.address.setText(needer.getAddress());
        holder.Emername.setText(needer.getName());
        holder.Emerdes.setText(needer.getDesignation());
        //holder.EmerContact.setText(needer.getEmergencyContactNumber());

    }

    @Override
    public int getItemCount() {
        return neederList.size();
    }

    public interface VacancyClickInterface{
        static void onVacancyClick(int position) {

        }
    }

    public class NeederViewHolder extends RecyclerView.ViewHolder {

        private TextView registrationNumber, organizationName, email, contactNumber, address, Emername, Emerdes, EmerContact, Emerpass;

        public NeederViewHolder(@NonNull View itemView) {
            super(itemView);

            registrationNumber = itemView.findViewById(R.id.tvNOregnum);
            organizationName = itemView.findViewById(R.id.tvNOrgName);
            email = itemView.findViewById(R.id.tvNOemail);
            contactNumber = itemView.findViewById(R.id.tvNOtelNum);
            address = itemView.findViewById(R.id.tvNOaddress);
            Emername = itemView.findViewById(R.id.tvEmerName);
            Emerdes = itemView.findViewById(R.id.tvEmerdes);
            EmerContact = itemView.findViewById(R.id.tvEmerConnum);
            Emerpass = itemView.findViewById(R.id.tvEmerPassword);

            btnAccept = itemView.findViewById(R.id.btnAccept);
        }
    }

     */


}

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

public class NeederAdapter extends RecyclerView.Adapter<NeederAdapter.NeederViewHolder> {

    Context context;

    ArrayList<Needer> list;

    public NeederAdapter(Context context, ArrayList<Needer> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public NeederAdapter.NeederViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.needer,parent,false);
        return new NeederAdapter.NeederViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NeederAdapter.NeederViewHolder holder, int position) {
        Needer needer = list.get(position);
        holder.registrationNumber.setText(needer.getRegistrationNumber());
        holder.organizationName.setText(needer.getOrganizationName());
        holder.email.setText(needer.getEmail());
        //holder.contactNumber.setText(needer.getContactNumber());
        holder.address.setText(needer.getAddress());
        holder.Emername.setText(needer.getName());
        holder.Emerdes.setText(needer.getDesignation());
        //holder.EmerContact.setText(needer.getEmergencyContactNumber());
        holder.Emerpass.setText(needer.getPassword());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NeederViewHolder extends RecyclerView.ViewHolder {

        TextView registrationNumber, organizationName, email, contactNumber, address, Emername, Emerdes, EmerContact, Emerpass;

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
        }
    }
}

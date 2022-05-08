package com.example.navidrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navidrawer.model.Driver;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class AssignDriAdapter extends FirebaseRecyclerAdapter<Driver,AssignDriAdapter.myViewHolder2> {

   Context context;
    public AssignDriAdapter(@NonNull FirebaseRecyclerOptions<Driver> options,Context context) {
        super(options);
        this.context=context;
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder2 holder, int position, @NonNull Driver model) {

        holder.FirstName.setText(model.getFirstname());
        holder.LastName.setText(model.getLastname());
        holder.ConNu.setText(model.getContactNumber());
        holder.vehiType.setText(model.getVehicleType());
        holder.vehiNo.setText(model.getVahicleRegNo());
        holder.address.setText(model.getAddress());
        holder.email.setText(model.getEmail());
        holder.vClr.setText(model.getVehicleColour());
    }

    @NonNull
    @Override
    public myViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.assigndriver_item,parent,false);
        return new myViewHolder2(view);
    }

    public class myViewHolder2 extends RecyclerView.ViewHolder {

        TextView FirstName,LastName,ConNu,address,email,vehiType,vehiNo,vClr;

        public myViewHolder2(@NonNull View itemView) {
            super(itemView);
            FirstName = itemView.findViewById(R.id.txtFName);
            LastName = itemView.findViewById(R.id.txtlName);
            ConNu = itemView.findViewById(R.id.txtConNu);
            vehiType = itemView.findViewById(R.id.txtVehiType);
            vehiNo = itemView.findViewById(R.id.txtVehiNo);
            address = itemView.findViewById(R.id.txtDaddress);
            email = itemView.findViewById(R.id.txtEMail);
            vClr = itemView.findViewById(R.id.txtvClr);
        }
    }
}


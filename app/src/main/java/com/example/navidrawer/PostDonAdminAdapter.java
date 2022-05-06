package com.example.navidrawer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navidrawer.model.DonationModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;
import com.orhanobut.dialogplus.DialogPlus;
import com.squareup.picasso.Picasso;

import java.util.HashMap;
import java.util.Map;

public class PostDonAdminAdapter extends FirebaseRecyclerAdapter<DonationModel,PostDonAdminAdapter.ViewHolder> {

    private Context context;
    public PostDonAdminAdapter(@NonNull FirebaseRecyclerOptions<DonationModel> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position, @NonNull DonationModel model) {
        holder.tvdonName.setText("Donor's Name : " +model.getDonorName());
        holder.tvdonLocation.setText("Donor's Location : " +model.getDonorLocation());
        holder.tvfoodTitle.setText("Food Title : " +model.getFoodTitle());
        holder.tvfoodCat.setText("Food Category : " +model.getCategory());
        holder.tvfoodQty.setText("Food Quantity : " +model.getQuantity());
        holder.tvexpDate.setText("Expiry Date : " +model.getExpDate());
        holder.tvnote.setText("Special Note : " +model.getSpecialNote());
        holder.tvstatus.setText("Donation Status : " +model.getStatus());

        String imageUri = model.getImage();
        //get image from firebase
        Picasso.get().load(imageUri).into(holder.imageAdd);

        holder.donationUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DialogPlus dialog= DialogPlus.newDialog(context)
                        .setGravity(Gravity.CENTER)
                        .setMargin(50,0,50,0)
                        .setContentHolder(new com.orhanobut.dialogplus.ViewHolder(R.layout.contentdon))
                        .setExpanded(false)
                        .create();

                View holderView=dialog.getHolderView();

                EditText upDonorName = holderView.findViewById(R.id.updateDonorName);
                EditText upDonorLocation = holderView.findViewById(R.id.updateDonorLocation);
                EditText upFoodTitle = holderView.findViewById(R.id.updateFoodTitle);
                EditText upCategory = holderView.findViewById(R.id.updateFoodCat);
                EditText upQuantity = holderView.findViewById(R.id.updateFoodQty);
                EditText upExpDate = holderView.findViewById(R.id.updateExpDate);
                EditText upNote = holderView.findViewById(R.id.updateNote);
                EditText upStatus = holderView.findViewById(R.id.updateDonStatus);
                Button btnDonationUpdate = holderView.findViewById(R.id.btn_DonationUpdate);

                //set text to update dialog box
                upDonorName.setText(model.getDonorName());
                upDonorLocation.setText(model.getDonorLocation());
                upFoodTitle.setText(model.getFoodTitle());
                upCategory.setText(model.getCategory());
                upQuantity.setText(model.getQuantity());
                upExpDate.setText(model.getExpDate());
                upNote.setText(model.getSpecialNote());
                upStatus.setText(model.getStatus());

                //update donation
                btnDonationUpdate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Map<String,Object> map = new HashMap<>();
                        map.put("DonorName", upDonorName.getText().toString());
                        map.put("DonorLocation", upDonorLocation.getText().toString());
                        map.put("FoodTitle", upFoodTitle.getText().toString());
                        map.put("Category", upCategory.getText().toString());
                        map.put("Quantity", upQuantity.getText().toString());
                        map.put("ExpDate", upExpDate.getText().toString());
                        map.put("SpecialNote", upNote.getText().toString());
                        map.put("Status", upStatus.getText().toString());

                        FirebaseDatabase.getInstance().getReference().child("Donation")
                                .child(getRef(position).getKey())
                                .updateChildren(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                dialog.dismiss();
                                Toast.makeText(context, "Updated Successfully", Toast.LENGTH_SHORT).show();
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
                .inflate(R.layout.design_row_for_donadrecyclerview,parent,false);

        return new ViewHolder(view);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvdonName, tvdonLocation, tvfoodTitle,tvfoodCat, tvfoodQty, tvexpDate, tvnote, tvstatus;
        ImageView imageAdd, donationUpdate;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvdonName = itemView.findViewById(R.id.tv_donorNameRetrive);
            tvdonLocation = itemView.findViewById(R.id.tv_donorLocationRetrive);
            tvfoodTitle = itemView.findViewById(R.id.tv_foodTitleRetrive);
            tvfoodCat = itemView.findViewById(R.id.tv_foodCatRetrive);
            tvfoodQty = itemView.findViewById(R.id.tv_foodQtyRetrive);
            tvexpDate = itemView.findViewById(R.id.tv_foodExpDateRetrive);
            tvnote = itemView.findViewById(R.id.tv_foodNoteRetrive);
            tvstatus = itemView.findViewById(R.id.tv_foodStatusRetrive);
            imageAdd = itemView.findViewById(R.id.image_ViewDonation);
            donationUpdate = itemView.findViewById(R.id.image_DonEdit);

        }
    }
}

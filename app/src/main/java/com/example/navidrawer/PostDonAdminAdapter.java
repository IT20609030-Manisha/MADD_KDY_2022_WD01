package com.example.navidrawer;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navidrawer.model.DonationModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

public class PostDonAdminAdapter extends FirebaseRecyclerAdapter<DonationModel,PostDonAdminAdapter.ViewHolder> {

    public PostDonAdminAdapter(@NonNull FirebaseRecyclerOptions<DonationModel> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull DonationModel model) {
        holder.tvdonName.setText("Donor's Name : "+model.getDonorName());
        holder.tvdonLocation.setText("Donor's Location : "+model.getDonorLocation());
        holder.tvfoodTitle.setText("Food Title : "+model.getFoodTitle());
        holder.tvfoodCat.setText("Food Category : "+model.getCategory());
        holder.tvfoodQty.setText("Food Quantity : "+model.getQuantity());
        holder.tvexpDate.setText("Expiry Date : "+model.getExpDate());
        holder.tvnote.setText("Special Note : "+model.getSpecialNote());
        holder.tvstatus.setText("Donation Status : "+model.getStatus());

        String imageUri = model.getImage();
        //get image from firebase
        Picasso.get().load(imageUri).into(holder.imageAdd);

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
        ImageView imageAdd;
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

        }
    }
}

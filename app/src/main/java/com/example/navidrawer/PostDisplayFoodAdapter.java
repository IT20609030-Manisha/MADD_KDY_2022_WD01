package com.example.navidrawer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navidrawer.model.DonationModel;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.squareup.picasso.Picasso;

public class PostDisplayFoodAdapter extends FirebaseRecyclerAdapter<DonationModel,PostDisplayFoodAdapter.ViewHolder2> {

    private Context context;

    public PostDisplayFoodAdapter(@NonNull FirebaseRecyclerOptions<DonationModel> options, Context context) {
        super(options);
        this.context = context;
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder2 holder, int position, @NonNull DonationModel model) {
        holder.tv_displayDonName.setText(model.getDonorName());
        holder.tv_displayDonLocation.setText(model.getDonorLocation());
        holder.tv_displayFoodTitle.setText(model.getFoodTitle());
        holder.tv_displayCat.setText(model.getCategory());
        holder.tv_displayQty.setText(model.getQuantity());
        holder.tv_displayExpDate.setText(model.getExpDate());
        holder.tv_displayStatus.setText(model.getStatus());

        String imageUri = model.getImage();
        //get image from firebase
        Picasso.get().load(imageUri).into(holder.showDonation);

        String st = model.getStatus();

        holder.btn_OrderFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (st.equals("Pending")){
                    Toast.makeText(context, "Sorry,Can't Order... Donation Still Pending...", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(context, "Placing Order.....", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @NonNull
    @Override
    public ViewHolder2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.design_row_for_fooddis_recyclerview,parent,false);

        return new ViewHolder2(view);
    }

    public class ViewHolder2 extends RecyclerView.ViewHolder {
        TextView tv_displayDonName, tv_displayDonLocation, tv_displayFoodTitle, tv_displayCat, tv_displayQty, tv_displayExpDate, tv_displayStatus;
        ImageView showDonation;
        Button btn_OrderFood;
        public ViewHolder2(@NonNull View itemView) {
            super(itemView);

            tv_displayDonName = itemView.findViewById(R.id.tv_donorNameDisplay);
            tv_displayDonLocation = itemView.findViewById(R.id.tv_donorLocationDisplay);
            tv_displayFoodTitle = itemView.findViewById(R.id.tv_foodTitleDisplay);
            tv_displayCat = itemView.findViewById(R.id.tv_foodCatDisplay);
            tv_displayQty = itemView.findViewById(R.id.tv_foodQtyDisplay);
            tv_displayExpDate = itemView.findViewById(R.id.tv_foodExpDateDisplay);
            tv_displayStatus = itemView.findViewById(R.id.tv_foodStatusDisplay);

            showDonation = itemView.findViewById(R.id.image_DisplayDonation);
            btn_OrderFood = itemView.findViewById(R.id.btnOrderFood);
        }
    }
}

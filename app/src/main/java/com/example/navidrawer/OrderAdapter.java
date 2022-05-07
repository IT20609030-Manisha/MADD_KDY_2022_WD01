package com.example.navidrawer;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navidrawer.model.Orders;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;

public class OrderAdapter extends FirebaseRecyclerAdapter<Orders,OrderAdapter.myViewHolder> {
    /**
     * Initialize a {@link RecyclerView.Adapter} that listens to a Firebase query. See
     * {@link FirebaseRecyclerOptions} for configuration options.
     *
     * @param options
     */
    public OrderAdapter(@NonNull FirebaseRecyclerOptions<Orders> options) {
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull myViewHolder holder, int position, @NonNull Orders orders) {
        holder.category.setText(orders.getCategory());
        holder.foodTitle.setText(orders.getFoodTitle());
        holder.portion.setText(orders.getPortion());
        holder.Nname.setText(orders.getNeederName());
        holder.address.setText(orders.getAddress());


        holder.btnAssignDriver.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), AssignDriver.class);
            v.getContext().startActivity(intent);
        });

    }

    @NonNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.orders_item,parent,false);
        return new myViewHolder(view);
    }

    class myViewHolder extends RecyclerView.ViewHolder {

        TextView category, foodTitle, portion, Nname, address;

        Button btnAssignDriver;


        public myViewHolder(@NonNull View itemView) {
            super(itemView);

            category = (TextView) itemView.findViewById(R.id.txtCategory);
            foodTitle = (TextView) itemView.findViewById(R.id.txtFood);
            portion = (TextView) itemView.findViewById(R.id.txtPortion);
            Nname = (TextView) itemView.findViewById(R.id.txtNname);
            address = (TextView) itemView.findViewById(R.id.txtAddress);

            btnAssignDriver = (Button) itemView.findViewById(R.id.btnAssignDriver);

        }
    }
}

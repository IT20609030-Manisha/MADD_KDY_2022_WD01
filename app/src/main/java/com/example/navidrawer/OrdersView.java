package com.example.navidrawer;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navidrawer.model.Orders;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class OrdersView extends AppCompatActivity {

    RecyclerView recyclerView2;
    OrderAdapter orderAdapter;

    Button btnAssignDriver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orders_view);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Orders");

        recyclerView2 = (RecyclerView) findViewById(R.id.rv2);
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Orders> options =
                new FirebaseRecyclerOptions.Builder<Orders>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Order"), Orders.class)
                        .build();

        orderAdapter = new OrderAdapter(options,this);
        recyclerView2.setAdapter(orderAdapter);

        /*btnAssignDriver = findViewById(R.id.btnAssignDriver);
        btnAssignDriver.setOnClickListener(view -> {
            Intent i = new Intent(OrdersView.this, AssignDriver.class);
            startActivity(i);
        });*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        orderAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        orderAdapter.stopListening();
    }
}
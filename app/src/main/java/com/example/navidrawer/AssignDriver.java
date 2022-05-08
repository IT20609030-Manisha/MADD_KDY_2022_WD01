package com.example.navidrawer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navidrawer.model.Driver;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class AssignDriver extends AppCompatActivity {

    RecyclerView recyclerView3;
    AssignDriAdapter assignDriAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_assign_driver);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Assign Driver");

        recyclerView3 = (RecyclerView) findViewById(R.id.rv3);
        recyclerView3.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Driver> options =
                new FirebaseRecyclerOptions.Builder<Driver>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Driver"), Driver.class)
                        .build();

        assignDriAdapter = new AssignDriAdapter(options,this);
        recyclerView3.setAdapter(assignDriAdapter);

       /* btnAssignDriver = findViewById(R.id.btnAssignDriver);
        btnAssignDriver.setOnClickListener(view -> {
            Intent i = new Intent(OrdersView.this, AssignDriver.class);
            startActivity(i);
        });*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        assignDriAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        assignDriAdapter.stopListening();
    }

}
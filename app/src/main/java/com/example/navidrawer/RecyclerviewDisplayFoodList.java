package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.navidrawer.model.DonationModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class RecyclerviewDisplayFoodList extends AppCompatActivity {
    RecyclerView recyclerViewFoodDisplay;
    PostDisplayFoodAdapter adapterFoodDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_display_food_list);

        this.setTitle("Find Food");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerViewFoodDisplay = findViewById(R.id.recyclerViewFood_id);
        recyclerViewFoodDisplay.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<DonationModel> options=
                new FirebaseRecyclerOptions.Builder<DonationModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Donation"),DonationModel.class)
                        .build();

        adapterFoodDisplay = new PostDisplayFoodAdapter(options,this);
        recyclerViewFoodDisplay.setAdapter(adapterFoodDisplay);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapterFoodDisplay.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapterFoodDisplay.stopListening();
    }
}
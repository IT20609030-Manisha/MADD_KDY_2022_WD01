package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.navidrawer.model.DonationModel;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class RecyclerviewDonAdList extends AppCompatActivity {
    RecyclerView recyclerView;
    PostDonAdminAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_don_ad_list);

        recyclerView = findViewById(R.id.recylclerViewdonad_id);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<DonationModel> options=
                new FirebaseRecyclerOptions.Builder<DonationModel>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Donation"),DonationModel.class)
                        .build();

        adapter = new PostDonAdminAdapter(options);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }
}
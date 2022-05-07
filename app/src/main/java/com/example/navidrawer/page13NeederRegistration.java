package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.navidrawer.model.Needer;
import com.example.navidrawer.model.NeederAdapter;
import com.example.navidrawer.model.Post;
import com.example.navidrawer.model.PostAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class page13NeederRegistration extends AppCompatActivity {

    RecyclerView recyclerView;
    NeederAdapter neederAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page13_needer_registration);

        this.setTitle("Accept needer registration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.idNeederListView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Needer> options=
                new FirebaseRecyclerOptions.Builder<Needer>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Needer"), Needer.class)
                        .build();

        //    postlist = new ArrayList<Post>();
        neederAdapter = new NeederAdapter(options);
        recyclerView.setAdapter(neederAdapter);
    }

    protected void onStart() {
        super.onStart();
        neederAdapter.startListening();
    }

    protected void onStop() {
        super.onStop();
        neederAdapter.stopListening();
    }
}
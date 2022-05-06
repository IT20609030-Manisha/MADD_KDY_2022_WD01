package com.example.navidrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.navidrawer.model.Vacancy;
import com.example.navidrawer.model.VacancyAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Page10AllVacancies extends AppCompatActivity {

    RecyclerView recyclerView;
    VacancyAdapter vacancyAdapter;
    FloatingActionButton addFAB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page10_all_vacancies);

        this.setTitle("Vacancies");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addFAB = findViewById(R.id.idFABAddVacancy);

        addFAB.setOnClickListener(view -> {
            Intent intent = new Intent(Page10AllVacancies.this,Page9AddVacancies.class);
            startActivity(intent);
        });

        recyclerView = findViewById(R.id.vacancyList);
        //database = FirebaseDatabase.getInstance().getReference("Vacancy");
        //recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Vacancy> options=
                new FirebaseRecyclerOptions.Builder<Vacancy>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Vacancy"),Vacancy.class)
                        .build();

        //list = new ArrayList<>();
        vacancyAdapter = new VacancyAdapter(options,this);
        recyclerView.setAdapter(vacancyAdapter);

    }

    protected void onStart() {
        super.onStart();
        vacancyAdapter.startListening();
    }

    protected void onStop() {
        super.onStop();
        vacancyAdapter.startListening();
    }
}
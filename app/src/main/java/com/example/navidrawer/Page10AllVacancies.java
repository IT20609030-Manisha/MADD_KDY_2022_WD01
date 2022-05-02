package com.example.navidrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.navidrawer.model.Vacancy;
import com.example.navidrawer.model.VacancyAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Page10AllVacancies extends AppCompatActivity {

    RecyclerView recyclerView;
    DatabaseReference database;
    VacancyAdapter vacancyAdapter;
    ArrayList<Vacancy> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page10_all_vacancies);

        recyclerView = findViewById(R.id.vacancyList);
        database = FirebaseDatabase.getInstance().getReference("Vacancy");
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        vacancyAdapter = new VacancyAdapter(this,list);
        recyclerView.setAdapter(vacancyAdapter);

        database.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot dataSnapshot : snapshot.getChildren()){
                    Vacancy vacancy = dataSnapshot.getValue(Vacancy.class);
                    list.add(vacancy);
                }
                vacancyAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
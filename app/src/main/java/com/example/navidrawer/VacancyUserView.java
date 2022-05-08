package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.navidrawer.model.Vacancy;
import com.example.navidrawer.model.VacancyAdapter;
import com.example.navidrawer.model.VacancyAdapterUser;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class VacancyUserView extends AppCompatActivity {

    RecyclerView recyclerViewu;
    VacancyAdapterUser vacancyAdapterUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacancy_user_view);

        this.setTitle("Vacancies");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerViewu = findViewById(R.id.vacancyViewUser);
        //database = FirebaseDatabase.getInstance().getReference("Vacancy");
        //recyclerView.setHasFixedSize(true);
        recyclerViewu.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Vacancy> options=
                new FirebaseRecyclerOptions.Builder<Vacancy>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Vacancy"),Vacancy.class)
                        .build();

        //list = new ArrayList<>();
        vacancyAdapterUser = new VacancyAdapterUser(options,this);
        recyclerViewu.setAdapter(vacancyAdapterUser);
    }

    protected void onStart() {
        super.onStart();
        vacancyAdapterUser.startListening();
    }

    protected void onStop() {
        super.onStop();
        vacancyAdapterUser.startListening();
    }
}
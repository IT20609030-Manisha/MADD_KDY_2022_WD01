package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Page6RegistrationNeeder extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page6_registration_needer);

        this.setTitle("Needer Registration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Page4RegistrationDriver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4_registration_driver);

        this.setTitle("Driver Registration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Page5RegistrationDonor extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page5_registration_donor);

        this.setTitle("Donor Registration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
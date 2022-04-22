package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class regDonorPage4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_donor_page4);

        this.setTitle("Donor Registration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
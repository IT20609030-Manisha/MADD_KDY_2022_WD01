package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class regDriverPage6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_driver_page6);

        this.setTitle("Driver Registration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
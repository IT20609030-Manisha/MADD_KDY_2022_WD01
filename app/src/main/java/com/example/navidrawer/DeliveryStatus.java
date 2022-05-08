package com.example.navidrawer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class DeliveryStatus extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery_status);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Delivery Status");
    }
}
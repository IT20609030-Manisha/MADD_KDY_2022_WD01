package com.example.navidrawer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateDeliveryNotifications extends AppCompatActivity {

    Button btnPickup, btnDeli;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delivery_notifications);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Update Delivery Status");

        btnPickup = findViewById(R.id.btnPickup);
        btnDeli = findViewById(R.id.btnDeli);


        btnPickup.setOnClickListener(view -> {
            Intent i = new Intent(UpdateDeliveryNotifications.this, DeliveryStatus.class);
            startActivity(i);
        });

        btnDeli.setOnClickListener(view -> {
            Intent i = new Intent(UpdateDeliveryNotifications.this, Delivered.class);
            startActivity(i);
        });
    }
}
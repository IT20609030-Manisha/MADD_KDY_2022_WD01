package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Delivered extends AppCompatActivity {

    Button btnFeedback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivered);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Delivery Status");

        btnFeedback = findViewById(R.id.btnFeedback);

        btnFeedback.setOnClickListener(view -> {
            Intent i = new Intent(Delivered.this, Feedback.class);
            startActivity(i);
        });
    }
}
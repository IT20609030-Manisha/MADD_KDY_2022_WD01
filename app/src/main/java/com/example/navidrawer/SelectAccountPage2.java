package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class SelectAccountPage2 extends AppCompatActivity {

    Button btnDonor;
    Button btnNeeder;
    Button btnDriver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_account_page2);

        this.setTitle("Create Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnDonor = findViewById(R.id.btnDonor);
        btnNeeder = findViewById(R.id.btnNeeder);
        btnDriver = findViewById(R.id.btnDriver);

        btnDonor.setOnClickListener(view -> {
            Intent intent = new Intent(SelectAccountPage2.this,regDonorPage4.class);
            startActivity(intent);
        });

        btnNeeder.setOnClickListener(view -> {
            Intent intent = new Intent(SelectAccountPage2.this,regNeederPage5.class);
            startActivity(intent);
        });

        btnDriver.setOnClickListener(view -> {
            Intent intent = new Intent(SelectAccountPage2.this,regDriverPage6.class);
            startActivity(intent);
        });
    }
}
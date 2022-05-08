package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Page2SelectAccount extends AppCompatActivity {

    Button btnDonor;
    Button btnNeeder;
    Button btnDriver;
    Button btnSkip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2_select_account);

        this.setTitle("Create Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnDonor = findViewById(R.id.btnDonor);
        btnNeeder = findViewById(R.id.btnNeeder);
        btnDriver = findViewById(R.id.btnDriver);
        btnSkip = findViewById(R.id.btnSkip);

        btnDonor.setOnClickListener(view -> {
            Intent intent = new Intent(Page2SelectAccount.this,Page5RegistrationDonor.class);
            startActivity(intent);
        });

        /*
        btnNeeder.setOnClickListener(view -> {
            Intent intent = new Intent(Page2SelectAccount.this,Page6RegistrationNeeder.class);
            startActivity(intent);
        });

         */

        btnNeeder.setOnClickListener(view -> {
            Intent intent = new Intent(Page2SelectAccount.this,Page6RegistrationNeeder.class);
            startActivity(intent);
        });

        btnDriver.setOnClickListener(view -> {
            Intent intent = new Intent(Page2SelectAccount.this,Page4RegistrationDriver.class);
            startActivity(intent);
        });

        btnSkip.setOnClickListener(view -> {
            Intent intent = new Intent(Page2SelectAccount.this,MainActivity.class);
            startActivity(intent);
        });
    }
}
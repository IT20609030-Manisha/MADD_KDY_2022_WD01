package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Page7NewPassword extends AppCompatActivity {

    Button reset2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page7_new_password);

        this.setTitle("Reset Password");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        reset2 = findViewById(R.id.btnLogIn);

        reset2.setOnClickListener(view -> {
            Intent intent = new Intent(Page7NewPassword.this,Page8NewPassword.class);
            startActivity(intent);
        });
    }
}
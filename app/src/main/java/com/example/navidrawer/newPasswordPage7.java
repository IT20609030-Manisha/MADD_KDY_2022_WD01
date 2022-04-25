package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class newPasswordPage7 extends AppCompatActivity {

    Button reset2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password_page7);

        this.setTitle("Reset Password");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        reset2 = findViewById(R.id.btnLogIn);

        reset2.setOnClickListener(view -> {
            Intent intent = new Intent(newPasswordPage7.this,newPasswordPage8.class);
            startActivity(intent);
        });
    }
}
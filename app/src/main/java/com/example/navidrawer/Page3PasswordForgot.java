package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class Page3PasswordForgot extends AppCompatActivity {

    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3_password_forgot);

        this.setTitle("Reset Password");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        reset = findViewById(R.id.btnResetPassword);

        reset.setOnClickListener(view -> {
            Intent intent = new Intent(Page3PasswordForgot.this,Page7NewPassword.class);
            startActivity(intent);
        });
    }
}
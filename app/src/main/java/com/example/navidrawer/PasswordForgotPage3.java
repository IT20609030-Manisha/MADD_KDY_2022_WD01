package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;


public class PasswordForgotPage3 extends AppCompatActivity {

    Button reset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_forgot_page3);

        this.setTitle("Reset Password");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        reset = findViewById(R.id.btnResetPassword);

        reset.setOnClickListener(view -> {
            Intent intent = new Intent(PasswordForgotPage3.this,newPasswordPage7.class);
            startActivity(intent);
        });
    }
}
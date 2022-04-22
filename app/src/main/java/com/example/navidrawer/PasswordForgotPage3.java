package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class PasswordForgotPage3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_forgot_page3);

        this.setTitle("Reset Password");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
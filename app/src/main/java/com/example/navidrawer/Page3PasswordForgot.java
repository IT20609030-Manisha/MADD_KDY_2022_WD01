package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Page3PasswordForgot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3_password_forgot);

        this.setTitle("Reset Password");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
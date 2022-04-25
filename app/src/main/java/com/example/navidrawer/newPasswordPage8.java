package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class newPasswordPage8 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_password_page8);

        this.setTitle("Reset Password");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
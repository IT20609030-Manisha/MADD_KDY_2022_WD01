package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class LoginMainPage1 extends AppCompatActivity {

    Button btnCreateAccount;
    TextView tvForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_main_page1);

        this.setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnCreateAccount = findViewById(R.id.btnCreateAccount);

        btnCreateAccount.setOnClickListener(view -> {
            Intent intent = new Intent(LoginMainPage1.this,SelectAccountPage2.class);
            startActivity(intent);
        });

        tvForgotPassword = findViewById(R.id.tvForgotPassword);

        tvForgotPassword.setOnClickListener(view -> {
            Intent intent = new Intent(LoginMainPage1.this,PasswordForgotPage3.class);
            startActivity(intent);
        });
    }
}
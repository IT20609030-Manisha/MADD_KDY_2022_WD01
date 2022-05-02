package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Page1LoginMain extends AppCompatActivity {

    Button btnCreateAccount;
    TextView tvForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1_login_main);

        this.setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnCreateAccount = findViewById(R.id.btnCreateAccount);


        btnCreateAccount.setOnClickListener(view -> {
            Intent intent = new Intent(Page1LoginMain.this,Page2SelectAccount.class);
            startActivity(intent);
        });

        tvForgotPassword = findViewById(R.id.tvForgotPassword);

        tvForgotPassword.setOnClickListener(view -> {
            Intent intent = new Intent(Page1LoginMain.this,Page3PasswordForgot.class);
            startActivity(intent);
        });
    }
}
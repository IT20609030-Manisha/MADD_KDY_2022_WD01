package com.example.navidrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Page1LoginMain extends AppCompatActivity {

    private EditText etUserEmail, etUserPassword;
    private Button btnCreateAccount, btnLogin;
    private TextView tvForgotPassword;
    private FirebaseAuth mAuth;
    //private TextView tvForgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1_login_main);

        this.setTitle("Login");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etUserEmail = findViewById(R.id.etLoginEmail);
        etUserPassword = findViewById(R.id.etLoginPasssword);
        btnLogin = findViewById(R.id.btnLogIn);
        //tvForgotPassword = findViewById(R.id.tvForgotPassword);
        mAuth = FirebaseAuth.getInstance();
        btnCreateAccount = findViewById(R.id.btnCreateAccount);

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Page1LoginMain.this,UserRegistration.class);
                startActivity(i);
            }
        });

        //Login function
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userEmail = etUserEmail.getText().toString();
                String userPassword = etUserPassword.getText().toString();
                if (TextUtils.isEmpty(userEmail) && TextUtils.isEmpty(userPassword)) {
                    Toast.makeText(Page1LoginMain.this, "Please enter your credentials..", Toast.LENGTH_SHORT).show();
                    return;
                }
                else if (userEmail.equals("admin@gmail.com") && userPassword.equals("123")){
                    Toast.makeText(Page1LoginMain.this, "Admin Login...", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(Page1LoginMain.this, AdminDashboard.class);
                    startActivity(i);
                }
                else {
                    mAuth.signInWithEmailAndPassword(userEmail, userPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                Toast.makeText(Page1LoginMain.this, "Login Successful..", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Page1LoginMain.this, MainActivity.class);
                                startActivity(i);
                                finish();
                            } else {
                                Toast.makeText(Page1LoginMain.this, "Login failed..", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
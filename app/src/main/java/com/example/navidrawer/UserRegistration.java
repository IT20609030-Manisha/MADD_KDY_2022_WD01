package com.example.navidrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class UserRegistration extends AppCompatActivity {

    private EditText username, password, confPassword;
    private Button registerbtn;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        this.setTitle("Create Account");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        username = findViewById(R.id.register_edit_username);
        password = findViewById(R.id.register_edit_password);
        confPassword = findViewById(R.id.register_edit_Confpassword);
        registerbtn = findViewById(R.id.register_btn);
        mAuth = FirebaseAuth.getInstance();

        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String UserName = username.getText().toString();
                String Password = password.getText().toString();
                String ConfPassword = confPassword.getText().toString();

                if(!Password.equals(ConfPassword)){
                    Toast.makeText(UserRegistration.this, "Passsword is not matching...", Toast.LENGTH_SHORT).show();
                }else if(TextUtils.isEmpty(UserName) && TextUtils.isEmpty(Password) && TextUtils.isEmpty(ConfPassword)){
                    Toast.makeText(UserRegistration.this, "Please add Credentials....", Toast.LENGTH_SHORT).show();
                }else{
                    mAuth.createUserWithEmailAndPassword(UserName, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                Toast.makeText(UserRegistration.this, "User Registered..", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(UserRegistration.this, Page1LoginMain.class);
                                startActivity(i);
                                finish();
                            }else{
                                Toast.makeText(UserRegistration.this, "Registration failed.....", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
}
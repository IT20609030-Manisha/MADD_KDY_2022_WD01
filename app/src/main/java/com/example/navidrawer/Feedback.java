package com.example.navidrawer;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.navidrawer.model.FeedbackCls;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Feedback extends AppCompatActivity {

    EditText etPersonName, etPersonEmail, etMessage;
    Button btnSend;
    //FirebaseDatabase mDatabase;
    DatabaseReference dbRef;
    //FirebaseStorage mStorage;
    FeedbackCls fdbck;

    //method to clear all user inputs
    private void clearControls(){
        etPersonName.setText("");
        etPersonEmail.setText("");
        etMessage.setText("");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.setTitle("Feedback");

        etPersonName = findViewById(R.id.editTextTextPersonName);
        etPersonEmail = findViewById(R.id.editTextTextEmailAddress);
        etMessage = findViewById(R.id.textInputEditText2);
        btnSend = findViewById(R.id.btnSend);

        fdbck = new FeedbackCls();

        //mDatabase = FirebaseDatabase.getInstance();
        //mRef = mDatabase.getReference().child("Feedback");
       // mStorage = FirebaseStorage.getInstance();

        btnSend.setOnClickListener(view -> {
            dbRef = FirebaseDatabase.getInstance().getReference().child("FeedbackCls");
            Intent i = new Intent(Feedback.this, FeedbackView.class);
            startActivity(i);

            try {
                if (TextUtils.isEmpty(etPersonName.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter your Name", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etPersonEmail.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter your Email", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etMessage.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please give your Feedback ", Toast.LENGTH_SHORT).show();
                else {
                    fdbck.setName(etPersonName.getText().toString().trim());
                    fdbck.setEmail(etPersonEmail.getText().toString().trim());
                    fdbck.setMessage(etMessage.getText().toString().trim());


                    //insert into the database
                    dbRef.push().setValue(fdbck);


                    //feedback to the user via toast
                    Toast.makeText(getApplicationContext(), "Feedback saved successfully", Toast.LENGTH_SHORT).show();
                    clearControls();
                }
            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_SHORT).show();
            }
        });

    }


}
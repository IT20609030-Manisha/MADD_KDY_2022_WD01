package com.example.navidrawer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.navidrawer.databinding.ActivityMainBinding;
import com.example.navidrawer.model.Driver;
import com.example.navidrawer.model.Needer;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Page6RegistrationNeeder extends AppCompatActivity {

    private EditText etRegsNo,etOrgName, etOemail, etOConNum, etOAddress, etEmName, etDes, etEmConNum;
    private Button btnSubmit;
    private DatabaseReference dbRef;
    Needer needer;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    //method to clear all user inputs
    private void clearControls(){
        etRegsNo.setText("");
        etOrgName.setText("");
        etOemail.setText("");
        etOConNum.setText("");
        etOAddress.setText("");
        etEmName.setText("");
        etDes.setText("");
        etEmConNum.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page6_registration_needer);

        this.setTitle("Needer Registration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etRegsNo = findViewById(R.id.etRegNum);
        etOrgName = findViewById(R.id.etOrgName);
        etOemail = findViewById(R.id.etemailN);
        etOConNum = findViewById(R.id.etConnumN);
        etOAddress = findViewById(R.id.etAdderessN);
        etEmName = findViewById(R.id.etNameN);
        etDes = findViewById(R.id.etDes);
        etEmConNum = findViewById(R.id.etConN);

        needer = new Needer();

        btnSubmit = findViewById(R.id.btnSubmitN);

        btnSubmit.setOnClickListener(view -> {
            dbRef = FirebaseDatabase.getInstance().getReference().child("Needer");

            try {
                if (TextUtils.isEmpty(etRegsNo.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter an Registration Number", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etOrgName.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter a Organization name", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etOemail.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter an Email", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etOConNum.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter an Contact number", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etOAddress.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter the Address", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etEmName.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter the name", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etDes.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter the Designation", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etEmConNum.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter an Contact Number", Toast.LENGTH_SHORT).show();
                else if(!validateEmergencyContactNumber() | !validateEmail() | !validateContactNumber()){
                    return;
                }
                else {
                    needer.setRegistrationNumber(etRegsNo.getText().toString().trim());
                    needer.setOrganizationName(etOrgName.getText().toString().trim());
                    needer.setEmail(etOemail.getText().toString().trim());
                    needer.setContactNumber(etOConNum.getText().toString().trim());
                    needer.setAddress(etOAddress.getText().toString().trim());
                    needer.setName(etEmName.getText().toString().trim());
                    needer.setDesignation(etDes.getText().toString().trim());
                    needer.setEmergencyContactNumber(etEmConNum.getText().toString().trim());

                    //insert into the database
                    dbRef.push().setValue(needer);
                    //dbRef.child("std1").setValue(std);

                    //feedback to the user via toast
                    Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
                    clearControls();
                }
            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private boolean validateEmail(){
        String val_email = etOemail.getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(!val_email.matches(checkEmail)){
            etOemail.setError("Invalid email!");
            return false;
        }else{
            etOemail.setError(null);
            return true;
        }
    }

    private boolean validateContactNumber(){
        String val_Connumber = etOConNum.getText().toString().trim();
        String checkConnum = "[0-9]{10}";

        if(!val_Connumber.matches(checkConnum)){
            etOConNum.setError("Invalid Contact Number!");
            return false;
        }else{
            etOConNum.setError(null);
            return true;
        }
    }

    private boolean validateEmergencyContactNumber(){
        String val_Connumber = etEmConNum.getText().toString().trim();
        String checkConnum = "[0-9]{10}";

        if(!val_Connumber.matches(checkConnum)){
            etEmConNum.setError("Invalid Contact Number!");
            return false;
        }else{
            etEmConNum.setError(null);
            return true;
        }
    }

}
package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.navidrawer.model.Needer;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Page6RegistrationNeeder extends AppCompatActivity {

    EditText etRegsNo, etOrgName, etOemail, etOConNum, etOAddress, etEmName, etDes, etEmConNum, etNpassword, etNConPassword;
    Button btnSubmit;
    DatabaseReference dbRef;
    Needer needer;

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
        etNpassword.setText("");
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
        etNpassword = findViewById(R.id.etPasswordN);

        btnSubmit = findViewById(R.id.btnSubmitN);

        needer = new Needer();

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
                else if (TextUtils.isEmpty(etNpassword.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter an Password", Toast.LENGTH_SHORT).show();
                else {
                    needer.setRegistrationNumber(etRegsNo.getText().toString().trim());
                    needer.setOrganizationName(etOrgName.getText().toString().trim());
                    needer.setEmail(etOemail.getText().toString().trim());
                    needer.setContactNumber(Integer.parseInt(etOConNum.getText().toString().trim()));
                    needer.setAddress(etOAddress.getText().toString().trim());
                    needer.setName(etEmName.getText().toString().trim());
                    needer.setDesignation(etDes.getText().toString().trim());
                    needer.setEmergencyContactNumber(Integer.parseInt(etEmConNum.getText().toString().trim()));
                    needer.setPassword(etNpassword.getText().toString().trim());

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
}
package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.navidrawer.model.Donor;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Page5RegistrationDonor extends AppCompatActivity {

    EditText etFname, etLname, etEmail, etConNum, etAddress, etPassword;
    Button btnsubmit;
    DatabaseReference dbRef;
    Donor donor;

    //method to clear all user inputs
    private void clearControls(){
        etFname.setText("");
        etLname.setText("");
        etEmail.setText("");
        etConNum.setText("");
        etAddress.setText("");
        etPassword.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page5_registration_donor);

        this.setTitle("Donor Registration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etFname = findViewById(R.id.etfnamedr);
        etLname = findViewById(R.id.etlnamedr);
        etEmail = findViewById(R.id.etemaildr);
        etConNum = findViewById(R.id.etphonenum);
        etAddress = findViewById(R.id.etAdderessdr);
        etPassword = findViewById(R.id.etPassword);

        btnsubmit = findViewById(R.id.btnSubmitD);

        donor = new Donor();

        btnsubmit.setOnClickListener(view -> {
            dbRef = FirebaseDatabase.getInstance().getReference().child("Donor");

            try {
                if (TextUtils.isEmpty(etFname.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter the first name", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etLname.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter the last name", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etEmail.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter the email address", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etConNum.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter the Contact Number", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etAddress.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter the Address", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etPassword.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter the Password", Toast.LENGTH_SHORT).show();
                else {
                    donor.setFirstName(etFname.getText().toString().trim());
                    donor.setLastName(etLname.getText().toString().trim());
                    donor.setAddress(etAddress.getText().toString().trim());
                    donor.setContactNumber(Integer.parseInt(etConNum.getText().toString().trim()));
                    donor.setAddress(etAddress.getText().toString().trim());
                    donor.setPassword(etPassword.getText().toString().trim());


                    //insert into the database
                    dbRef.push().setValue(donor);
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
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

import com.example.navidrawer.model.Donor;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Page5RegistrationDonor extends AppCompatActivity {

    private EditText etNIC, etFname, etLname, etEmail, etConNum, etAddress;
    private Button btnsubmit;
    private DatabaseReference dbRef;
    Donor donor;

    //method to clear all user inputs
    private void clearControls(){
        etNIC.setText("");
        etFname.setText("");
        etLname.setText("");
        etEmail.setText("");
        etConNum.setText("");
        etAddress.setText("");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page5_registration_donor);

        this.setTitle("Donor Registration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etNIC = findViewById(R.id.etnicdr);
        etFname = findViewById(R.id.etfnamedr);
        etLname = findViewById(R.id.etlnamedr);
        etEmail = findViewById(R.id.etemaildr);
        etConNum = findViewById(R.id.etphonenum);
        etAddress = findViewById(R.id.etAdderessdr);

        donor = new Donor();

        btnsubmit = findViewById(R.id.btnSubmitD);

        btnsubmit.setOnClickListener(view -> {
            dbRef = FirebaseDatabase.getInstance().getReference().child("Donor");

            try {
                if (TextUtils.isEmpty(etNIC.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter the NIC", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etFname.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter the first name", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etLname.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter the last name", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etEmail.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter the email address", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etConNum.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter the Contact Number", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etAddress.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter the Address", Toast.LENGTH_SHORT).show();
                else if(!validateNIC() | !validateEmail() | !validateContactNumber())
                    return;
                else {
                    donor.setNIC(etNIC.getText().toString().trim());
                    donor.setFirstName(etFname.getText().toString().trim());
                    donor.setLastName(etLname.getText().toString().trim());
                    donor.setAddress(etAddress.getText().toString().trim());
                    donor.setContactNumber(etConNum.getText().toString().trim());
                    donor.setEmail(etEmail.getText().toString().trim());

                    //insert into the database
                    dbRef.push().setValue(donor);

                    //feedback to the user via toast
                    Toast.makeText(getApplicationContext(), "Data saved successfully", Toast.LENGTH_SHORT).show();
                    clearControls();
                }
            } catch (NumberFormatException e) {
                Toast.makeText(getApplicationContext(), "Invalid Contact Number", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private boolean validateNIC(){
        String val_NIC = etNIC.getText().toString().trim();
        String checkNIC = "[0-9]{12}";

        if(!val_NIC.matches(checkNIC)){
            etNIC.setError("Invalid NIC format...");
            return false;
        }else{
            etNIC.setError(null);
            return true;
        }
    }

    private boolean validateEmail(){
        String val_email = etEmail.getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(!val_email.matches(checkEmail)){
            etEmail.setError("Invalid email!");
            return false;
        }else{
            etEmail.setError(null);
            return true;
        }
    }

    private boolean validateContactNumber(){
        String val_Connumber = etConNum.getText().toString().trim();
        String checkConnum = "[0-9]{10}";

        if(!val_Connumber.matches(checkConnum)){
            etConNum.setError("Invalid Contact Number!");
            return false;
        }else{
            etConNum.setError(null);
            return true;
        }
    }
}
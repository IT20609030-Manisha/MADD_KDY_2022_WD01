package com.example.navidrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.navidrawer.model.Driver;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Page4RegistrationDriver extends AppCompatActivity {


    private EditText etNIC,etFname, etLname, etEmail, etConNum, etAddress, etregNo, etvehCol, etVehType;
    private Button btnsubmit;
    private DatabaseReference dbRef;
    private Driver driver;


    //method to clear all user inputs
    private void clearControls(){
        etFname.setText("");
        etLname.setText("");
        etEmail.setText("");
        etConNum.setText("");
        etAddress.setText("");
        etregNo.setText("");
        etVehType.setText("");
        etvehCol.setText("");
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4_registration_driver);

        this.setTitle("Driver Registration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        etNIC = findViewById(R.id.etNICd);
        etFname = findViewById(R.id.etfnamed);
        etLname = findViewById(R.id.etlnamed);
        etEmail = findViewById(R.id.etemaild);
        etConNum = findViewById(R.id.etConnumd);
        etAddress = findViewById(R.id.etAdderessd);
        etregNo = findViewById(R.id.etVehNum);
        etvehCol = findViewById(R.id.etColour);
        etVehType = findViewById(R.id.etVehType);

        btnsubmit = findViewById(R.id.btnSubmitDr);

        driver = new Driver();

        btnsubmit.setOnClickListener(view -> {
            dbRef = FirebaseDatabase.getInstance().getReference().child("Driver");

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
                else if (TextUtils.isEmpty(etregNo.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter the registration number", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etVehType.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter the vehicle type", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etvehCol.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter the vehicle colour", Toast.LENGTH_SHORT).show();
                else if(!validateNIC() | !validateEmail() | !validateContactNumber()){
                    return;
                }
                else {
                    driver.setVehicleColour(etNIC.getText().toString().trim());
                    driver.setFirstname(etFname.getText().toString().trim());
                    driver.setLastname(etLname.getText().toString().trim());
                    driver.setEmail(etEmail.getText().toString().trim());
                    driver.setContactNumber(etConNum.getText().toString().trim());
                    driver.setAddress(etAddress.getText().toString().trim());
                    driver.setVahicleRegNo(etregNo.getText().toString().trim());
                    driver.setVehicleType(etVehType.getText().toString().trim());
                    driver.setVehicleColour(etvehCol.getText().toString().trim());



                    //insert into the database
                    dbRef.push().setValue(driver);
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
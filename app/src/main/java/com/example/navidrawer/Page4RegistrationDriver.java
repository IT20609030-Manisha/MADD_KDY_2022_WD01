package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.navidrawer.model.Driver;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Page4RegistrationDriver extends AppCompatActivity {


    EditText etFname, etLname, etEmail, etConNum, etAddress, etregNo, etvehCol, etVehType,etPassword;
    Button btnsubmit;
    DatabaseReference dbRef;
    Driver driver;

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
        etPassword.setText("");
    }

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4_registration_driver);

        this.setTitle("Driver Registration");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        etFname = findViewById(R.id.etfnamed);
        etLname = findViewById(R.id.etlnamed);
        etEmail = findViewById(R.id.etemaild);
        etConNum = findViewById(R.id.etConnumd);
        etAddress = findViewById(R.id.etAdderessd);
        etregNo = findViewById(R.id.etVehNum);
        etvehCol = findViewById(R.id.etColour);
        etVehType = findViewById(R.id.etVehType);
        etPassword = findViewById(R.id.etPasswordd);


        btnsubmit = findViewById(R.id.btnSubmitDr);

        driver = new Driver();

        btnsubmit.setOnClickListener(view -> {
            dbRef = FirebaseDatabase.getInstance().getReference().child("Driver");

            /*
            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference myRef = database.getReference("message");

            myRef.setValue("Hello, World5!");

             */

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
                else if (TextUtils.isEmpty(etregNo.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter the registration number", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etVehType.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter the vehicle type", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etvehCol.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter the vehicle colour", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etPassword.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter the Password", Toast.LENGTH_SHORT).show();
                else {
                    //driver.setVehicleColour(etvehCol.getText().toString().trim());
                    driver.setFirstname(etFname.getText().toString().trim());
                    driver.setLastname(etLname.getText().toString().trim());
                    driver.setEmail(etEmail.getText().toString().trim());
                    driver.setContactNumber(Integer.parseInt(etConNum.getText().toString().trim()));
                    driver.setAddress(etAddress.getText().toString().trim());
                    driver.setVahicleRegNo(etregNo.getText().toString().trim());
                    driver.setVehicleType(etVehType.getText().toString().trim());
                    driver.setVehicleColour(etvehCol.getText().toString().trim());
                    driver.setPassword(etPassword.getText().toString().trim());



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

}
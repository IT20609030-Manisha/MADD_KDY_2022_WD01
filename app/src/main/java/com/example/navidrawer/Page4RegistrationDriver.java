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


    private EditText etNIC,etFname, etLname, etEmail, etConNum, etAddress, etregNo, etvehCol, etVehType,etPassword;
    private Button btnsubmit;
    private DatabaseReference dbRef;
    private Driver driver;
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    private String DriverID;

    /*
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

     */

    @SuppressLint("WrongViewCast")
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

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Driver");

        //driver = new Driver();

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String NIC = etNIC.getText().toString();
                String FirstName = etFname.getText().toString();
                String LastName = etLname.getText().toString();
                String Email = etEmail.getText().toString();
                String ContactNum = etConNum.getText().toString();
                String Address = etAddress.getText().toString();
                String RegNumber = etregNo.getText().toString();
                String VehColour = etvehCol.getText().toString();
                String VehType = etVehType.getText().toString();
                String Password = etPassword.getText().toString();
                DriverID = NIC;

                Driver driver = new Driver(NIC, FirstName, LastName, Email, ContactNum, Address, RegNumber, VehColour, VehType, Password, DriverID);

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.child(DriverID).setValue(driver);
                        Toast.makeText(Page4RegistrationDriver.this, "Added Successfully.....", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Page4RegistrationDriver.this, Page1LoginMain.class));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(Page4RegistrationDriver.this, "Registration Unsuccessfull....", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
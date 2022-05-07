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

    private EditText etNIC, etFname, etLname, etEmail, etConNum, etAddress, etPassword;
    private Button btnsubmit;
    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase;
    private String DonorID;
    //private Donor donor;


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


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Donor");

        btnsubmit = findViewById(R.id.btnSubmitD);

        btnsubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String NIC = etNIC.getText().toString();
                String FirstName = etFname.getText().toString();
                String LastName = etLname.getText().toString();
                String Email = etEmail.getText().toString();
                String ContactNum = etConNum.getText().toString();
                String Address = etAddress.getText().toString();
                String Password = etPassword.getText().toString();
                DonorID = NIC;

                Donor donor = new Donor(NIC, FirstName, LastName, Email, ContactNum, Address, Password, DonorID);

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.child(DonorID).setValue(donor);
                        Toast.makeText(Page5RegistrationDonor.this, "Added Successfully..", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Page5RegistrationDonor.this,Page1LoginMain.class));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(Page5RegistrationDonor.this, "Failed....", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }
}
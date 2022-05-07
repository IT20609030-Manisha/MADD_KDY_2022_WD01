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

    private EditText etRegsNo,etOrgName, etOemail, etOConNum, etOAddress, etEmName, etDes, etEmConNum, etNpassword, etaccept;
    private Button btnSubmit;
    private DatabaseReference dbRef;
    //Needer needertemp;
    private String NeederID;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;



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


        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Needer");

        btnSubmit = findViewById(R.id.btnSubmitN);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String RegistrationNumber = etRegsNo.getText().toString();
                String OrganizationName = etOrgName.getText().toString();
                String Email = etOemail.getText().toString();
                String ContactNumber = etOConNum.getText().toString();
                String Address = etOAddress.getText().toString();
                String Name = etEmName.getText().toString();
                String Designation = etDes.getText().toString();
                String EmergencyContactNumber = etEmConNum.getText().toString();
                String Password = etNpassword.getText().toString();
                String Accept = etaccept.getText().toString();
                NeederID = RegistrationNumber;

                Needer needer = new Needer(RegistrationNumber, OrganizationName,Email,ContactNumber,Address,Name,Designation,EmergencyContactNumber,Password,Accept,NeederID);

                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        databaseReference.child(NeederID).setValue(needer);
                        Toast.makeText(Page6RegistrationNeeder.this, "Added Successfully...", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(Page6RegistrationNeeder.this, Page1LoginMain.class));
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {
                        Toast.makeText(Page6RegistrationNeeder.this, "Unsuccessful", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });
    }

}
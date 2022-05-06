package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.navidrawer.model.Vacancy;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Page9AddVacancies extends AppCompatActivity {

    EditText etloc, etavail, etvehicle;
    Button btnSubmitp;
    RadioButton rb;
    RadioGroup rg;
    Vacancy vacancy;
    DatabaseReference dbRef;

    //method to clear all user inputs
    private void clearControls(){
        etloc.setText("");
        etavail.setText("");
        etvehicle.setText("");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page9_add_vacancies);

        this.setTitle("Post Vacancies");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        etloc = findViewById(R.id.etLocation);
        etvehicle = findViewById(R.id.etVehicleType);

        btnSubmitp = findViewById(R.id.btnSubmit);

        vacancy = new Vacancy();

        btnSubmitp.setOnClickListener(view -> {
            dbRef = FirebaseDatabase.getInstance().getReference().child("Vacancy");

            try {
                if (TextUtils.isEmpty(etloc.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter a Name", Toast.LENGTH_SHORT).show();
                else if (TextUtils.isEmpty(etvehicle.getText().toString()))
                    Toast.makeText(getApplicationContext(), "Please enter an Address", Toast.LENGTH_SHORT).show();
                else {
                    vacancy.setLocation(etloc.getText().toString().trim());
                    vacancy.setVehicleType(etvehicle.getText().toString().trim());


                    //insert into the database
                    dbRef.push().setValue(vacancy);
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
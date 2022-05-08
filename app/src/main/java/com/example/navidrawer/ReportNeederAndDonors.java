package com.example.navidrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ReportNeederAndDonors extends AppCompatActivity {

    FirebaseDatabase mDatabase;
    DatabaseReference mRef, donRef;
    TextView TVdonatorCount, TVneederCount;

    private int countDonators = 0;
    private int countNeeders = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report_needer_and_donors);

        this.setTitle("Report");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TVdonatorCount = findViewById(R.id.tv_donatorCount);
        TVneederCount = findViewById(R.id.tv_NeederCount);

        mDatabase = FirebaseDatabase.getInstance();
        donRef = mDatabase.getReference().child("Donor");

        donRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    countDonators = (int)dataSnapshot.getChildrenCount();
                    TVdonatorCount.setText(Integer.toString(countDonators));
                }
                else{
                    TVdonatorCount.setText("0");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        donRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    countNeeders = (int)dataSnapshot.getChildrenCount();
                    TVneederCount.setText(Integer.toString(countNeeders));
                }
                else{
                    TVneederCount.setText("0");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
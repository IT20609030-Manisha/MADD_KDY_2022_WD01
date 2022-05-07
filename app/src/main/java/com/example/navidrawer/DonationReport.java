package com.example.navidrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DonationReport extends AppCompatActivity {

    FirebaseDatabase mDatabase;
    DatabaseReference mRef, donRef;
    TextView donationCount;

    private int countDonations = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_report);

        donationCount = findViewById(R.id.tv_donationCount);

        mDatabase = FirebaseDatabase.getInstance();
        donRef = mDatabase.getReference().child("Donation");

        //get the child count of the Donation
        donRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    countDonations = (int)dataSnapshot.getChildrenCount();
                    donationCount.setText(Integer.toString(countDonations));

                }
                else{
                    donationCount.setText("0");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}
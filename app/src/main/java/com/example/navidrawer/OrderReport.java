package com.example.navidrawer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class OrderReport extends AppCompatActivity {

    FirebaseDatabase mDatabase;
    DatabaseReference mRef, donRef;
    TextView orderCount;

    private int countDonations = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_report);


        orderCount = findViewById(R.id.tv_orderCount);

        mDatabase = FirebaseDatabase.getInstance();
        donRef = mDatabase.getReference().child("Order");

        donRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    countDonations = (int)dataSnapshot.getChildrenCount();
                    orderCount.setText(Integer.toString(countDonations));

                }
                else{
                    orderCount.setText("0");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
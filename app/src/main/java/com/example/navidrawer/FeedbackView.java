package com.example.navidrawer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navidrawer.model.FeedbackCls;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.FirebaseDatabase;

public class FeedbackView extends AppCompatActivity {

    RecyclerView recyclerView;
    FeedbackAdapter feedbackAdapter;
    //FirebaseRecycleAdapter firebaseRecycleAdapter;

    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_view);

        recyclerView = (RecyclerView) findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        FirebaseRecyclerOptions<FeedbackCls> options =
                new FirebaseRecyclerOptions.Builder<FeedbackCls>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("FeedbackCls"), FeedbackCls.class)
                        .build();

        feedbackAdapter = new FeedbackAdapter((options));
        recyclerView.setAdapter(feedbackAdapter);

        floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),Feedback.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        feedbackAdapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        feedbackAdapter.stopListening();
    }
}
package com.example.navidrawer;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.navidrawer.model.FeedbackCls;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;

public class FeedbackView extends AppCompatActivity {

    RecyclerView recyclerView;
    FeedbackAdapter feedbackAdapter;
    //FirebaseRecycleAdapter firebaseRecycleAdapter;


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
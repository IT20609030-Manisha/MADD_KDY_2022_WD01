package com.example.navidrawer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

//import com.example.navidrawer.databinding.ActivityPage10DisplayVacanciesBinding;
//import com.example.navidrawer.ui.main.SectionsPagerAdapter;
import com.example.navidrawer.model.Post;
import com.example.navidrawer.model.PostAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class Page12AllReviews extends AppCompatActivity {


    RecyclerView recyclerView;
    PostAdapter postAdapter;
    FloatingActionButton addFAB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page12_all_reviews);

        this.setTitle("Reviews");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addFAB = findViewById(R.id.idFABAddCourse);


        recyclerView = findViewById(R.id.postList_RecyclerView);
      //  recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        FirebaseRecyclerOptions<Post> options=
                new FirebaseRecyclerOptions.Builder<Post>()
                        .setQuery(FirebaseDatabase.getInstance().getReference().child("Post"),Post.class)
                        .build();

    //    postlist = new ArrayList<Post>();
        postAdapter = new PostAdapter(options,this);
        recyclerView.setAdapter(postAdapter);

        addFAB.setOnClickListener(view -> {
            Intent intent = new Intent(Page12AllReviews.this,Page11PostReviews.class);
            startActivity(intent);
        });

    }

    protected void onStart() {
        super.onStart();
        postAdapter.startListening();
    }

    protected void onStop() {
        super.onStop();
        postAdapter.stopListening();
    }

}
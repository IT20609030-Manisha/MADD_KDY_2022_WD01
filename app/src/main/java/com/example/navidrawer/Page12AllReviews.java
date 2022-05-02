package com.example.navidrawer;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//import com.example.navidrawer.databinding.ActivityPage10DisplayVacanciesBinding;
//import com.example.navidrawer.ui.main.SectionsPagerAdapter;
import com.example.navidrawer.model.Post;
import com.example.navidrawer.model.PostAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class Page12AllReviews extends AppCompatActivity {

    FirebaseDatabase mDatabase;
    DatabaseReference mRef;
    FirebaseStorage mStorage;
    RecyclerView recyclerView;
    PostAdapter postAdapter;
    List<Post> postlist;

    Button btnAddpost;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page12_all_reviews);

        this.setTitle("Reviews");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        btnAddpost = findViewById(R.id.addPost);

        mDatabase = FirebaseDatabase.getInstance();
        mRef = mDatabase.getReference().child("Post");
        mStorage = FirebaseStorage.getInstance();
        recyclerView = findViewById(R.id.postList);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        postlist = new ArrayList<Post>();
        postAdapter = new PostAdapter(Page12AllReviews.this,postlist);
        recyclerView.setAdapter(postAdapter);

        btnAddpost.setOnClickListener(view -> {
            Intent intent = new Intent(Page12AllReviews.this,Page11PostReviews.class);
            startActivity(intent);
        });

        mRef.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                Post post = snapshot.getValue(Post.class);
                postlist.add(post);
                postAdapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}
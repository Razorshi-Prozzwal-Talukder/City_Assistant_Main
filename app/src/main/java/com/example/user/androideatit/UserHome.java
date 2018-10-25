package com.example.user.androideatit;

import android.support.annotation.NonNull;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.androideatit.Model.Category;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class UserHome extends AppCompatActivity {
    private DrawerLayout drawer;

    private RecyclerView mRecyclerView;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mRef;
    private FirebaseRecyclerAdapter<Category, ViewHolder>firebaseRecyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);


        //TOOLBAR
        Toolbar toolbar = findViewById(R.id.toolbarId);
        setSupportActionBar(toolbar);
        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer,toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();



        //RecyclerView
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        //set Layout as LiniarLayout
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this ));

        //send query to database
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        Query query = mFirebaseDatabase.getReference().child("Category");
        FirebaseRecyclerOptions<Category> options =
                new FirebaseRecyclerOptions.Builder<Category>()
                        .setQuery(query, Category.class)
                        .build();
        firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Category, ViewHolder>(options){

            @Override
            protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Category model) {
                holder.setDetails(getApplicationContext(), model.getTitle(), model.getDescription(), model.getImage());
            }

            @NonNull
            @Override
            public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
                View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);
////                        return null;
                ViewHolder viewHolder = new ViewHolder(view);
                return viewHolder;
            }

        };

        //set adapter to recycler View
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }


    //load data into recycler view

    @Override
    protected void onStart() {
        super.onStart();
        firebaseRecyclerAdapter.startListening();

    }


    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @Override
    protected void onStop() {
        super.onStop();
        firebaseRecyclerAdapter.stopListening();
    }


}

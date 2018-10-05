package com.example.user.androideatit;

import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.androideatit.Model.Category;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UserHome extends AppCompatActivity {

    RecyclerView mRecyclerView;
    FirebaseDatabase mFirebaseDatabase;
    DatabaseReference mRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        //ActionBar
        ActionBar actionBar = getSupportActionBar();
        //set title
        actionBar.setTitle("Item List");

        //RecyclerView
        mRecyclerView = findViewById(R.id.recyclerView);
        mRecyclerView.setHasFixedSize(true);

        //set Layout as LiniarLayout
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this ));

        //send query to database
        mFirebaseDatabase = FirebaseDatabase.getInstance();
        mRef = mFirebaseDatabase.getReference("Category");
    }

    //load data into recycler view

//    Category.class,
//    R.layout.row,
//    ViewHolder.class,
//    mRef

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Category, ViewHolder>firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Category, ViewHolder>(){

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





//                    @Override
//                    protected void onBindViewHolder(@NonNull ViewHolder holder, int position, @NonNull Category model) {
//                            holder.setDetails(getApplicationContext(), model.getTitle(), model.getDescription(), model.getImage());
//                    }
//
//                    @NonNull
//                    @Override
//                    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//                        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row, viewGroup, false);
////                        return null;
//                        ViewHolder viewHolder = new ViewHolder(view);
//                        return viewHolder;
//                    }

                };

        //set adapter to recycler View
        mRecyclerView.setAdapter(firebaseRecyclerAdapter);
    }
}

package com.example.user.androideatit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ManagerActivity extends AppCompatActivity {

    Button allplatterButton,addplatterButton,deleteplatterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager);

        allplatterButton = findViewById(R.id.allplatterId);
        addplatterButton = findViewById(R.id.addplatterId);
        deleteplatterButton = findViewById(R.id.deleteplatterId);

        allplatterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ManPlatterView = new Intent(ManagerActivity.this, ManPlatterView.class);
                startActivity(ManPlatterView);
                Toast.makeText(ManagerActivity.this,"All Platter Viewed Here",Toast.LENGTH_SHORT).show();


            }
        });

        addplatterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent ManPlatterAdd = new Intent(ManagerActivity.this, ManPlatterAdd.class);
                startActivity(ManPlatterAdd);
                Toast.makeText(ManagerActivity.this,"Add Platter Viewed Here",Toast.LENGTH_SHORT).show();

            }
        });

        deleteplatterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(ManagerActivity.this,"Platter Delete Successfully!!",Toast.LENGTH_SHORT).show();


            }
        });
    }
}

package com.example.user.androideatit;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PersonSelection extends AppCompatActivity {

    TextView personText;
    Button admin, manager, customer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_selection);

        personText = findViewById(R.id.persontext);
//        admin = findViewById(R.id.adminid);
        manager = findViewById(R.id.managerid);
        customer = findViewById(R.id.customerid);

        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/Amelia Script.otf");
        personText.setTypeface(face);

//        admin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(PersonSelection.this, "Amdin Panel!!!", Toast.LENGTH_SHORT).show();
//
//            }
//        });

        manager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ManagerEntryActivity= new Intent(PersonSelection.this, ManagerEntryActivity.class);
                startActivity(ManagerEntryActivity);
            }
        });

        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent MainActivity= new Intent(PersonSelection.this, MainActivity.class);
                startActivity(MainActivity);

            }
        });
    }
}

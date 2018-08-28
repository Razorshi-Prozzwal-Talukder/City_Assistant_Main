package com.example.user.androideatit;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SectorChoice extends AppCompatActivity {

    TextView sectorText;
    Button foodworld, attractiveplaces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector_choice);

        sectorText = findViewById(R.id.sectortext);
        foodworld = findViewById(R.id.foodworld);
        attractiveplaces = findViewById(R.id.attractiveplaces);

        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/Amelia Script.otf");
        sectorText.setTypeface(face);

        foodworld.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent PersonSelection = new Intent(SectorChoice.this, PersonSelection.class);
                startActivity(PersonSelection);
            }
        });

        attractiveplaces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(SectorChoice.this, "Attractive Place is not Ready now.", Toast.LENGTH_SHORT).show();

            }
        });
    }
}

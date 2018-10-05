package com.example.user.androideatit;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ManagerEntryActivity extends AppCompatActivity {

    TextView manager_entry_text;
    Button managerLogin, managerRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_entry);

        manager_entry_text = findViewById(R.id.manager_entry_text);
        managerLogin = findViewById(R.id.managerloginId);
        managerRegister = findViewById(R.id.registrationId);

        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/Amelia Script.otf");
        manager_entry_text.setTypeface(face);

        managerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ManagerLogin = new Intent(ManagerEntryActivity.this, ManagerLogin.class);
                startActivity(ManagerLogin);
            }
        });

        managerRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ValidationForm = new Intent(ManagerEntryActivity.this, ValidationForm.class);
                startActivity(ValidationForm);
            }
        });
    }
}

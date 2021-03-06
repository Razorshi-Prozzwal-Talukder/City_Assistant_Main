package com.example.user.androideatit;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.androideatit.Model.Manager;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ManagerLogin extends AppCompatActivity {

    EditText edtPhone, edtPassword;
    Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_login);

        edtPassword = findViewById(R.id.edtPassword);
        edtPhone = findViewById(R.id.edtPhone);
        btnSignIn = findViewById(R.id.btnSignIn);

//        Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user =  database.getReference("Manager");

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog mDialog = new ProgressDialog(ManagerLogin.this);
                mDialog.setMessage("Please Waiting....");
                mDialog.show();



                table_user.addValueEventListener(new ValueEventListener() {


                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //Check If user not Exist in Database
                        if (dataSnapshot.child(edtPhone.getText().toString()).exists()) {
                            //Get User information
                            mDialog.dismiss();
                            Manager user = dataSnapshot.child(edtPhone.getText().toString()).getValue(Manager.class);
                            if (user.getPassword().equals(edtPassword.getText().toString())) {
                                Toast.makeText(ManagerLogin.this, "Sign in Successfully!", Toast.LENGTH_SHORT).show();

                                Intent ManagerActivity = new Intent(ManagerLogin.this, ManagerActivity.class);
                                startActivity(ManagerActivity);

                            } else {
                                Toast.makeText(ManagerLogin.this, "Wrong Password!!!", Toast.LENGTH_SHORT).show();

                            }
                        }
                        else{
                            mDialog.dismiss();
                            Toast.makeText(ManagerLogin.this, "User Not exist in Database!!!", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}

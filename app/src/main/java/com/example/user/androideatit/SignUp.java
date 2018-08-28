package com.example.user.androideatit;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.user.androideatit.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUp extends AppCompatActivity {

    EditText edtPhone2, edtName2, edtPassword2;
    Button btnSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtName2 = findViewById(R.id.edtName2);
        edtPassword2 = findViewById(R.id.edtPassword2);
        edtPhone2 = findViewById(R.id.edtPhone2);

        btnSignUp = findViewById(R.id.btnSignUp);

        //Int Firebase
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user =  database.getReference("User");

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog mDialog = new ProgressDialog(SignUp.this);
                mDialog.setMessage("Please Waiting....");
                mDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {

                        //Check If already User Phone
                        if (dataSnapshot.child(edtPhone2.getText().toString()).exists()){
                            mDialog.dismiss();
                            Toast.makeText(SignUp.this,"Phone Number is Already Registered",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            mDialog.dismiss();
                            User user = new User(edtName2.getText().toString(),edtPassword2.getText().toString());
                            table_user.child(edtPhone2.getText().toString()).setValue(user);
                            Toast.makeText(SignUp.this,"Sign Up Successfully !!!",Toast.LENGTH_SHORT).show();
                            finish();
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

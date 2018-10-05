package com.example.user.androideatit;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.user.androideatit.Model.Manager;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

public class ValidationForm extends AppCompatActivity {

    EditText fname,email,resname,phno,pass,cnpass;
    Button submit;
    TextView textView;
    AwesomeValidation awesomeValidation;
    DatabaseReference managerForm;
    Map<String, Boolean> numbers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation_form);

        textView = findViewById(R.id.textView);

        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/Amelia Script.otf");
        textView.setTypeface(face);


        numbers = new HashMap<>();
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        loadNumbers();
        updateUI();

    }


    private void updateUI() {

        fname = findViewById(R.id.fname);
//        email = findViewById(R.id.email);
        resname = findViewById(R.id.resname);
        phno = findViewById(R.id.phno);
        pass = findViewById(R.id.pass);
        cnpass = findViewById(R.id.cnpass);

        submit = findViewById(R.id.submit);

        managerForm = FirebaseDatabase.getInstance().getReference("Manager");


        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";

        awesomeValidation.addValidation(ValidationForm.this,R.id.fname,"[a-zA-Z\\s]+",R.string.fnameerr);
//        awesomeValidation.addValidation(ValidationForm.this,R.id.email,android.util.Patterns.EMAIL_ADDRESS,R.string.emailerr);
        awesomeValidation.addValidation(ValidationForm.this,R.id.resname,"[a-zA-Z\\s]+",R.string.resnameerr);
        awesomeValidation.addValidation(ValidationForm.this,R.id.phno, RegexTemplate.TELEPHONE,R.string.phnoerr);
        awesomeValidation.addValidation(ValidationForm.this,R.id.pass,regexPassword,R.string.passerr);
        awesomeValidation.addValidation(ValidationForm.this,R.id.cnpass,R.id.pass,R.string.cnpasserr);

        submit.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View view) {

                if(awesomeValidation.validate()){

                    if(isNumberExist(phno.getText().toString())){

                        Toast.makeText(ValidationForm.this,"Phone Number is Already Registered",Toast.LENGTH_SHORT).show();

                    }

                    else{
                        formadd();
                    }

                }
                else{
                    Toast.makeText(ValidationForm.this, "Wrong!!!", Toast.LENGTH_SHORT).show();

                }

            }
        });
    }

    private void formadd(){
        String name= fname.getText().toString().trim();
        //String email= email.toString()
        String phone= phno.getText().toString().trim();
        String restaurant= resname.getText().toString().trim();
        String password= pass.getText().toString().trim();

        String id= managerForm.push().getKey();
        Manager manager = new Manager(name, phone, restaurant, password);
        managerForm.child(phno.getText().toString()).setValue(manager);

        Toast.makeText(ValidationForm.this, "Its Done!!!", Toast.LENGTH_SHORT).show();
    }

    private boolean isNumberExist(final String number){
        if(numbers.get(number) == null)
        {
            return false;

        }
        else
        {
            return true;
        }
    }

    private void loadNumbers() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Manager");
        reference.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                Manager manager = dataSnapshot.getValue(Manager.class);
                numbers.put(manager.getPhone(),true);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }


            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }

        });

    }

}

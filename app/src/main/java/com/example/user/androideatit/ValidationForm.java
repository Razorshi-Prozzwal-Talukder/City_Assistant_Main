package com.example.user.androideatit;

import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;
import com.example.user.androideatit.Model.Manager;
import com.example.user.androideatit.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ValidationForm extends AppCompatActivity {

    EditText fname,email,resname,phno,pass,cnpass;
    Button submit;
    TextView textView;
    AwesomeValidation awesomeValidation;
    Boolean numberExist;

    DatabaseReference managerForm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_validation_form);

        textView = findViewById(R.id.textView);

        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/Amelia Script.otf");
        textView.setTypeface(face);



        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
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
//

        String regexPassword = "(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d])(?=.*[~`!@#\\$%\\^&\\*\\(\\)\\-_\\+=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";

        awesomeValidation.addValidation(ValidationForm.this,R.id.fname,"[a-zA-Z\\s]+",R.string.fnameerr);
//        awesomeValidation.addValidation(ValidationForm.this,R.id.email,android.util.Patterns.EMAIL_ADDRESS,R.string.emailerr);
        awesomeValidation.addValidation(ValidationForm.this,R.id.resname,"[a-zA-Z\\s]+",R.string.resnameerr);
        awesomeValidation.addValidation(ValidationForm.this,R.id.phno, RegexTemplate.TELEPHONE,R.string.phnoerr);
        awesomeValidation.addValidation(ValidationForm.this,R.id.pass,regexPassword,R.string.passerr);
        awesomeValidation.addValidation(ValidationForm.this,R.id.cnpass,R.id.pass,R.string.cnpasserr);

        submit.setOnClickListener(new View.OnClickListener() {


            //Int Firebase
//            final FirebaseDatabase database = FirebaseDatabase.getInstance();
//            final DatabaseReference manager_form =  database.getReference("Manager");

            @Override
            public void onClick(View view) {

                if(awesomeValidation.validate()){
//                    Toast.makeText(ValidationForm.this, "Data pass successfully!!!", Toast.LENGTH_SHORT).show();

//                    final ProgressDialog mDialog = new ProgressDialog(ValidationForm.this);
//                    mDialog.setMessage("Please Waiting....");
//                    mDialog.show();
                    if(isNumberExist(phno.getText().toString())){

                        Toast.makeText(ValidationForm.this,"Phone Number is Already Registered",Toast.LENGTH_SHORT).show();

                    }
//                    isNumberExist("018215141");
                    else{
                        formadd();
                    }



//                    managerForm.addValueEventListener(new ValueEventListener() {
//                        @Override
//                        public void onDataChange(DataSnapshot dataSnapshot) {
//
//                            Log.i("Managersss",phno.getText().toString());
//
//
//                            //Check If already User Phone
//                            if (dataSnapshot.hasChild(phno.getText().toString())){
////                                mDialog.dismiss();
//                            }
//                            else{
////                                mDialog.dismiss();
////                                Manager manager = new Manager(fname.getText().toString(),email.getText().toString(),resname.getText().toString(),pass.getText().toString());
////                                manager_form.child(phno.getText().toString()).setValue(manager);
////                                Toast.makeText(ValidationForm.this,"Registration Successfully !!!",Toast.LENGTH_SHORT).show();
////                                finish();
////                                Log.i("Managersss", "Called");
////                                formadd();
//                            }
//
//                        }
//
//                        @Override
//                        public void onCancelled(DatabaseError databaseError) {
//
//                        }
//                    });
//
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
        Manager manager = new Manager(id, name, phone, restaurant, password);
        managerForm.child(id).setValue(manager);

        Toast.makeText(ValidationForm.this, "Its Done!!!", Toast.LENGTH_SHORT).show();
    }

    private boolean isNumberExist(final String number){
        numberExist = false;
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Manager");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {



                Manager manager = dataSnapshot.getValue(Manager.class);
                Log.i("Managersss"," "+manager.getPhone()+" "+number);


                if(number.equals(manager.getPhone().trim())){
                        numberExist=true;
                    }
//                if(dataSnapshot.getKey().equals("phone"))
//                    if(number.equals(dataSnapshot.getValue())){
//                        numberExist=true;
//
//                    }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return numberExist;
    }

}

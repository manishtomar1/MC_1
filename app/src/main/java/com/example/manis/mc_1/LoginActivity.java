package com.example.manis.mc_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//login page has been conncted with database
public class LoginActivity extends AppCompatActivity {
    /* Changes Made Changes Made again*/

    private Button mLoginbtn;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /*Changes made by me*/
        mLoginbtn=(Button) findViewById(R.id.button_login);
        mDatabase= FirebaseDatabase.getInstance().getReference();
        mLoginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Hello "+mDatabase.getKey());
                EditText username   = (EditText)findViewById(R.id.editText_username);
                String user= username.getText().toString();
                mDatabase.child("Name").setValue(user);
            }
        });
    }

}

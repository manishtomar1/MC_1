package com.example.manis.mc_1;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

//login page has been conncted with database
public class LoginActivity extends AppCompatActivity {
    /* Changes Made Changes Made again*/

    private Button mLoginbtn;
    private DatabaseReference mDatabase;
    private FirebaseAuth mAuth;
    EditText username,password;
    ProgressBar progressBarLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        /*Changes made by me*/
        mLoginbtn=(Button) findViewById(R.id.button_login);
        mDatabase= FirebaseDatabase.getInstance().getReference();
        mAuth=FirebaseAuth.getInstance();
        username=(EditText) findViewById(R.id.editText_username);
        password=(EditText) findViewById(R.id.editText_password);
        progressBarLogin =(ProgressBar) findViewById(R.id.progressBar_login);

        mLoginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email=username.getText().toString();
                final String pass=password.getText().toString();
                if (email.isEmpty()) {
                    username.setError("Email is required");
                    username.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    username.setError("Invalid email");
                    username.requestFocus();
                    return;
                }
                if(pass.isEmpty()){
                    password.setError("Password is required");
                    password.requestFocus();
                    return;
                }
                if(pass.length()<6){
                    password.setError("Password length should be atleast 6 character long");
                    password.requestFocus();
                    return;
                }

                //comment

                progressBarLogin.setVisibility(View.VISIBLE);
                mAuth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBarLogin.setVisibility(View.GONE);
                        if(task.isSuccessful())
                            Toast.makeText(getApplicationContext(),"Login success",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(getApplicationContext(),"Error :"+task.getException().getMessage(),Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


    }

}

/*
        // for signup given email and password.... email should be valid pattern and password should be of length 6
        String email="manish17025@iiitd.ac.in";
        String password="qwerty123";
        final int[] flag = {1};
        if(flag[0] ==1) {
            mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        System.out.println("Sign up success.....");
                        flag[0] = 0;
                    }
                    else
                    {
                        if(task.getException() instanceof FirebaseAuthUserCollisionException)
                        {
                            System.out.println("User already registered.....");
                        }
                        else
                            System.out.println("Error occured..... "+task.getException().getMessage());
                    }
                }
            });
        }
*/



/*
// to store data name:"nitin"
        mLoginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText username   = (EditText)findViewById(R.id.editText_username);
                EditText password   = (EditText)findViewById(R.id.editText_username);
                String user= username.getText().toString();
                mDatabase.child("Name").setValue(user);


            }
        });

* */




/*
//to retrieve data ==> root {username:"nitin",password:abcde}
 mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        DataSnapshot user = dataSnapshot.child("username");
                        DataSnapshot pass = dataSnapshot.child("password");
                        String u=user.getValue().toString();
                        String p=pass.getValue().toString();

                        EditText username   = (EditText)findViewById(R.id.editText_username);
                        EditText password   = (EditText)findViewById(R.id.editText_password);
                        username.setText(u);
                        password.setText(p);

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

* */
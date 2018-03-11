package com.example.manis.mc_1;

import android.content.Intent;
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
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPasswordActivity extends AppCompatActivity {

    private EditText registeredEmail;
    private Button resetPassword;
    private FirebaseAuth mAuth;
    ProgressBar progressBar_forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        registeredEmail=(EditText)findViewById(R.id.editText_registeredEmail);
        resetPassword=(Button) findViewById(R.id.button_reset_password);
        mAuth=FirebaseAuth.getInstance();
        progressBar_forgotPassword =(ProgressBar) findViewById(R.id.progressBar_forgotPassword);

        resetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=registeredEmail.getText().toString().trim();
                if (email.isEmpty()) {
                    registeredEmail.setError("Email is required");
                    registeredEmail.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    registeredEmail.setError("Invalid email");
                    registeredEmail.requestFocus();
                    return;
                }

                progressBar_forgotPassword.setVisibility(View.VISIBLE);
                mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        progressBar_forgotPassword.setVisibility(View.GONE);
                        if(task.isSuccessful()){
                            Toast.makeText(getApplicationContext(),"Link send to registered email",Toast.LENGTH_LONG).show();
                            finish();
                                startActivity(new Intent(ForgotPasswordActivity.this,LoginActivity.class));
                        }
                        else
                        {
                            Toast.makeText(getApplicationContext(),"Error :"+task.getException().getMessage(),Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }
        });

    }
}

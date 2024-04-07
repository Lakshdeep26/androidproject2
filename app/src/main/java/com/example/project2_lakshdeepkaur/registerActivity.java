package com.example.project2_lakshdeepkaur;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class registerActivity extends AppCompatActivity {
    TextView alreadyHaveAccount;
    EditText inputName, inputEmail, inputPassword, inputConPassword, inputMobile; // Add inputName and inputMobile
    Button btnregister;
 String emailPattern =  "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

 ProgressDialog progressDialog;
 FirebaseAuth mAuth;
 FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        alreadyHaveAccount = findViewById(R.id.alreadyHaveAccount);
        inputName = findViewById(R.id.inputName);
        inputEmail = findViewById(R.id.inputEmail);
        inputMobile = findViewById(R.id.inputMobile);
        inputPassword = findViewById(R.id.inputPassword);
        inputConPassword = findViewById(R.id.inputConPassword);
        btnregister = findViewById(R.id.btnregister)  ;
        progressDialog =new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();



        alreadyHaveAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(registerActivity.this,MainActivity.class));
            }
        });

btnregister.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        PerforAuth();
    }
});

    }

    private void PerforAuth() {
        String name = inputName.getText().toString();
        String email = inputEmail.getText().toString();
        String mobile = inputMobile.getText().toString();
        String password = inputPassword.getText().toString();
        String confirmPassword = inputConPassword.getText().toString();

        if (name.isEmpty()) {
            inputName.setError("Enter your name");
        } else if (!email.matches(emailPattern)) {
            inputEmail.setError("Enter Correct Email Id");
        } else if (password.isEmpty() || password.length() < 8) {
            inputPassword.setError("Password should be 8 characters.");
        } else if (!password.equals(confirmPassword)) {
            inputConPassword.setError("Password does not match");
        } else if (mobile.isEmpty()) {
            inputMobile.setError("Enter your mobile number");
        }
        else{
            progressDialog.setMessage("Please Wait While Registration in progress");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(!isFinishing()){
                    if (task.isSuccessful()){
                        progressDialog.dismiss();
                        sendUserToNextActivity();

                        Toast.makeText(registerActivity.this,"Registration Successful",Toast.LENGTH_SHORT).show();
                    }else {
                        progressDialog.dismiss();
                        Toast.makeText(registerActivity.this,""+task.getException(),Toast.LENGTH_SHORT).show();
                    }

                }
            }
            });


        }



    }

    private void sendUserToNextActivity() {
        Intent intent = new Intent(registerActivity.this,homeproductspage.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
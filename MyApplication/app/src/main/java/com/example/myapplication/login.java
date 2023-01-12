package com.example.myapplication;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class login extends AppCompatActivity implements View.OnClickListener{

    private TextView register;
    private EditText editTextemail,editTextmdp;
    private Button sign;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = (TextView) findViewById(R.id.register);
        register.setOnClickListener(this);

        sign = (Button) findViewById(R.id.signIn);
        sign.setOnClickListener(this);

        editTextmdp = (EditText) findViewById(R.id.password);
        editTextemail = (EditText) findViewById(R.id.email);

        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.register:
                startActivity(new Intent(this,register.class));
                break;

            case R.id.signIn:
                userLogin();
                break;
        }
    }

    private void userLogin() {
        String email = editTextemail.getText().toString().trim();
        String mdp = editTextmdp.getText().toString().trim();

        if(email.isEmpty()){
            editTextemail.setError("Email exigé");
            editTextemail.requestFocus();
            return;
        }

        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            editTextemail.setError("entrer un Email valide");
            editTextemail.requestFocus();
            return;
        }

        if(mdp.isEmpty()){
            editTextmdp.setError("le mot de passe exigé");
            editTextmdp.requestFocus();
            return;
        }

        if(mdp.length() < 6){
            editTextmdp.setError("entrer un mot de passe supérieur a 6");
            editTextmdp.requestFocus();
            return;
        }
        progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(email, mdp)

                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful()){
                        // redirection
                            startActivity(new Intent(login.this,MainActivity.class));
                        }else{
                            Toast.makeText(login.this,"impossible de se connecter ! infomation erroné",Toast.LENGTH_LONG).show();
                        }

                    }
                });
    }
}
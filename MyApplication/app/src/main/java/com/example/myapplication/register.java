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
import com.google.firebase.database.FirebaseDatabase;

import java.util.regex.Pattern;

public class register extends AppCompatActivity implements View.OnClickListener{

    private TextView banner,register;
    private EditText editTextname,editTextage,editTextemail,editTextmdp;
    private ProgressBar progressBar;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();

        banner = (TextView) findViewById(R.id.banner);
        banner.setOnClickListener(this);

        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(this);

        editTextname = (EditText) findViewById(R.id.prenom);
        editTextage = (EditText) findViewById(R.id.age);
        editTextemail = (EditText) findViewById(R.id.email);
        editTextmdp = (EditText) findViewById(R.id.password);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.banner:
                startActivity(new Intent(this,login.class));
                break;
            case R.id.register:
                register();
                break;
        }
    }

    private void register() {
        String email = editTextemail.getText().toString().trim();
        String mdp = editTextmdp.getText().toString().trim();
        String age = editTextage.getText().toString().trim();
        String prenom = editTextname.getText().toString().trim();

        if(prenom.isEmpty()){
            editTextname.setError("le prenom es exigé");
            editTextname.requestFocus();
            return;
        }

        if(age.isEmpty()){
            editTextname.setError("l'age' es exigé");
            editTextname.requestFocus();
            return;
        }

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
                    user user = new user(prenom,age,email);


                    FirebaseDatabase.getInstance().getReference("Users")
                            .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                            .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {

                                    if(task.isSuccessful()){
                                        Toast.makeText(register.this,"utilisateur ajouter!",Toast.LENGTH_LONG).show();
                                        progressBar.setVisibility(View.VISIBLE);
                                    }else{
                                        Toast.makeText(register.this,"echec de l'insertion! erreur!",Toast.LENGTH_LONG);
                                        progressBar.setVisibility(View.GONE);
                                    }
                                }
                            });
                }else{
                    Toast.makeText(register.this,"echec de l'insertion!",Toast.LENGTH_LONG);
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }
}
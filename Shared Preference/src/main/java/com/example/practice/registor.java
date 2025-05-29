package com.example.practice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import sharedprefrences.SessionManager;

public class registor extends AppCompatActivity {

    SessionManager sessionManager;

    //declared variables in EditText
    EditText rg_username,rg_email,rg_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registor);

        //we have defined here id's in findViewById
        rg_username = findViewById(R.id.rg_username);
        rg_email = findViewById(R.id.rg_email);
        rg_password = findViewById(R.id.rg_password);

    }

    //for registor button
    public void registor_button(View view){

        String username = rg_username.getText().toString().trim();
        String email = rg_email.getText().toString().trim();
        String password = rg_password.getText().toString().trim();

        sessionManager = new SessionManager(getApplicationContext());
        sessionManager.createSession(username,email);

        startActivity(new Intent(this, Profile.class));

        //insert into the database
//
//        String tostmess = "Username :"+username+
//                           "\nEmail :"+email +
//                           "\nPassword :"+password;
//
//        Toast.makeText(this,tostmess,Toast.LENGTH_LONG).show();
    }

    //aready have account
    public void open_login(View view){
        startActivity(new Intent(this, Login.class));
    }
}
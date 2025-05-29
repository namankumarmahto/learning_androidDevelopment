package com.example.practice;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import sharedprefrences.SessionManager;

public class Login extends AppCompatActivity {

    SessionManager sessionManager;
    EditText lg_username,lg_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        lg_username = findViewById(R.id.lg_username);
        lg_password = findViewById(R.id.lg_password);

        sessionManager = new SessionManager(getApplicationContext());
    }

    //for login button
    public void login_button(View view){

        String username = lg_username.getText().toString().trim();
        String passeword = lg_password.getText().toString().trim();

        if(username.equals("Naman") && passeword.equals("123")){
            sessionManager.createSession("Naman","123");
            startActivity(new Intent(Login.this, Profile.class));
            finish();
        }
    }

    //for create an account text
    public void create_account(View view){

        startActivity(new Intent(this, registor.class));
    }
}
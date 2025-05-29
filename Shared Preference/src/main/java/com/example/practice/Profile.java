package com.example.practice;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import sharedprefrences.SessionManager;

public class Profile extends AppCompatActivity {

    SessionManager sessionManager;
    TextView Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        Name=findViewById(R.id.Name);

        sessionManager = new SessionManager(getApplicationContext());
        String username = sessionManager.getData("key_username");
        Name.setText(username);

    }

    public void log_out_button(View view){
        sessionManager.logoutSession();
    }

}
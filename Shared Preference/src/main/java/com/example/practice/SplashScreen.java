package com.example.practice;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import sharedprefrences.SessionManager;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();  //it's used to hdie the action bar
        setContentView(R.layout.activity_splash_screen);




        // Handler is using for delay
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {

                SessionManager sessionManager = new SessionManager(getApplicationContext());
                boolean b = sessionManager.checkSession();
                if(b==true){
                    startActivity(new Intent(SplashScreen.this, Profile.class));
                    finish();
                }
                else{
                    startActivity(new Intent(SplashScreen.this, Login.class));
                    finish();
                }


//
//                Intent login = new Intent(SplashScreen.this, Login.class);
//                SplashScreen.this.startActivity(login);
//                SplashScreen.this.finish(); // closes the current activity and user can't come back into this activity
            }
        }, 1000);
    }
}
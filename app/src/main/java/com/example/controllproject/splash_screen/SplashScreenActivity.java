package com.example.controllproject.splash_screen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.controllproject.PreferenceManager;
import com.example.controllproject.R;
import com.example.controllproject.login.LoginActivity;

public class SplashScreenActivity extends AppCompatActivity {
    PreferenceManager preferenceManager;//default is false

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

//        preferenceManager = new PreferenceManager(getApplicationContext());
//        preferenceManager.putBoolean("WhatsApp",false);
//        System.out.println(preferenceManager.getBoolean("WhatsApp"));

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1000);

                    Intent intent = new Intent(SplashScreenActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        };
        thread.start();

    }
}
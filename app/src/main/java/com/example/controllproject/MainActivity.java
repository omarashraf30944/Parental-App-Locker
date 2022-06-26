package com.example.controllproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.TextView;

import com.example.controllproject.down_time.DowntimeActivity;
import com.example.controllproject.locked_app.LockedAppActivity;
import com.example.controllproject.login.LoginActivity;
import com.example.controllproject.login_now.LoginNowActivity;
import com.example.controllproject.setting.SettingActivity;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Set;

public class MainActivity extends AppCompatActivity {

    PreferenceManager preferenceManager;

    TextView email,name ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CardView downtime = findViewById(R.id.downtime);
        CardView locked_app = findViewById(R.id.locked_app);
        CardView setting = findViewById(R.id.setting);

        preferenceManager = new PreferenceManager(this);

        email = findViewById(R.id.email);
        name = findViewById(R.id.name);
         email.setText(  preferenceManager.getString("email" ));
        name.setText(  preferenceManager.getString("username" ));

        downtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                new CountDownTimer(30000, 1000) {
//
//                    @SuppressLint("SetTextI18n")
//                    public void onTick(long millisUntilFinished) {
//                        downtime.setText("seconds remaining: " + millisUntilFinished / 1000);
//                    }
//
//                    @SuppressLint("SetTextI18n")
//                    public void onFinish() {
//                        downtime.setText("done!");
//                    }
//                }.start();
                startActivity(new Intent(MainActivity.this, DowntimeActivity.class));
            }
        });
        locked_app.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LockedAppActivity.class));
            }
        });

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SettingActivity.class));
            }
        });

    }
    public void logout(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
        finish();
    }
}
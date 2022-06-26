package com.example.controllproject.setting;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;

import com.example.controllproject.MainActivity;
import com.example.controllproject.R;
import com.example.controllproject.account.AccountActivity;
import com.example.controllproject.change_pin.ChangePinActivity;
import com.example.controllproject.down_time.DowntimeActivity;
import com.example.controllproject.finger_print.FingerActivity;
import com.example.controllproject.info.InfoActivity;
import com.example.controllproject.pin.PinActivity;

public class SettingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
//        CardView account = findViewById(R.id.account);
//        CardView pin = findViewById(R.id.pin);
//        CardView finger = findViewById(R.id.finger);
        CardView about = findViewById(R.id.about);
        CardView allow_permissions = findViewById(R.id.allow_permission);
        getSupportActionBar().setTitle("Setting");

//        account.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(SettingActivity.this, AccountActivity.class));
//            }
//        });
//
//        pin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(SettingActivity.this, ChangePinActivity.class));
//            }
//        });
//
//        finger.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(SettingActivity.this, FingerActivity.class));
//            }
//        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SettingActivity.this, InfoActivity.class));
            }
        });
        allow_permissions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS));

            }
        });
    }
}
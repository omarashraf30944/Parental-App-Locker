package com.example.controllproject.change_pin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.controllproject.R;
import com.example.controllproject.account.AccountActivity;
import com.example.controllproject.rest_pin.RestPinActivity;
import com.example.controllproject.setting.SettingActivity;
import com.google.android.material.button.MaterialButton;

public class ChangePinActivity extends AppCompatActivity {
    TextView forget_pin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_pin);
        getSupportActionBar().setTitle("Setting");
        forget_pin= findViewById(R.id.forget_pin);
        MaterialButton confirm= findViewById(R.id.btn_confirm_pin);

        forget_pin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChangePinActivity.this, RestPinActivity.class));
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ChangePinActivity.this, SettingActivity.class));
                finish();
            }
        });
    }
}
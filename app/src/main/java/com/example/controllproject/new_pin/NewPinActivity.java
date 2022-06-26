package com.example.controllproject.new_pin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.controllproject.R;
import com.example.controllproject.rest_pin.RestPinActivity;
import com.example.controllproject.setting.SettingActivity;

public class NewPinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_pin);
        getSupportActionBar().setTitle("Setting");
        Button button = findViewById(R.id.btn_confirm_changed);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(NewPinActivity.this, SettingActivity.class));
            }
        });

    }
}
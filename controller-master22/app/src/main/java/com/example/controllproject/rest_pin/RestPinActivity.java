package com.example.controllproject.rest_pin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.controllproject.R;
import com.example.controllproject.account.AccountActivity;
import com.example.controllproject.change_pin.ChangePinActivity;
import com.example.controllproject.new_pin.NewPinActivity;
import com.example.controllproject.setting.SettingActivity;

public class RestPinActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_pin);
        getSupportActionBar().setTitle("Setting");
        Button button = findViewById(R.id.btn_confirm_);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RestPinActivity.this, NewPinActivity.class));
            }
        });

    }
}
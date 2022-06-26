package com.example.controllproject.re_password.rest_password;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.controllproject.R;
import com.example.controllproject.new_pin.NewPinActivity;
import com.example.controllproject.rest_pin.RestPinActivity;
import com.example.controllproject.setting.SettingActivity;

import java.util.Objects;

public class ResetPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Setting");
        Button button = findViewById(R.id.btn_confirm_password);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResetPasswordActivity.this, SettingActivity.class));
                finish();
            }
        });
    }
}
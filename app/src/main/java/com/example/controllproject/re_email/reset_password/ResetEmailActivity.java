package com.example.controllproject.re_email.reset_password;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.controllproject.R;
import com.example.controllproject.finger_print.FingerActivity;
import com.example.controllproject.finger_print.remove.RemoveFingerActivity;
import com.example.controllproject.setting.SettingActivity;
import com.google.android.material.button.MaterialButton;

public class ResetEmailActivity extends AppCompatActivity {
    MaterialButton button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_email);
        button = findViewById(R.id.btn_confirm_email);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ResetEmailActivity.this, SettingActivity.class));
                finish();
            }
        });


    }
}
package com.example.controllproject.pin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.controllproject.R;
import com.example.controllproject.account.AccountActivity;
import com.example.controllproject.finger_print.remove.RemoveFingerActivity;
import com.example.controllproject.setting.SettingActivity;

public class PinActivity extends AppCompatActivity {
    TextView remove;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pin);

        remove = findViewById(R.id.btn_confirm_);
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PinActivity.this, SettingActivity.class ));
                finish();
            }
        });
    }
}
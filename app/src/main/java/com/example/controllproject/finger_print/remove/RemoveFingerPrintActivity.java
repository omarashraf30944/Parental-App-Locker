package com.example.controllproject.finger_print.remove;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.controllproject.R;
import com.example.controllproject.pin.PinActivity;
import com.example.controllproject.setting.SettingActivity;

public class RemoveFingerPrintActivity extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_finger_print);
        btn = findViewById(R.id.btn_confirm_);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RemoveFingerPrintActivity.this, SettingActivity.class ));
                finish();
            }
        });
    }
}
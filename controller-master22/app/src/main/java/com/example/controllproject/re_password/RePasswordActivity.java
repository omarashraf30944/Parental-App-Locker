package com.example.controllproject.re_password;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.controllproject.R;
import com.example.controllproject.re_password.rest_password.ResetPasswordActivity;
import com.example.controllproject.setting.SettingActivity;

import java.util.Objects;

public class RePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_password);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Setting");
        ImageView next_re_password = findViewById(R.id.next_re_password);
        next_re_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RePasswordActivity.this, ResetPasswordActivity.class));
                finish();
            }
        });
    }
}
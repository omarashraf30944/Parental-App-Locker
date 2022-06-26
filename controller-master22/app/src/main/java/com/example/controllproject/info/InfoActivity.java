package com.example.controllproject.info;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.controllproject.R;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        getSupportActionBar().setTitle("Setting");
    }
}
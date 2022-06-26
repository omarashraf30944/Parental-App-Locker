package com.example.controllproject.finger_print;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.controllproject.R;
import com.example.controllproject.finger_print.remove.RemoveFingerActivity;
import com.example.controllproject.finger_print.remove.RemoveFingerPrintActivity;
import com.example.controllproject.pin.PinActivity;

public class FingerActivity extends AppCompatActivity {
TextView remove_finger , add_finger ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger);
        getSupportActionBar().setTitle("Setting");

        remove_finger= findViewById(R.id.remove_finger);
        add_finger= findViewById(R.id.add_finger);


        remove_finger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FingerActivity.this, RemoveFingerActivity.class));
            }
        });

        add_finger.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FingerActivity.this, PinActivity.class));
            }
        });
    }
}
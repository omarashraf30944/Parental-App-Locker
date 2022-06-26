package com.example.controllproject.finger_print.remove;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.controllproject.R;
import com.example.controllproject.pin.PinActivity;

public class RemoveFingerActivity extends AppCompatActivity {
    ImageView next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_finger);
        getSupportActionBar().setTitle("Setting");
        next=findViewById(R.id.next);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RemoveFingerActivity.this, RemoveFingerPrintActivity.class));
            }
        });

    }
}
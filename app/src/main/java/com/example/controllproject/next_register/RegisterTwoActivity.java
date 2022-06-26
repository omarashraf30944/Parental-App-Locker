package com.example.controllproject.next_register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.controllproject.MainActivity;
import com.example.controllproject.R;
import com.google.android.material.button.MaterialButton;

public class RegisterTwoActivity extends AppCompatActivity {
    ImageView img1,img2,img3;
    boolean finger1,finger2,finger3;
    MaterialButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_two);
        btn = findViewById(R.id.btn_confirm);
        img1 = findViewById(R.id.finger1);
        img2 = findViewById(R.id.finger2);
        img3 = findViewById(R.id.finger3);

        startActivity(new Intent(RegisterTwoActivity.this, MainActivity.class));


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                if (finger1 && finger2 && finger3) {
                    startActivity(new Intent(RegisterTwoActivity.this, MainActivity.class));
//                }
            }
        });

    }
}
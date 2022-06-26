package com.example.controllproject.re_email;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.controllproject.R;
import com.example.controllproject.finger_print.FingerActivity;
import com.example.controllproject.finger_print.remove.RemoveFingerActivity;
import com.example.controllproject.re_email.reset_password.ResetEmailActivity;

public class ReEmailActivity extends AppCompatActivity {
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_re_email);
        imageView= findViewById(R.id.next_email);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ReEmailActivity.this, ResetEmailActivity.class));
            }
        });
    }
}
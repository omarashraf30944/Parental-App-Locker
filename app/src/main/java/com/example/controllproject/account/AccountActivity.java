package com.example.controllproject.account;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.controllproject.R;
import com.example.controllproject.re_email.ReEmailActivity;
import com.example.controllproject.re_password.RePasswordActivity;

import java.util.Objects;

public class AccountActivity extends AppCompatActivity {
    ConstraintLayout change_password , change_email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        Objects.requireNonNull(getSupportActionBar()).setTitle("Setting");

        change_password= findViewById(R.id.change_password);
        change_email= findViewById(R.id.change_email);

        change_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountActivity.this , RePasswordActivity.class));
            }
        });

        change_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(AccountActivity.this , ReEmailActivity.class));
            }
        });

    }
}
package com.example.controllproject.register;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.controllproject.R;
import com.example.controllproject.next_register.RegisterTwoActivity;
import com.google.android.material.textfield.TextInputLayout;

public class RegisterActivity extends AppCompatActivity {
    ImageView imageView;
    TextInputLayout  name , email , re_password , password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        imageView = findViewById(R.id.next);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        re_password = findViewById(R.id.confirm_password);
        password = findViewById(R.id.password);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String email1  = email.getEditText().getText().toString();
                String name1  = name.getEditText().getText().toString();
                String re_password1  = re_password.getEditText().getText().toString();
                String password1  = password.getEditText().getText().toString();

                if (email1.isEmpty()&& name1.isEmpty() && re_password1.isEmpty()&& password1.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Check Data empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!password1.equals(re_password1)) {
                    Toast.makeText(RegisterActivity.this, "password and confirm password not mach", Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(new Intent(RegisterActivity.this, RegisterTwoActivity.class));
            }
        });
    }
}
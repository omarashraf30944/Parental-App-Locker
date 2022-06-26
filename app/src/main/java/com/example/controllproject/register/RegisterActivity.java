package com.example.controllproject.register;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.controllproject.MainActivity;
import com.example.controllproject.PreferenceManager;
import com.example.controllproject.R;
import com.example.controllproject.next_register.RegisterTwoActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Locale;
import java.util.concurrent.ConcurrentNavigableMap;

public class RegisterActivity extends AppCompatActivity {
    ImageView imageView;
    TextInputLayout  name , email , re_password , password;

    FirebaseAuth fAuth;

    PreferenceManager preferenceManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        fAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        imageView = findViewById(R.id.next);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        re_password = findViewById(R.id.confirm_password);
        password = findViewById(R.id.password);

        preferenceManager = new PreferenceManager(this);

        if(fAuth.getCurrentUser() != null){
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 String email1  = email.getEditText().getText().toString().trim() ;
                String name1  = name.getEditText().getText().toString().trim();
                String re_password1  = re_password.getEditText().getText().toString().trim();
                String password1  = password.getEditText().getText().toString().trim();

                if (email1.isEmpty()&& name1.isEmpty() && re_password1.isEmpty()&& password1.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Check Data empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!password1.equals(re_password1)) {
                    Toast.makeText(RegisterActivity.this, "password and confirm password not mach", Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(new Intent(RegisterActivity.this, RegisterTwoActivity.class));

                fAuth.createUserWithEmailAndPassword(email1,password1).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            preferenceManager.putString("email" ,email1);
                            preferenceManager.putString("username" ,name1);
                            Toast.makeText(RegisterActivity.this, "User created", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        }else {
                            Toast.makeText(RegisterActivity.this, "Error" + task.getException().getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    }
                });
            }

        });





    }
}
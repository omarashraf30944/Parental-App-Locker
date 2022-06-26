package com.example.controllproject.login;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.biometric.BiometricPrompt;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.concurrent.Executor;
import android.widget.ImageView;
import com.example.controllproject.MainActivity;
import com.example.controllproject.R;
import com.example.controllproject.databinding.ActivityLoginBinding;
import com.example.controllproject.login_now.LoginNowActivity;
import com.example.controllproject.register.RegisterActivity;


public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;
    private TextView textView;
    private ImageView imageView;


    EditText et_pass;
    Button b_enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        textView = findViewById(R.id.tv_click);
        imageView = findViewById(R.id.img);
        et_pass = findViewById(R.id.et_pass);
        b_enter = findViewById(R.id.b_enter);
        b_enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = et_pass.getText().toString();
                if (!input.equals("")) {
                    if (input.equals(getCurrentPassword())) {
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Wrong password!", Toast.LENGTH_SHORT).show();
                    }}
                else {
                        Toast.makeText(LoginActivity.this, "Enter password!", Toast.LENGTH_SHORT).show();
                    }

                }


        });

        //init biometric
        //fingerprint unlock of app in splash
        executor = ContextCompat.getMainExecutor(this);
        biometricPrompt = new BiometricPrompt(LoginActivity.this, executor,
                new BiometricPrompt.AuthenticationCallback() {
                    @Override
                    public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                        super.onAuthenticationError(errorCode, errString);

                        textView.setText("Authentication error " + errString);
                        Toast.makeText(LoginActivity.this, "Authentication error", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                        super.onAuthenticationSucceeded(result);
                        textView.setText("Authentication succeed...!");
                        Toast.makeText(LoginActivity.this, "Authentication succeed...!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);

                    }

                    @Override
                    public void onAuthenticationFailed() {
                        super.onAuthenticationFailed();
                        textView.setText("Authentication failed...!");
                        Toast.makeText(LoginActivity.this, "Authentication failed...!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(LoginActivity.this, Failed.class);
                        startActivity(intent);
                    }
                });

        //setup dialog title and description
        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Fingerprint Authentication")
                .setSubtitle("Login using fingerPrint")
                .setNegativeButtonText("Close dialog")
                .build();


        //button click handler
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                biometricPrompt.authenticate(promptInfo);
            }
        });


        binding.login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this, LoginNowActivity.class));
            }
        });

    }

    private String getCurrentPassword(){

        Calendar calendar = Calendar.getInstance();
        int carHours12 = calendar.get(Calendar.HOUR);

        int carMinutes = calendar.get(Calendar.MINUTE);

        return carHours12 + "" +  carMinutes ;

    }

}

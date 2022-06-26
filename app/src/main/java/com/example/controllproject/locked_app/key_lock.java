package com.example.controllproject.locked_app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import com.example.controllproject.databinding.ActivityKeyLockBinding;
import com.example.controllproject.R;
import com.example.controllproject.databinding.ActivityKeyLockBinding;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;
import java.util.concurrent.Executor;

public class key_lock extends AppCompatActivity {
    EditText editText;
    Button button;
    String password = "default text ";
    TextInputLayout textInputLayout;
    String appName;
    PreferenceManager preferenceManager;
    ActivityKeyLockBinding binding;
    private static final String TAG = "Cannot invoke method length() on null object";
    private Executor executor;
    private BiometricPrompt biometricPrompt;
    private BiometricPrompt.PromptInfo promptInfo;



    @SuppressLint("LongLogTag")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_key_lock);
        preferenceManager = new PreferenceManager(getApplicationContext());
        Bundle extras = getIntent().getExtras();
        if(extras != null){
            appName = extras.getString("appName");
        }

        textInputLayout = findViewById(R.id.password);
        button = findViewById(R.id.check_password);
        String passwordEditText = binding.password.getEditText().getText().toString();

        //check application password to unlock it
        binding.checkPassword.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {
                binding.passwordTV.setText(binding.password.getEditText().getText().toString());
                password = binding.passwordTV.getText().toString();

                Toast.makeText(getApplicationContext(), password, Toast.LENGTH_SHORT).show();
                Log.i(TAG, "onClick: " + password);
                Log.i(TAG, "onClick:edit text " + passwordEditText);


                if(Objects.equals(password,"123")){
                    preferenceManager.putBoolean(appName,false);
                    Log.i(TAG, "onClick: "+ preferenceManager.getBoolean(appName));
                    Toast.makeText(getApplicationContext(), password, Toast.LENGTH_SHORT).show();
                }
                else {
                    preferenceManager.putBoolean(appName,false);
                    Toast.makeText(getApplicationContext(), password, Toast.LENGTH_SHORT).show();
                }
            }
        });

        //unlock locked application using device's fingerprint
        executor = ContextCompat.getMainExecutor(this);
        biometricPrompt = new BiometricPrompt(key_lock.this, executor,
                new BiometricPrompt.AuthenticationCallback() {
                    @Override
                    public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                        super.onAuthenticationError(errorCode, errString);
                    }

                    @Override
                    public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                        super.onAuthenticationSucceeded(result);
                        preferenceManager.putBoolean(appName,false);
                        Log.i(TAG, "onClick: "+ preferenceManager.getBoolean(appName));
                        Toast.makeText(key_lock.this, "App Unlocked...!", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAuthenticationFailed() {
                        super.onAuthenticationFailed();
                        Toast.makeText(key_lock.this, "Authentication failed...!", Toast.LENGTH_SHORT).show();
                    }
                });

        //setup dialog title and description
        promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Fingerprint Authentication")
                .setSubtitle("Login using fingerPrint")
                .setNegativeButtonText("Close dialog")
                .build();


        //button click handler
        binding.fingerPrintCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                biometricPrompt.authenticate(promptInfo);
            }
        });








    }
}